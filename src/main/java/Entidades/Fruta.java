package Entidades;

public class Fruta extends Entidade implements java.io.Serializable{

    private String nome;

    private int quantidadeAlimento;

    public Fruta()
    {
        //Esses valores estão fixos. Porém o certo é vir de um banco de dados ou de um arquivo de configuração.
        //Para simplificar eu o deixei aqui. 
        quantidadeAlimento=100;
        setValor(50);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public int getQuantidadeAlimento() {
        return quantidadeAlimento;
    }

    public void setQuantidadeAlimento(int QuantidadeAlimento) {
        this.quantidadeAlimento = QuantidadeAlimento;
    }

}
