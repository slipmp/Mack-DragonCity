package br.com.projeto.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="IdConstrucao")
@Table(name = "tbConstrucao")
public abstract class Construcao extends Entidade implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8881031051553347604L;
	@OneToOne
	@JoinColumn(name ="IdMapaLocal")
    private MapaLocal mapaLocal;

    public MapaLocal getMapaLocal() {
        return mapaLocal;
    }

    public void setMapaLocal(MapaLocal mapaLocal) {
        this.mapaLocal = mapaLocal;
    }
    public abstract String getNome();
}
