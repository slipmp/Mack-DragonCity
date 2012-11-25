package br.com.projeto.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.projeto.dao.UserDao;
import br.com.projeto.entity.User;
import br.com.projeto.util.Constants;
import br.com.projeto.util.CryptUtils;

/**
 * @author Marcos Paulo
 * 
 */
@Service
public class UserService {

	@Autowired
	private UserDao dao;

	
	public User login(String login,String password){

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		
		System.out.println("login: " + login + " senha: " + password + " senha criptografada: " + CryptUtils.md5(password));
		
		User user = dao.getUser(login, CryptUtils.md5(password));
				
		if (user == null) {
			System.out.println("usuario nao encontrado");
			return null;
		}
		
		session.setAttribute(Constants.USER_ADMIN, user);
		
		return user;

	}

	public void logout(User user) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		
		if(session.getAttribute(Constants.USER_ADMIN) != null)
			session.removeAttribute(Constants.USER_ADMIN);
	}
	

}
