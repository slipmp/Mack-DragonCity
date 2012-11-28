package br.com.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.service.JogadorService;

@Controller
public class CadastroController {

	@Autowired
	private JogadorService jogadorService;

	@RequestMapping("/jogador/cadastrar")
	public String cadastrarJogador(@RequestParam(value="login",required=true) String login,
						 @RequestParam(value="password",required=true) String password,
						 @RequestParam(value="nome",required=true) String nome) {
		jogadorService.cadastrarJogador(login, password, nome);
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
