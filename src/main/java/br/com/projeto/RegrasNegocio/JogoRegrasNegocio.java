package RegrasNegocio;

import java.util.Date;

/**
 * @author Slipmp
 */
public class JogoRegrasNegocio 
{
    private AcessoDados.JogoDados oJogoDados=new AcessoDados.JogoDados();
    
    public Entidades.Jogo CriarNovoJogo(Entidades.Jogador oJogador)
    {
        Entidades.Jogo oJogo=new Entidades.Jogo();
        
        oJogador.setData_ultimo_acesso(new Date());
        oJogo.setJogador(oJogador);
        
        oJogo.setQtdTotalPontosXP(0);
        oJogo.setVlrTotalComida(1000);
        oJogo.setVlrTotalOuro(2000);
        
        NivelRegrasNegocio oNivelRegrasNegocio=new NivelRegrasNegocio();
        
        MapaRegrasNegocio oMapaRegrasNegocio=new MapaRegrasNegocio();
        Entidades.Mapa oMapa=oMapaRegrasNegocio.getNovoMapa();
        
        oJogo.setMapa(oMapa);
        
        return oJogo;
    }
    
    public Entidades.Jogo LerJogo() throws Exception
    {
        return oJogoDados.LerJogo();
    }
    public void GravarJogo(Entidades.Jogo oJogo) throws Exception
    {
        oJogoDados.GravarJogo(oJogo);
    }
}
