package br.com.projeto.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbMapa")
public class Mapa implements java.io.Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4263803279951634095L;

	public Mapa()
    {
        oListMapaLocal=null;
    }
    
    @ManyToOne
    @JoinColumn(name="IdMapaLocal")
    private List<MapaLocal> oListMapaLocal;

    public List<MapaLocal> getoListMapaLocal() {
        return oListMapaLocal;
    }

    public void setoListMapaLocal(List<MapaLocal> oListMapaLocal) {
        this.oListMapaLocal = oListMapaLocal;
    }
}
