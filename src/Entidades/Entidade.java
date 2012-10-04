package Entidades;

public abstract class Entidade implements java.io.Serializable
{
    protected int codigo;
    
    protected int pontosXP;

    protected String imagem;

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
