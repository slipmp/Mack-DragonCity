package br.com.projeto.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbHabitat")
public class Habitat extends Construcao implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2232005512832575839L;

	@OneToMany
	@JoinColumn(name="IdHabitatTipo")
    private HabitatTipo habitatTipo;
    
	@OneToOne
	@JoinColumn(name="IdDragao")
    private Dragao oDragao;

    public HabitatTipo getHabitatTipo() {
        return habitatTipo;
    }

    public void setHabitatTipo(HabitatTipo habitatTipo) {
        this.habitatTipo = habitatTipo;
    }

    @Override
    public String getNome() {
        return "Habitat " + getHabitatTipo().getTipo();
    }
    
    public Dragao getoDragao() {
        return oDragao;
    }

    public void setoDragao(Dragao oDragao) {
        this.oDragao = oDragao;
    }
}
