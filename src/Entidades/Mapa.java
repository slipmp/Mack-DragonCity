package Entidades;

import java.util.List;

public class Mapa implements java.io.Serializable{

    public Mapa()
    {
        oListMapaLocal=null;
    }
    
    private List<MapaLocal> oListMapaLocal;

    public List<MapaLocal> getoListMapaLocal() {
        return oListMapaLocal;
    }

    public void setoListMapaLocal(List<MapaLocal> oListMapaLocal) {
        this.oListMapaLocal = oListMapaLocal;
    }
}
