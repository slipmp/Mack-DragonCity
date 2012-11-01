/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.entity.Nivel;

public class NivelDados {
 
    private List<Nivel> _oListNivel;
    
    public NivelDados()
    {
        _oListNivel =new ArrayList();
        
        for(int i=1;i<=99;i++)
        {
            Nivel oNivel=new Nivel();
            oNivel.setCodigo(i);
            oNivel.setDePontosXP(100*(i-1));
            //Se for o último level, o máximo de XP será o máximo que um Integer pode carregar. 
            oNivel.setAtePontosXP((i==99?Integer.MAX_VALUE: (100*i)-1));

            _oListNivel.add(oNivel);
        }
    }
    
    public List<Nivel> getNiveis()
    {
        return _oListNivel;
    }
}
