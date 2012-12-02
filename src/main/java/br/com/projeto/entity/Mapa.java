package br.com.projeto.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbMapa")
public class Mapa implements java.io.Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4263803279951634095L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
    protected int codigo;
	
	public Mapa()
    {
        oListMapaLocal=null;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @OneToMany(mappedBy="mapa",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<MapaLocal> oListMapaLocal;

    public List<MapaLocal> getoListMapaLocal() {
        return oListMapaLocal;
    }

    public void setoListMapaLocal(List<MapaLocal> oListMapaLocal) {
        this.oListMapaLocal = oListMapaLocal;
    }
}
