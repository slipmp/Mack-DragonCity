package br.com.projeto.businessrules;

import java.util.Date;

import br.com.projeto.dao.JogoDados;
import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.Jogo;
import br.com.projeto.entity.Mapa;

/**
 * @author Slipmp
 */
public class JogoRegrasNegocio 
{
    private JogoDados jogoDados = new JogoDados();
    
    public Jogo CriarNovoJogo(Jogador jogador)
    {
    	try
    	{
    		Jogo jogo = new Jogo();
	        
	        jogador.setData_ultimo_acesso(new Date());
	        jogo.setJogador(jogador);
	        
	        jogo.setQtdTotalPontosXP(0);
	        jogo.setVlrTotalComida(1000);
	        jogo.setVlrTotalOuro(2000);
	        	        
	        MapaRegrasNegocio mapa_regra_negocio = new MapaRegrasNegocio();
	        Mapa mapa = mapa_regra_negocio.getNovoMapa();
      
	        jogo.setMapa(mapa);
	        
	        return jogo;
        
    	}
    	catch (Exception e)
    	{
    		System.out.println("Erro: Criar novo jogo" + e.getMessage());
    		return null;
    	}
    }
    
    public Jogo LerJogo() throws Exception
    {
        return jogoDados.LerJogo();
    }
    public void GravarJogo(Jogo oJogo) throws Exception
    {
        jogoDados.GravarJogo(oJogo);
    }
}
