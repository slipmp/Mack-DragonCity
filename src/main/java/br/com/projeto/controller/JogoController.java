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
				System.out.println("jogador: " + jogador.getCodigo() + " " + jogador);
				//jogo = jogoService.criar_novo_jogo(jogador);
			else 
				jogo = jogoService.carregar_jogo(jogador.getJogo().getCodigo());
			
			session.setAttribute("jogo", jogo);
									
			return "redirect:/jogo.jsp?";
		}
		else 
			return "redirect:/index.jsp?Erro:Sessao+nao+iniciada";
	}
	
	@RequestMapping("/jogo/novojogo")
	public String carregarNovoJogo(HttpSession session) {
		
		if (session.getAttribute(Constants.USER_ADMIN) != null) {
			
			Jogador jogador = (Jogador)session.getAttribute("jogador");
			Jogo jogo = jogoService.criar_novo_jogo(jogador);
			
			session.setAttribute("jogo", jogo);
			return "redirect:/jogo.jsp?" + jogo.getCodigo();
		}	
		return "redirect:index.jsp";
	}	
}
