package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.businessrules.JogoRegrasNegocio;
import br.com.projeto.businessrules.MapaRegrasNegocio;
import br.com.projeto.businessrules.NivelRegrasNegocio;
import br.com.projeto.dao.DragaoDao;
import br.com.projeto.dao.DragaoTipoDao;
import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.JogoDao;
import br.com.projeto.entity.CasaCentral;
import br.com.projeto.entity.Dragao;
import br.com.projeto.entity.DragaoTipo;
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
	
	public Jogo carregarJogo(int id) 
	{
		return jogoDao.findById(Jogo.class, id);
	}
		
	public Jogo criarNovoJogo(Jogador jogador)
	{
		// Cria o novo jogo.
		JogoRegrasNegocio regra_jogo = new JogoRegrasNegocio();
		Jogo jogo = regra_jogo.CriarNovoJogo(jogador);
		
		// Relaciona o novo jogo ao jogador.
		jogador.setJogo(jogo);
		
		// Marcos pq?: Erro ocorrendo quando insere o jogo setando o "Mapa".
		jogoDao.insert(jogo);
		
		System.out.println("Passou" + jogo.getCodigo());
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
		dragaoDao.insert(dragao); 
		
		MapaRegrasNegocio mapaRegrasNegocio = new MapaRegrasNegocio();
		MapaLocal mapaLocal = mapaRegrasNegocio.getMapaLocalPorPosicao(jogo.getMapa(), 1, 1);
		CasaCentral casaCentral = ((CasaCentral)mapaLocal.getConstrucao());
		casaCentral.setOvo(dragao);
		
		jogo.setVlrTotalOuro(jogo.getVlrTotalOuro() - dragao.getValor());
		jogo.setQtdTotalPontosXP(jogo.getQtdTotalPontosXP() + dragao.getDragaoTipo().getPontosXPFornece());
		jogoDao.update(jogo);
		
		return "Você ganhou " + dragao.getDragaoTipo().getPontosXPFornece() + " pontos XP!";
	}
}
