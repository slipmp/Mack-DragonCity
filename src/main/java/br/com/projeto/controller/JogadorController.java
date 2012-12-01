package br.com.projeto.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projeto.entity.Jogador;
import br.com.projeto.service.JogadorService;


public class JogadorController {

	@Autowired
	private JogadorService jogadorService;
	
	@RequestMapping("/adm/jogador/ativarJogador")
	public @ResponseBody void ativarJogador(@RequestParam(value="idJogador", required=true) String idJogador,
						 @RequestParam(value="ativar", required=true) String ativar) {
		jogadorService.ativarJogador(idJogador, ativar);
	}
	
	@RequestMapping("/adm/jogador/listarJogadores")
	public String listarPlayers(HttpSession session) {
		List<Jogador> listJogadores = jogadorService.listarJogadores();
		session.setAttribute("listJogadores", listJogadores);
		return "redirect:/adm/listarJogadores.jsp";
	}
}
