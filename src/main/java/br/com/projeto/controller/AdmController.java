package br.com.projeto.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.entity.Jogador;
import br.com.projeto.service.JogadorService;

@Controller
public class AdmController {

	@Autowired
	private JogadorService jogadorService;

	@RequestMapping("/adm/listarJogadores")
	public String listarjogadores(HttpSession session)  {
		System.out.println("entrou no list");
		
		List<Jogador> listJogadores = jogadorService.listarJogadores();
		session.setAttribute("listJogadores", listJogadores);	
		
		return "redirect:/adm/listarJogadores.jsp";
	}
}
