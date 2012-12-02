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
	private JogadorService serviceJogador;
	
	@RequestMapping("/jogador/login")
	public String login(@RequestParam(value="usuario",required=false) String login,
						 @RequestParam(value="senha",required=false) String password,
						 @RequestParam(value="requestedUrl",required=false) String requestedUrl,
						 HttpSession session) throws ServletException, IOException {
		
		Jogador jogador = serviceJogador.login(login, password);

		if(jogador!=null)
		{
			session.setAttribute("jogador", jogador);
			
			if(StringUtils.isNotBlank(requestedUrl))
			{		
				return"redirect:"+requestedUrl.replaceAll("\\$10","?").replaceAll("\\$11","&");
			}
			else
			{
				return "/jogo/carregar_jogo.action";
			}		
		}
		return "redirect:/index.jsp?error=Usuario e/ou senha invalidos";
	}
	
	@RequestMapping("/jogador/logout")
	public String logout(HttpSession session) throws Exception {
		if(session.getAttribute(Constants.USER_ADMIN) != null)
			session.removeAttribute(Constants.USER_ADMIN);
		
		return "redirect:/index.jsp";
	}
}
