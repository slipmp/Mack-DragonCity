package Entidades;

public class DragaoTipo  implements java.io.Serializable{

    private int codigo;

    private String nomeTipoDragao;

    private int levelJogadorRequerido;

    private HabitatTipo oHabitatTipo;  
    
    private int valor;
    
    private int ouroFornece;
    
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
