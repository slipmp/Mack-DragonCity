package br.com.projeto.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbDragaoEstado")
public class DragaoEstado implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9041013752895695287L;

	@Id
	@GeneratedValue
	@Column(name="Id")
    private int codigo;

	@Column(name="NomeEstado")
    private String nomeEstado;

	@Column(name="LevelDe")
    private int levelDe;
	
	@Column(name="LevalPara")
    private int levelPara;

	@ManyToOne
	@JoinColumn(name="IdDragaoTipo")
    private DragaoTipo oDragaoTipo;

	@Column(name="Imagem")
    private String imagem;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public int getLevelDe() {
        return levelDe;
    }

    public void setLevelDe(int levelDe) {
        this.levelDe = levelDe;
    }

    public int getLevelPara() {
        return levelPara;
    }

    public void setLevelPara(int levelPara) {
        this.levelPara = levelPara;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

	public void setoDragaoTipo(DragaoTipo oDragaoTipo) {
		this.oDragaoTipo = oDragaoTipo;
	}

	public DragaoTipo getoDragaoTipo() {
		return oDragaoTipo;
	}


}
