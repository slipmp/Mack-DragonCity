package Entidades;

public abstract class Construcao extends Entidade implements java.io.Serializable{

    private MapaLocal mapaLocal;

    public MapaLocal getMapaLocal() {
        return mapaLocal;
    }

    public void setMapaLocal(MapaLocal mapaLocal) {
        this.mapaLocal = mapaLocal;
    }
    public abstract String getNome();
}
