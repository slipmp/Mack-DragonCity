package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.UserDao;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.User;
import br.com.projeto.util.CryptUtils;

@Service
public class CadastroService {

	
	/*@Autowired
	private GenericDao genericDao;*/
	@Autowired
	private UserDao userDao;

	
	public Jogador cadastrarJogador(String login, String password) {
		Jogador jogador = new Jogador();
		jogador.setLogin(login);
		jogador.setSenha(CryptUtils.md5(password));
		userDao.insert(jogador);
		
		return jogador;
	}

}
