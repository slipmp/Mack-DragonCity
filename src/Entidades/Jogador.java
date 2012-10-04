package Entidades;

import java.util.Date;

public class Jogador implements java.io.Serializable{

    private int codigo;

    private String nome;

    private String login;

    private String senha;

    private Date data_ultimo_acesso;

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
