package br.com.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbNivel")
public class Nivel implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -454116298696352773L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
    private int codigo;

	@Column(name = "DePontosXP")
	private int dePontosXP;

	@Column(name = "AtePontosXP")
    private int atePontosXP;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDePontosXP() {
        return dePontosXP;
    }

    public void setDePontosXP(int dePontosXP) {
        this.dePontosXP = dePontosXP;
    }

    public int getAtePontosXP() {
        return atePontosXP;
    }

    public void setAtePontosXP(int atePontosXP) {
        this.atePontosXP = atePontosXP;
    }
    
    @Override
    public String toString() {
        return "Nivel: "  + getCodigo();
    }
}
