package br.com.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.businessrules.JogoRegrasNegocio;
import br.com.projeto.businessrules.NivelRegrasNegocio;
import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.JogoDao;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;

@Service
public class JogoService extends GenericDao{
	
	@Autowired
	private JogoDao jogoDao;
	
	public Jogo carregar_jogo(int id) 
	{
		
		return jogoDao.findById(Jogo.class, id);
		//return jogoDao.getJogo(id);
	}
		
	public Jogo criar_novo_jogo(Jogador jogador)
	{
		// Cria o novo jogo.
		JogoRegrasNegocio regra_jogo = new JogoRegrasNegocio();
		Jogo jogo = regra_jogo.CriarNovoJogo(jogador);
		
		// Relaciona o novo jogo ao jogador.
		jogador.setJogo(jogo);
		
		// Marcos pq?: Erro ocorrendo quando insere o jogo setando o "Mapa".
		jogoDao.insert(jogo);
		
		return jogo;
	}
	
	public int calcular_nivel(int qtdTotalPontosXP)
	{
		NivelRegrasNegocio regra_nivel  = new NivelRegrasNegocio();
		int nmr_nivel = regra_nivel.getNivelEquivalente(qtdTotalPontosXP).getCodigo();
		return nmr_nivel;
	}	
	
	
}
