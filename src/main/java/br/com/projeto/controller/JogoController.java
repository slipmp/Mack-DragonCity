package br.com.projeto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;
import br.com.projeto.service.JogoService;

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
						
			session.setAttribute("qtdTotalOuro", jogo.getVlrTotalOuro());
			session.setAttribute("qtdTotalComida", jogo.getVlrTotalComida());
									
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
	
	@RequestMapping("/jogo/casacentral")
	public String validarOvoCasaCentral(@RequestParam(value="cdgTipoDragaoEscolhido", required=false) String cdgTipoDragaoEscolhido,
			@RequestParam(value="nomeDragao", required=false) String nomeDragao,
			HttpSession session) throws ServletException, IOException 
	{		
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		String retorno = jogoService.validarOvoCasaCentral(jogo, Integer.parseInt(cdgTipoDragaoEscolhido));
		
		if (retorno == "")
			retorno = jogoService.criarOvoCasaCentral(jogo, Integer.parseInt(cdgTipoDragaoEscolhido), nomeDragao);

		session.setAttribute("retorno", retorno);
		//session.setAttribute("qtdTotalDragao", jogo.getListDragao().size());
		session.setAttribute("qtdTotalOuro", jogo.getVlrTotalOuro());
		session.setAttribute("qtdTotalComida", jogo.getVlrTotalComida());		
		
		return "redirect:/jogo.jsp?" + jogo.getCodigo();
	}
	
	@RequestMapping("/jogo/construirFazenda")
	public  String construirFazenda(@RequestParam(value="posicaoX", required=true) String posicaoX,
									   @RequestParam(value="posicaoY",required=true) String posicaoY,
									   HttpSession session)
	{
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		String retorno = jogoService.construirFazenda(jogo, Integer.parseInt(posicaoX), Integer.parseInt(posicaoY));
		
		session.setAttribute("retorno", retorno);
		//session.setAttribute("qtdTotalDragao", jogo.getListDragao().size());
		session.setAttribute("qtdTotalOuro", jogo.getVlrTotalOuro());
		session.setAttribute("qtdTotalComida", jogo.getVlrTotalComida());		
		
		return "redirect:/jogo.jsp?" + jogo.getCodigo();
	}
	
	@RequestMapping("/jogo/construirHabitat")
	public  String construirHabitat(@RequestParam(value="posicaoX", required=true) String posicaoX,
									   @RequestParam(value="posicaoY",required=true) String posicaoY,
									   @RequestParam(value="cdgTipoHabitatEscolhido",required=true) String cdgTipoHabitatEscolhido,
									   
									   HttpSession session)
	{
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		String retorno = jogoService.construirHabitat(jogo, Integer.parseInt(posicaoX), Integer.parseInt(posicaoY), Integer.parseInt(cdgTipoHabitatEscolhido));
		
		session.setAttribute("retorno", retorno);
		//session.setAttribute("qtdTotalDragao", jogo.getListDragao().size());
		session.setAttribute("qtdTotalOuro", jogo.getVlrTotalOuro());
		session.setAttribute("qtdTotalComida", jogo.getVlrTotalComida());		
		
		return "redirect:/jogo.jsp?" + jogo.getCodigo();
	}
	
	@RequestMapping("/jogo/adicionarOuroPontosDragao")
	public  String adicionarOuroPontosDragao(@RequestParam(value="posicaoX", required=true) String posicaoX,
			   								@RequestParam(value="posicaoY",required=true) String posicaoY,
			   								HttpSession session)
	{
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		String retorno = jogoService.adicionarOuroPontosDragao(jogo, Integer.parseInt(posicaoX), Integer.parseInt(posicaoY));
		
		session.setAttribute("retorno", retorno);
		//session.setAttribute("qtdTotalDragao", jogo.getListDragao().size());
		session.setAttribute("qtdTotalOuro", jogo.getVlrTotalOuro());
		session.setAttribute("qtdTotalComida", jogo.getVlrTotalComida());		
		
		return "redirect:/jogo.jsp?" + jogo.getCodigo();
	}

	@RequestMapping("/jogo/alimentarDragao")
	public  String alimentarDragao(@RequestParam(value="posicaoX", required=true) String posicaoX,
									@RequestParam(value="posicaoY",required=true) String posicaoY,
									@RequestParam(value="qtdAlimento", required=true) String qtdAlimento,
									HttpSession session)
	{
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		String retorno = jogoService.alimentarDragao(jogo, Integer.parseInt(posicaoX), Integer.parseInt(posicaoY), Integer.parseInt(qtdAlimento));
		
		session.setAttribute("retorno", retorno);
		//session.setAttribute("qtdTotalDragao", jogo.getListDragao().size());
		session.setAttribute("qtdTotalOuro", jogo.getVlrTotalOuro());
		session.setAttribute("qtdTotalComida", jogo.getVlrTotalComida());		
				
		return "redirect:/jogo.jsp?" + jogo.getCodigo();
	}	
	
	@RequestMapping("/jogo/adicionarAlimento")
	public  String adicionarAlimento(HttpSession session)
	{
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		String retorno = jogoService.adicionarAlimento(jogo);
		
		session.setAttribute("retorno", retorno);
		//session.setAttribute("qtdTotalDragao", jogo.getListDragao().size());
		session.setAttribute("qtdTotalOuro", jogo.getVlrTotalOuro());
		session.setAttribute("qtdTotalComida", jogo.getVlrTotalComida());		
		
		
		return "redirect:/jogo.jsp?" + jogo.getCodigo();
	}	
	
	@RequestMapping("/jogo/inserirOvoHabitat")
	public  String inserirOvoHabitat(@RequestParam(value="posicaoX", required=true) String posicaoX,
			@RequestParam(value="posicaoY",required=true) String posicaoY,
			HttpSession session)
	{
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		String retorno = jogoService.inserirOvoHabitat(jogo, Integer.parseInt(posicaoX), Integer.parseInt(posicaoY));
		
		session.setAttribute("retorno", retorno);
		//session.setAttribute("qtdTotalDragao", jogo.getListDragao().size());
		session.setAttribute("qtdTotalOuro", jogo.getVlrTotalOuro());
		session.setAttribute("qtdTotalComida", jogo.getVlrTotalComida());		
		
		
		return "redirect:/jogo.jsp?" + jogo.getCodigo();
	}	
}
