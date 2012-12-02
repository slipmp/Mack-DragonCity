package br.com.projeto.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.projeto.dao.JogadorDao;
import br.com.projeto.dao.JogoDao;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;
import br.com.projeto.util.CryptUtils;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorDao jogadorDao;
	
	@Autowired
	private JogoDao jogoDao;
	
	@Autowired
	private JogoService jogoService;
	
	public Jogador findByLogin(String login) 
	{
		return jogadorDao.getJogador(login);
	}
	
	public Jogador login(String login,String senha)
	{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
			
		Jogador jogador = jogadorDao.getJogador(login, CryptUtils.md5(senha));
				
		if (jogador == null)
			return null;
			
		Jogo jogo = null;
		
		if (jogador.getJogo() == null)
			jogo = jogoService.criarNovoJogo(jogador);
		else
			jogo = jogoDao.findById(Jogo.class, jogador.getJogo().getCodigo());
				
		int nmr_nivel_jogo = jogoService.calcularNivel(jogo.getQtdTotalPontosXP());

		session.setAttribute("jogo", jogo);
		session.setAttribute("nmr_nivel_jogo", nmr_nivel_jogo);
		
		return jogador;		
	}
	
	public Jogador cadastrarJogador(String login, String password, String nome) 
	{
		Jogador jogador = new Jogador();
		jogador.setLogin(login);
		jogador.setSenha(CryptUtils.md5(password));
		jogador.setNome(nome);
		jogador.setSituacao('A');
		jogadorDao.insert(jogador);
		
		return jogador;
	}
	
	public List<Jogador> listarJogadores() {
		return jogadorDao.listarJogadores();
	}
	
	public Jogador ativarJogador(String idJogador, String ativar) {
		Jogador jogador = jogadorDao.findById(Jogador.class, Long.parseLong(idJogador));
		
		char situacao = ativar.charAt(0);
		
		jogador.setSituacao(situacao);
		jogadorDao.update(jogador);
		return jogador;
	}
	
	public Jogador findById(String idJogador) {
		return jogadorDao.findById(Jogador.class, Long.parseLong(idJogador));
	}
}