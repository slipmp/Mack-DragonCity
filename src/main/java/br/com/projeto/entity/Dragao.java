package br.com.projeto.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="IdDragao")
@Table(name = "tbDragao")
public class Dragao extends Entidade implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7653491723166797269L;

	@Column(name = "NomeDragao")
    private String nomeDragao;

	@Column(name = "TotalExperiencia")
    private int totalExperiencia;

	@SuppressWarnings("unused")
	@Column(name = "Level")
    private int level;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "IdJogo")
    private Jogo jogo;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "IdDragaoTipo")
    private DragaoTipo dragaoTipo;

    public String getNomeDragao() {
        return nomeDragao;
    }

    public void setNomeDragao(String NomeDragao) {
        this.nomeDragao = NomeDragao;
    }

    public int getTotalExperiencia() {
        return totalExperiencia;
    }

    public void setTotalExperiencia(int totalExperiencia) {
        this.totalExperiencia = totalExperiencia;
    }

    public int getLevel() {
        if((totalExperiencia / 100)+1>20) {
            return 20;
        }
        else {
            return (totalExperiencia / 100)+1;
        }
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public DragaoTipo getDragaoTipo() {
        return dragaoTipo;
    }

    public void setDragaoTipo(DragaoTipo dragaoTipo) {
        this.dragaoTipo = dragaoTipo;
    }

    /*public DragaoEstado getDragaoEstado()
    {
        DragaoEstadoDao dragaoEstadoDao = new DragaoEstadoDao();
        DragaoEstado dragaoEstado = dragaoEstadoDao.getDragaoEstado(this.level, getDragaoTipo().getCodigo());
        
        return dragaoEstado;
    }*/
}
