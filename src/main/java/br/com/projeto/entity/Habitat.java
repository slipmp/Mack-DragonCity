package br.com.projeto.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="IdHabitat")
@Table(name = "tbHabitat")
public class Habitat extends Construcao implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2232005512832575839L;

	@ManyToOne
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
