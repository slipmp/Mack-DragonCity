package Entidades;

public class Habitat extends Construcao implements java.io.Serializable{

    private HabitatTipo habitatTipo;
    
    private Dragao oDragao;

    public HabitatTipo getHabitatTipo() {
        return habitatTipo;
    }

    public void setHabitatTipo(HabitatTipo habitatTipo) {
        this.habitatTipo = habitatTipo;
    }

    @Override
    public String getNome() {
        return "Habitat " + getHabitatTipo().getTipo();
    }
    
    public Dragao getoDragao() {
        return oDragao;
    }

    public void setoDragao(Dragao oDragao) {
        this.oDragao = oDragao;
    }
}
