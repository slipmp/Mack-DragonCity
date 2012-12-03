package br.com.projeto.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbHabitatTipo")
public class HabitatTipo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7991159510353467797L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
    private int codigo;
    
	@Column(name = "Tipo")
    private String tipo;
    
	@OneToOne(fetch=FetchType.EAGER,mappedBy="oHabitatTipo",cascade=CascadeType.ALL)
    private DragaoTipo oDragaoTipo;
    
    @Column(name = "Valor")
    private int valor;
    
    @Column(name = "PontosXPFornecido")
    private int pontosXPFornecido;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public DragaoTipo getoDragaoTipo() {
        return oDragaoTipo;
    }

    public void setoDragaoTipo(DragaoTipo oDragaoTipo) {
        this.oDragaoTipo = oDragaoTipo;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPontosXPFornecido() {
        return pontosXPFornecido;
    }

    public void setPontosXPFornecido(int pontosXPFornecido) {
        this.pontosXPFornecido = pontosXPFornecido;
    }
}
