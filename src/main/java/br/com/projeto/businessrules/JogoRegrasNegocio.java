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
    private JogoDados oJogoDados=new JogoDados();
    
    public Jogo CriarNovoJogo(Jogador oJogador)
    {
        Jogo oJogo=new Jogo();
        
        oJogador.setData_ultimo_acesso(new Date());
        oJogo.setJogador(oJogador);
        
        oJogo.setQtdTotalPontosXP(0);
        oJogo.setVlrTotalComida(1000);
        oJogo.setVlrTotalOuro(2000);
        
        NivelRegrasNegocio oNivelRegrasNegocio=new NivelRegrasNegocio();
        
        MapaRegrasNegocio oMapaRegrasNegocio=new MapaRegrasNegocio();
        Mapa oMapa=oMapaRegrasNegocio.getNovoMapa();
        
        oJogo.setMapa(oMapa);
        
        return oJogo;
    }
    
    public Jogo LerJogo() throws Exception
    {
        return oJogoDados.LerJogo();
    }
    public void GravarJogo(Jogo oJogo) throws Exception
    {
        oJogoDados.GravarJogo(oJogo);
    }
}
