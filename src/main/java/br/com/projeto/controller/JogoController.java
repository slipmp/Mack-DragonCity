package br.com.projeto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projeto.entity.User;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;
import br.com.projeto.service.JogadorService;
import br.com.projeto.service.JogoService;
import br.com.projeto.util.Constants;

@Controller
public class JogoController {
	
	@Autowired
	private JogadorService jogadorService;
	
	@Autowired
	private JogoService jogoService;
	
	@RequestMapping("/jogo/inicio")
	public String carregarJogo(HttpSession session) {
		
		if (session.getAttribute(Constants.USER_ADMIN) != null) {
			
			User usuario = null;
			usuario = (User) session.getAttribute(Constants.USER_ADMIN);
			Jogador jogador = jogadorService.findByLogin(usuario.getLogin());
			Jogo jogo = jogoService.findById(jogador.getCodigo());
			
			session.setAttribute("jogador", jogador);
			session.setAttribute("jogo", jogo);
			session.setAttribute("qtd_total_ouro", jogo.getVlrTotalOuro());
			session.setAttribute("qtd_total_comida", jogo.getVlrTotalComida());
			session.setAttribute("qtd_total_pontosXP", jogo.getQtdTotalPontosXP());
			session.setAttribute("qtd_total_dragao", jogo.getListDragao().size());
			session.setAttribute("nme_jogador", jogador.getNome());
			
			return "redirect:/jogo.jsp?" + jogo.getCodigo();
		}
		
		return "redirect:/jogo.jsp";
	}
	
	@RequestMapping("/jogo/novojogo")
	public String carregarNovoJogo(HttpSession session) {
		
		if (session.getAttribute(Constants.USER_ADMIN) != null) {
			
			Jogador jogador = (Jogador)session.getAttribute("jogador");
			Jogo jogo = jogoService.criar_novo_jogo(jogador);
			
			session.setAttribute("jogador", jogador);
			session.setAttribute("jogo", jogo);
			session.setAttribute("qtd_total_ouro", jogo.getVlrTotalOuro());
			session.setAttribute("qtd_total_comida", jogo.getVlrTotalComida());
			session.setAttribute("qtd_total_pontosXP", jogo.getQtdTotalPontosXP());
			session.setAttribute("qtd_total_dragao", jogo.getListDragao().size());
			session.setAttribute("nme_jogador", jogador.getNome());
			
			return "redirect:/jogo.jsp?" + jogo.getCodigo();

		}
		
		return "redirect:index.jsp";
	}	
}
