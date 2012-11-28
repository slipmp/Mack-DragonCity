package br.com.projeto.service;

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
		
		Jogo jogo = jogoDao.getJogo(jogador.getCodigo());

		if (jogo == null)
			jogoService.criar_novo_jogo(jogador);
			
		//session.setAttribute("jogador", jogador);
		session.setAttribute("jogo", jogo);
		
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
	
}