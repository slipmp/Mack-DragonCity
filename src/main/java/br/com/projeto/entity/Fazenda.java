package br.com.projeto.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="IdFazenda")
@Table(name = "tbFazenda")
public class Fazenda extends Construcao implements java.io.Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1126552086164361362L;

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
