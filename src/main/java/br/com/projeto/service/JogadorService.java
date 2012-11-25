package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.JogadorDao;
import br.com.projeto.entity.Jogador;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorDao jogadorDao;
	
	public Jogador findByLogin(String login) {
		return jogadorDao.getJogador(login);
	}
}