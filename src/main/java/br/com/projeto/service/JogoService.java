package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.businessrules.JogoRegrasNegocio;
import br.com.projeto.businessrules.MapaRegrasNegocio;
import br.com.projeto.businessrules.NivelRegrasNegocio;
import br.com.projeto.dao.CasaCentralDao;
import br.com.projeto.dao.DragaoDao;
import br.com.projeto.dao.DragaoTipoDao;
import br.com.projeto.dao.FazendaDao;
import br.com.projeto.dao.FrutaDao;
import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.HabitatDao;
import br.com.projeto.dao.HabitatTipoDao;
import br.com.projeto.dao.JogoDao;
import br.com.projeto.entity.CasaCentral;
import br.com.projeto.entity.Dragao;
import br.com.projeto.entity.DragaoTipo;
import br.com.projeto.entity.Fazenda;
import br.com.projeto.entity.Fruta;
import br.com.projeto.entity.Habitat;
import br.com.projeto.entity.HabitatTipo;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;
import br.com.projeto.entity.MapaLocal;

@Service
public class JogoService extends GenericDao{
	
	@Autowired
	private JogoDao jogoDao;
	
	@Autowired
	private DragaoTipoDao dragaoTipoDao;
	
	@Autowired
	private DragaoDao dragaoDao;
	
	@Autowired
	private FazendaDao fazendaDao;
	
	@Autowired
	private HabitatTipoDao habitatTipoDao;

	@Autowired
	private HabitatDao habitatDao;
	
	@Autowired
	private FrutaDao frutaDao;
	
	@Autowired
	private CasaCentralDao casaCentralDao;
	
	public Jogo carregarJogo(int id) 
	{
		return jogoDao.findById(Jogo.class, id);
	}
		
	public Jogo criarNovoJogo(Jogador jogador)
	{
		JogoRegrasNegocio regra_jogo = new JogoRegrasNegocio();
		Jogo jogo = regra_jogo.CriarNovoJogo(jogador);
		jogador.setJogo(jogo);
		jogoDao.insert(jogo);
		
		return jogo;
	}
	
	public int calcularNivel(int qtdTotalPontosXP)
	{
		NivelRegrasNegocio regra_nivel  = new NivelRegrasNegocio();
		int nmr_nivel = regra_nivel.getNivelEquivalente(qtdTotalPontosXP).getCodigo();
		return nmr_nivel;
	}	
	
	public String validarOvoCasaCentral(Jogo jogo, int cdgTipoDragaoEscolhido)
	{
		DragaoTipo dragaoTipo =  dragaoTipoDao.findById(DragaoTipo.class, cdgTipoDragaoEscolhido);
		
		if (dragaoTipo != null)
		{
			NivelRegrasNegocio nivel_regras_negocio = new NivelRegrasNegocio();
		
			if (dragaoTipo.getLevelJogadorRequerido() > nivel_regras_negocio.getNivelEquivalente(jogo.getQtdTotalPontosXP()).getCodigo())
			{
				dragaoTipo = null;
				return "Você não possui level para adquirir esse dragão!";
			}
			else if (dragaoTipo.getValor() > jogo.getVlrTotalOuro())
			{
				dragaoTipo = null;
				return "Você não possui Ouro suficiente para aquirir esse dragão!";
			}
		}
		
		return "";
	}
	
	public String criarOvoCasaCentral(Jogo jogo, int cdgTipoDragaoEscolhido, String nomeDragao)
	{
		DragaoTipo dragaoTipo =  dragaoTipoDao.findById(DragaoTipo.class, cdgTipoDragaoEscolhido);
		
		Dragao dragao = new Dragao();
		dragao.setDragaoTipo(dragaoTipo);
		dragao.setNomeDragao(nomeDragao);
		dragao.setJogo(jogo);
		dragaoDao.insert(dragao); 
		
		MapaRegrasNegocio mapaRegrasNegocio = new MapaRegrasNegocio();
		MapaLocal mapaLocal = mapaRegrasNegocio.getMapaLocalPorPosicao(jogo.getMapa(), 1, 1);
		CasaCentral casaCentral = ((CasaCentral)mapaLocal.getConstrucao());
		casaCentral.setOvo(dragao);
		casaCentralDao.update(casaCentral);
		
		jogo.setVlrTotalOuro(jogo.getVlrTotalOuro() - dragao.getValor());
		jogo.setQtdTotalPontosXP(jogo.getQtdTotalPontosXP() + dragao.getDragaoTipo().getPontosXPFornece());
		jogoDao.update(jogo);
		
		return "Você ganhou " + dragao.getDragaoTipo().getPontosXPFornece() + " pontos XP!";
	}
	
	public String construirFazenda(Jogo jogo, int posicaoX, int posicaoY)
	{
		MapaRegrasNegocio mapaRegrasNegocio = new MapaRegrasNegocio();
		MapaLocal mapaLocal = mapaRegrasNegocio.getMapaLocalPorPosicao(jogo.getMapa(), posicaoX, posicaoY);
		
		Fazenda fazenda = new Fazenda();
		mapaLocal.setConstrucao(fazenda);
		
		jogo.setVlrTotalOuro(jogo.getVlrTotalOuro() - fazenda.getValor());
		jogo.setQtdTotalPontosXP(jogo.getQtdTotalPontosXP() + fazenda.getPontosXP());
		fazendaDao.insert(fazenda);
		jogoDao.update(jogo);
		
		return "Você ganhou " + fazenda.getPontosXP() + " pontos XP!";
	}
	
	public String construirHabitat(Jogo jogo, int posicaoX, int posicaoY, int cdgTipoHabitatEscolhido)
	{
		MapaRegrasNegocio mapaRegrasNegocio = new MapaRegrasNegocio();
		MapaLocal mapaLocal = mapaRegrasNegocio.getMapaLocalPorPosicao(jogo.getMapa(), posicaoX, posicaoY);
			
		HabitatTipo habitatTipo = habitatTipoDao.findById(HabitatTipo.class, cdgTipoHabitatEscolhido);
			
		Habitat habitat = new Habitat();
		habitat.setHabitatTipo(habitatTipo);
		mapaLocal.setConstrucao(habitat);
		
		jogo.setVlrTotalOuro(jogo.getVlrTotalOuro() - habitat.getValor());
		jogo.setQtdTotalPontosXP(jogo.getQtdTotalPontosXP() + habitat.getPontosXP());
		habitatDao.insert(habitat);
		jogoDao.update(jogo);
		
		return "Você ganhou " + habitat.getPontosXP() + " pontos XP!";
	}
	
	public String inserirOvoHabitat(Jogo jogo, int posicaoX, int posicaoY)
	{
		MapaRegrasNegocio mapaRegrasNegocio = new MapaRegrasNegocio();
		MapaLocal mapaLocal = mapaRegrasNegocio.getMapaLocalPorPosicao(jogo.getMapa(), posicaoX, posicaoY);
		
		Habitat habitat = (Habitat)mapaLocal.getConstrucao();
		CasaCentral casaCentral = ((CasaCentral)mapaLocal.getConstrucao());
		
		//habitat.setoDragao(casaCentral)
		
		return "";
	}
	
	public String adicionarOuroPontosDragao(Jogo jogo, int posicaoX, int posicaoY)
	{
		MapaRegrasNegocio mapaRegrasNegocio = new MapaRegrasNegocio();
		MapaLocal mapaLocal = mapaRegrasNegocio.getMapaLocalPorPosicao(jogo.getMapa(), posicaoX, posicaoY);
		
		Habitat habitat = (Habitat)mapaLocal.getConstrucao();
		jogo.setVlrTotalOuro(jogo.getVlrTotalOuro() + habitat.getoDragao().getDragaoTipo().getOuroFornece());
		jogo.setQtdTotalPontosXP(jogo.getQtdTotalPontosXP()+10);
		jogoDao.update(jogo);
		
		return "Você ganhou " + habitat.getoDragao().getDragaoTipo().getOuroFornece() + " de ouro!\nE 10 pontos XP. \nAgora o seu dragão está no nível " + habitat.getoDragao().getLevel()+".";
	}	
	
	public String alimentarDragao(Jogo jogo, int posicaoX, int posicaoY, int qtdAlimento)
	{
		MapaRegrasNegocio mapaRegrasNegocio = new MapaRegrasNegocio();
		MapaLocal mapaLocal = mapaRegrasNegocio.getMapaLocalPorPosicao(jogo.getMapa(), posicaoX, posicaoY);
		
		Habitat habitat = (Habitat)mapaLocal.getConstrucao();
		habitat.getoDragao().setTotalExperiencia(habitat.getoDragao().getTotalExperiencia() + qtdAlimento);
		habitatDao.update(habitat);
		
		jogo.setVlrTotalComida(jogo.getVlrTotalComida() - qtdAlimento);
		jogoDao.update(jogo);
		
		return "";
	}
	
	public String adicionarAlimento(Jogo jogo)
	{
		Fruta fruta = new Fruta();
		frutaDao.insert(fruta);
		
		jogo.setVlrTotalComida(jogo.getVlrTotalComida() + fruta.getQuantidadeAlimento());
		jogo.setQtdTotalPontosXP(jogo.getQtdTotalPontosXP() + 10);
		jogoDao.update(jogo);
		
		return "Você ganhou " + fruta.getQuantidadeAlimento() + " de frutas!\n E 10 pontos de XP!";
	}
}
