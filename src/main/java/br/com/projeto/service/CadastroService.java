package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.UserDao;
import br.com.projeto.entity.User;
import br.com.projeto.util.CryptUtils;

@Service
public class CadastroService {

	
	/*@Autowired
	private GenericDao genericDao;*/
	@Autowired
	private UserDao userDao;

	
	public User cadastrarUsuario(String login, String password) {
		User user = new User();
		user.setLogin(login);
		user.setPassword(CryptUtils.md5(password));
		userDao.insert(user);
		
		return user;
	}

}
