package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.JogadorDao;
import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.JogoDao;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;
import br.com.projeto.entity.Mapa;
import br.com.projeto.entity.User;
import br.com.projeto.util.CryptUtils;

@Service
public class JogoService extends GenericDao{
	
	@Autowired
	private JogoDao jogoDao;
		
	public Jogo findById(int idJogador) {
		return jogoDao.findById(Jogo.class, idJogador);
	}
		
	public Jogo criar_novo_jogo(Jogador jogador)
	{
		Jogo jogo = new Jogo();
		jogo.setJogador(jogador);
		//jogo.setMapa(new Mapa());
		jogo.setQtdTotalPontosXP(0);
		jogo.setVlrTotalComida(1000);
		jogo.setVlrTotalOuro(2000);
		
		jogoDao.insert(jogo);
		
		return jogo;		
	}
}
