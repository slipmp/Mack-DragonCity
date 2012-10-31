package br.com.projeto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbJogador")
public class Jogador implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5855354955452902445L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
    private int codigo;

	@Column(name = "Nome")
    private String nome;

	@Column(name = "Login")
    private String login;

	@Column(name = "Senha")
    private String senha;

	@Column(name = "DataUltimoAcesso")
    private Date data_ultimo_acesso;

	@OneToOne
	@JoinColumn(name = "IdJogo")
    private Jogo jogo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_ultimo_acesso() {
        return data_ultimo_acesso;
    }

    public void setData_ultimo_acesso(Date data_ultimo_acesso) {
        this.data_ultimo_acesso = data_ultimo_acesso;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
