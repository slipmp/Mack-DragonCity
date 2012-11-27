package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.businessrules.JogoRegrasNegocio;
import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.JogoDao;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;

@Service
public class JogoService extends GenericDao{
	
	@Autowired
	private JogoDao jogoDao;
		
	public Jogo findById(int idJogador) {
		return jogoDao.findById(Jogo.class, idJogador);
	}
		
	public Jogo criar_novo_jogo(Jogador jogador)
	{
		JogoRegrasNegocio regra_jogo = new JogoRegrasNegocio();
		System.out.println("passou: Antes do metodo criar regra_jogo.CriarNovoJogo");
		Jogo jogo = regra_jogo.CriarNovoJogo(jogador);
		System.out.println("passou: Depois do metodo criar regra_jogo.CriarNovoJogo");
		jogoDao.insert(jogo);
		System.out.println("passou: Depois do insert");
		
		return jogo;
	}
		
}
