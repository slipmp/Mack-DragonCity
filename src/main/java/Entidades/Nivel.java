package Entidades;

public class Nivel implements java.io.Serializable{

    private int codigo;

    private int dePontosXP;

    private int atePontosXP;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDePontosXP() {
        return dePontosXP;
    }

    public void setDePontosXP(int dePontosXP) {
        this.dePontosXP = dePontosXP;
    }

    public int getAtePontosXP() {
        return atePontosXP;
    }

    public void setAtePontosXP(int atePontosXP) {
        this.atePontosXP = atePontosXP;
    }
    
    @Override
    public String toString() {
        return "Nivel: "  + getCodigo();
    }
}
