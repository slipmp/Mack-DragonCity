package br.com.projeto.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbDragaoTipo")
public class DragaoTipo  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4025796556269695227L;

	@Id
	@Column(name="Id")
    private int codigo;

	@Column(name="NomeTipoDragao")
    private String nomeTipoDragao;

	@Column(name="LevelJogadorRequerido")
    private int levelJogadorRequerido;

	@OneToOne(fetch=FetchType.LAZY)
    private HabitatTipo oHabitatTipo;  
    
	@Column(name="Valor")
    private int valor;
    
	@Column(name="OuroFornece")
    private int ouroFornece;
    
	@Column(name="PontosXPFornece")
    private int pontosXPFornece;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeTipoDragao() {
        return nomeTipoDragao;
    }

    public void setNomeTipoDragao(String nomeTipoDragao) {
        this.nomeTipoDragao = nomeTipoDragao;
    }

    public int getLevelJogadorRequerido() {
        return levelJogadorRequerido;
    }

    public void setLevelJogadorRequerido(int levelJogadorRequerido) {
        this.levelJogadorRequerido = levelJogadorRequerido;
    }

    public HabitatTipo getoHabitatTipo() {
        return oHabitatTipo;
    }

    public void setoHabitatTipo(HabitatTipo oHabitatTipo) {
        this.oHabitatTipo = oHabitatTipo;
    }
 
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
     public int getOuroFornece() {
        return ouroFornece;
    }

    public void setOuroFornece(int ouroFornece) {
        this.ouroFornece = ouroFornece;
    }
    public int getPontosXPFornece() {
        return pontosXPFornece;
    }

    public void setPontosXPFornece(int pontosXPFornece) {
        this.pontosXPFornece = pontosXPFornece;
    }
}
