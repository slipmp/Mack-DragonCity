package Entidades;

public class Fazenda extends Construcao implements java.io.Serializable{

    public Fazenda()
    {
        //Esses valores estão fixos. Porém o certo é vir de um banco de dados ou de um arquivo de configuração.
        //Para simplificar eu o deixei aqui. Diferente dos Habitats que cada um tem o seu valor próprio.
        //Que por exemplo estão sendo alimentado dentro de AcessoDados.HabitatDados.java
        setValor(100);
        setPontosXP(20);
    }
    
    @Override
    public String getNome() {
        return "Fazenda";
    }
}
