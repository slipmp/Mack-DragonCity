package br.com.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projeto.service.JogadorService;


public class JogadorController {

	@Autowired
	private JogadorService jogadorService;
	
	@RequestMapping("/adm/jogador/ativarJogador")
	public @ResponseBody void ativarJogador(@RequestParam(value="idJogador", required=true) String idJogador,
						 @RequestParam(value="ativar", required=true) String ativar) {
		
		System.out.println("Entrou no controle ativar ");
		jogadorService.ativarJogador(idJogador, ativar);
	}
}
