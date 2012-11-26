package br.com.projeto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.entity.Jogador;
import br.com.projeto.service.JogadorService;
import br.com.projeto.util.Constants;

@Controller
public class LoginController1 {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private JogadorService service;

	@RequestMapping("/jogador/login")
	public String login(@RequestParam(value="usuario",required=false) String login,
						 @RequestParam(value="senha",required=false) String password,
						 @RequestParam(value="requestedUrl",required=false) String requestedUrl) throws ServletException, IOException {
		
		Jogador jogador = service.login(login, password);
		
		if(jogador!=null)
		{
			if(StringUtils.isNotBlank(requestedUrl))
			{		
				return"redirect:"+requestedUrl.replaceAll("\\$10","?").replaceAll("\\$11","&");
			}
			else
			{
				return "/jogo/inicio.action";
				//return "redirect:/jogo.jsp?" + user.getId();
			}		
		}
		return "redirect:/index.jsp?error=Usuário e/ou senha inválidos";
	}
	
	@RequestMapping("/adm/logout")
	public String logout(HttpSession session) throws Exception {
		if(session.getAttribute(Constants.USER_ADMIN) != null)
			session.removeAttribute(Constants.USER_ADMIN);
		
		return "redirect:/adm";
	}
}
