package br.com.projeto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/jogo/casacentral")
	public String validarOvoCasaCentral(@RequestParam(value="cdgTipoDragaoEscolhido", required=false) String cdgTipoDragaoEscolhido,
			@RequestParam(value="nomeDragao", required=false) String nomeDragao,
			HttpSession session) throws ServletException, IOException 
	{
		System.out.println("Entrou - casa central controller");
		System.out.println("Tipo de dragao: " + cdgTipoDragaoEscolhido);
		System.out.println("Nome Dragao: " + nomeDragao);
		
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		String retorno = jogoService.validarOvoCasaCentral(jogo, Integer.parseInt(cdgTipoDragaoEscolhido));
		
		if (retorno == "")
			retorno = jogoService.criarOvoCasaCentral(jogo, Integer.parseInt(cdgTipoDragaoEscolhido), nomeDragao);

		//return "redirect:/jogo.jsp?" + jogo.getCodigo() + "&retorno="+retorno;
		return "";
	}	
	/*public @ResponseBody String validarOvoCasaCentral(@RequestParam(value="idCdgTipoNomeDragao", required=true) String idCdgTipoDragaoEscolhido,
			HttpSession session)
	{
		System.out.println("Entrou - Validar casa central controller");
		System.out.println("Tipo de dragao: " + idCdgTipoDragaoEscolhido);
		
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		
		int cdgTipoDragaoEscolhido = Integer.parseInt((String)session.getAttribute("IdCdgTipoDragaoEscolhido"));
		
		String retorno = 
		return retorno;
	}*/
	
	@RequestMapping("/jogo/casacentral/criarovo")
	public  String CriarOvoCasaCentral(@RequestParam(value="CdgTipoDragaoEscolhido", required=true) String cdgTipoDragaoEscolhido,
									   @RequestParam(value="nomeDragao",required=true) String nomeDragao,
									   HttpSession session)
	{
		System.out.println("Entrou - Criar ovo na casa central controller");
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		System.out.println("Tipo dragao: " + cdgTipoDragaoEscolhido);
		return "redirect:jogo.jsp?retorno=aaaaa";
		//int cdg_tipo_dragao_escolhido = Integer.parseInt(cdgTipoDragaoEscolhido);		
		
		//String retorno = jogoService.criarOvoCasaCentral(jogo, cdg_tipo_dragao_escolhido, nomeDragao);
				
		//return retorno;
	}	
	/*public @ResponseBody String CriarOvoCasaCentral(@RequestParam(value="idCdgTipoNomeDragao", required=true) String idCdgTipoDragaoEscolhido,
													@RequestParam(value="nomeDragao",required=true) String nomeDragao,
													HttpSession session)
	{
		System.out.println("Entrou - Criar ovo na casa central controller");
		Jogo jogo = (Jogo)session.getAttribute("jogo");

		int cdg_tipo_dragao_escolhido = Integer.parseInt(idCdgTipoDragaoEscolhido);		
		
		String retorno = jogoService.criarOvoCasaCentral(jogo, cdg_tipo_dragao_escolhido, nomeDragao);
				
		return retorno;
	}*/
	
	
}
