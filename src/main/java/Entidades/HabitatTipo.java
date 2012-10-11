package Entidades;

public class HabitatTipo implements java.io.Serializable{

    private int codigo;
    
    private String tipo;
    
    private DragaoTipo oDragaoTipo;
    
    private int valor;
    
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
