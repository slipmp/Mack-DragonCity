/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RegrasNegocio;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Slipmp
 */
public class NivelRegrasNegocio 
{
    private AcessoDados.NivelDados _oNivelDados;
    
    public NivelRegrasNegocio()
    {
        _oNivelDados=new AcessoDados.NivelDados();
    }
    
    public List<Entidades.Nivel> getNiveis()
    {
        return _oNivelDados.getNiveis();
    }
    
    public Entidades.Nivel getNivelEquivalente(int qtdTotalPontosXP)
    {
        for(Entidades.Nivel oNivel:_oNivelDados.getNiveis())
        {
            if(qtdTotalPontosXP>=oNivel.getDePontosXP() && qtdTotalPontosXP <oNivel.getAtePontosXP())
            {
                return oNivel;
            }
        }
        
        return null;
    }
}
