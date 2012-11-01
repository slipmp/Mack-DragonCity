/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.businessrules;

import java.util.List;

import br.com.projeto.dao.NivelDados;
import br.com.projeto.entity.Nivel;


/**
 *
 * @author Slipmp
 */
public class NivelRegrasNegocio 
{
    private br.com.projeto.dao.NivelDados _oNivelDados;
    
    public NivelRegrasNegocio()
    {
        _oNivelDados=new NivelDados();
    }
    
    public List<Nivel> getNiveis()
    {
        return _oNivelDados.getNiveis();
    }
    
    public Nivel getNivelEquivalente(int qtdTotalPontosXP)
    {
        for(Nivel oNivel:_oNivelDados.getNiveis())
        {
            if(qtdTotalPontosXP>=oNivel.getDePontosXP() && qtdTotalPontosXP <oNivel.getAtePontosXP())
            {
                return oNivel;
            }
        }
        
        return null;
    }
}
