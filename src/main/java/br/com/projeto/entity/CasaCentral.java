package br.com.projeto.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbCasaCentral")
public class CasaCentral extends Construcao implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="IdOvo")
    private Dragao ovo;

    public Dragao getOvo() {
        return ovo;
    }

    public void setOvo(Dragao ovo) {
        this.ovo = ovo;
    }
    @Override
    public String getNome() {
        return "Casa Central";
    }

}
