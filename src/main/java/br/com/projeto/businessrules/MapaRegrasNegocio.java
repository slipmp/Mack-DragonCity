/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.businessrules;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.entity.CasaCentral;
import br.com.projeto.entity.Mapa;
import br.com.projeto.entity.MapaLocal;

/**
 *
 * @author Slipmp
 */
public class MapaRegrasNegocio 
{
    public Mapa getNovoMapa()
    {
        Mapa oMapa=new Mapa();
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
    
    public MapaLocal getMapaLocalPorPosicao(Mapa oMapa,int x,int y)
    {
        for(MapaLocal oMapaLocal:oMapa.getoListMapaLocal())
        {
            if(oMapaLocal.getPosicaoX()==x && oMapaLocal.getPosicaoY()==y) {
                return oMapaLocal;
            }
        }
        return null;
    }
    
    public CasaCentral RetornarCasaCentralPorMapa(Mapa oMapa)
    {
        for(MapaLocal oMapaLocal:oMapa.getoListMapaLocal())
        {
            if(oMapaLocal.getConstrucao() instanceof CasaCentral ) {
                return (CasaCentral)oMapaLocal.getConstrucao();
            }
        }
        return null;
    }
}
