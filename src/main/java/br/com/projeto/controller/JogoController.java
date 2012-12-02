package br.com.projeto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;
import br.com.projeto.entity.User;
import br.com.projeto.service.JogadorService;
import br.com.projeto.service.JogoService;
import br.com.projeto.util.Constants;

@Controller
public class JogoController {
	
	@Autowired
	private JogoService jogoService;
	
	@RequestMapping("/jogo/carregar_jogo")
	public String carregarJogo(HttpSession session) {
		
		if (session != null)
		{
			Jogo jogo = null;
			Jogador jogador = (Jogador)session.getAttribute("jogador");
			
			if (jogador.getJogo()== null)
				jogo = jogoService.criarNovoJogo(jogador);
			else 
				jogo = jogoService.carregarJogo(jogador.getJogo().getCodigo());
			
			System.out.println("Jogador: " + jogador.getCodigo());
			System.out.println("Jogo: " + jogador.getJogo().getCodigo());
			System.out.println("Jogo: " + jogo);
			System.out.println("Ouro: " + jogo.getVlrTotalOuro());
			System.out.println("Commida: " + jogo.getVlrTotalComida());
			System.out.println("Pontos: " + jogo.getQtdTotalPontosXP());
			
			//session.setAttribute("jogo", jogo);
									
			return "redirect:/jogo.jsp?" + jogo.getCodigo();
		}
		else 
			return "redirect:/index.jsp?Erro:Sessao+nao+iniciada";
	}
	
	@RequestMapping("/jogo/novojogo")
	public String carregarNovoJogo(HttpSession session) 
	{
		if (session != null)
		{
			Jogador jogador = (Jogador)session.getAttribute("jogador");
			Jogo jogo = jogoService.criarNovoJogo(jogador);
			
			session.setAttribute("jogo", jogo);
		
			return "redirect:/jogo.jsp?" + jogo.getCodigo();
		}	
		
		return "redirect:index.jsp";
	}	
}
