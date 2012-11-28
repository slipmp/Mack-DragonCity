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
        Mapa mapa = new Mapa();
        List<MapaLocal> lista_mapa_local = new ArrayList();
        
        mapa.setoListMapaLocal(lista_mapa_local);
        
        for(int x=1;x<=5;x++)
        {
            for(int y=1;y<=6;y++)
            {
                MapaLocal mapa_local = new MapaLocal();
                
                mapa_local.setMapa(mapa);
                mapa_local.setPosicaoX(x);
                mapa_local.setPosicaoY(y);
                
                if(x==1 && y==1)
                {
                    CasaCentral casa_central = new CasaCentral();
                    mapa_local.setConstrucao(casa_central);
                }
                else 
                {
                    mapa_local.setConstrucao(null);
                }
                
                lista_mapa_local.add(mapa_local);
            }
        }
        
        return mapa;
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
