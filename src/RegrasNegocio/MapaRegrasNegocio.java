/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RegrasNegocio;

import Entidades.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Slipmp
 */
public class MapaRegrasNegocio 
{
    public Entidades.Mapa getNovoMapa()
    {
        Entidades.Mapa oMapa=new Entidades.Mapa();
        List<MapaLocal> oListMapaLocal=new ArrayList();
        
        oMapa.setoListMapaLocal(oListMapaLocal);
        
        for(int x=1;x<=5;x++)
        {
            for(int y=1;y<=6;y++)
            {
                MapaLocal oMapaLocal=new MapaLocal();
                oMapaLocal.setMapa(oMapa);
                oMapaLocal.setPosicaoX(x);
                oMapaLocal.setPosicaoY(y);
                if(x==1 && y==1)
                {
                    CasaCentral oCasaCentral=new CasaCentral();
                    oMapaLocal.setConstrucao(oCasaCentral);
                }
                else 
                {
                    oMapaLocal.setConstrucao(null);
                }
                oListMapaLocal.add(oMapaLocal);
            }
        }
        
        return oMapa;
    }
    
    public Entidades.MapaLocal getMapaLocalPorPosicao(Entidades.Mapa oMapa,int x,int y)
    {
        for(Entidades.MapaLocal oMapaLocal:oMapa.getoListMapaLocal())
        {
            if(oMapaLocal.getPosicaoX()==x && oMapaLocal.getPosicaoY()==y) {
                return oMapaLocal;
            }
        }
        return null;
    }
    
    public Entidades.CasaCentral RetornarCasaCentralPorMapa(Entidades.Mapa oMapa)
    {
        for(Entidades.MapaLocal oMapaLocal:oMapa.getoListMapaLocal())
        {
            if(oMapaLocal.getConstrucao() instanceof Entidades.CasaCentral ) {
                return (Entidades.CasaCentral)oMapaLocal.getConstrucao();
            }
        }
        return null;
    }
}
