package Entidades;

public class DragaoEstado implements java.io.Serializable{

    private int codigo;

    private String nomeEstado;

    private int levelDe;

    private int levelPara;

    private DragaoTipo dragaoTipo;

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

    public DragaoTipo getDragaoTipo() {
        return dragaoTipo;
    }

    public void setDragaoTipo(DragaoTipo dragaoTipo) {
        this.dragaoTipo = dragaoTipo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
