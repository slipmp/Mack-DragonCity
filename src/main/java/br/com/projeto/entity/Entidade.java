package br.com.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "tbEntidade")
public abstract class Entidade implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
    protected int codigo;
    
	@Column(name ="PontosXP")
    protected int pontosXP;

	@Column(name ="Imagem")
    protected String imagem;

	@Column(name ="Valor")
    protected int valor;
        
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPontosXP() {
        return pontosXP;
    }

    public void setPontosXP(int pontosXP) {
        this.pontosXP = pontosXP;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }	
}
