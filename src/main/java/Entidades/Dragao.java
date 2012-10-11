package Entidades;

public class Dragao extends Entidade implements java.io.Serializable{

    private String nomeDragao;

    private int totalExperiencia;

    private int level;

    private Jogo jogo;

    private DragaoTipo dragaoTipo;

    public String getNomeDragao() {
        return nomeDragao;
    }

    public void setNomeDragao(String NomeDragao) {
        this.nomeDragao = NomeDragao;
    }

    public int getTotalExperiencia() {
        return totalExperiencia;
    }

    public void setTotalExperiencia(int totalExperiencia) {
        this.totalExperiencia = totalExperiencia;
    }

    public int getLevel() {
        if((totalExperiencia / 100)+1>20) {
            return 20;
        }
        else {
            return (totalExperiencia / 100)+1;
        }
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public DragaoTipo getDragaoTipo() {
        return dragaoTipo;
    }

    public void setDragaoTipo(DragaoTipo dragaoTipo) {
        this.dragaoTipo = dragaoTipo;
    }

    public void Alimentar(Fruta oFruta) 
    {

    }
    public DragaoEstado getDragaoEstado()
    {
        DragaoEstado oDragaoEstado=new DragaoEstado();
        return oDragaoEstado;
    }
}
