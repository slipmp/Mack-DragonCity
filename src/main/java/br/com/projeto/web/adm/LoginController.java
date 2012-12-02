package br.com.projeto.web.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.User;
//import br.com.projeto.service.JogadorService;
import br.com.projeto.service.UserService;
import br.com.projeto.util.Constants;



@Controller
public class LoginController {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService service;
	//@Autowired
	//private JogadorService serviceJogador;


	@RequestMapping("/adm/login")
	public String login(@RequestParam(value="usuario",required=false) String login,
						 @RequestParam(value="senha",required=false) String password,
						 @RequestParam(value="requestedUrl",required=false) String requestedUrl) throws ServletException, IOException {
		
		
		User user = service.login(login, password);
		
		if (user != null) {	
			return "listarJogadores.action";
			//return "redirect:/adm/listarJogadores.jsp";
		 }
		
		//return "listarJogadores.action";
		return "redirect:/adm/login.jsp?error=UsuArio e/ou senha invAlidos";
			
	}
	
	@RequestMapping("/adm/logout")
	public String logout(HttpSession session) throws Exception {
		if(session.getAttribute(Constants.USER_ADMIN) != null)
			session.removeAttribute(Constants.USER_ADMIN);
		
		return "redirect:/adm";
	}
	
}