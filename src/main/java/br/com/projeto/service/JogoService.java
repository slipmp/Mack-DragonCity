package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.JogadorDao;
import br.com.projeto.dao.GenericDao;
import br.com.projeto.entity.Jogo;

@Service
public class JogoService extends GenericDao{
	
	@Autowired
	private JogadorDao jogoDao;
	
	public Jogo findById(int idJogador) {
		return jogoDao.findById(Jogo.class, idJogador);
	}
}
