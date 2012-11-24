package br.com.projeto.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import br.com.projeto.service.CadastroService;

@Controller
public class CadastroController {

	@Autowired
	private CadastroService cadastroService;

	@RequestMapping("/usuario/cadastrar")
	public String cadastrarUsuario(@RequestParam(value="login",required=true) String login,
						 @RequestParam(value="password",required=true) String password) {
		cadastroService.cadastrarUsuario(login, password);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/adm/cadastrar/cadastrar-home")
	public String cadastrar() {
		return "redirect:/adm/cadastrar-home.jsp";
	}
	
	@RequestMapping("/adm/players/players-home")
	public String players() {
		return "redirect:/adm/players-home.jsp";
	}
	
}
