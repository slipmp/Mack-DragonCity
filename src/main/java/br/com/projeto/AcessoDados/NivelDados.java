/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AcessoDados;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Slipmp
 */
public class NivelDados {
 
    private List<Entidades.Nivel> _oListNivel;
    
    public NivelDados()
    {
        _oListNivel =new ArrayList();
        
        for(int i=1;i<=99;i++)
        {
            Entidades.Nivel oNivel=new Entidades.Nivel();
            oNivel.setCodigo(i);
            oNivel.setDePontosXP(100*(i-1));
            //Se for o último level, o máximo de XP será o máximo que um Integer pode carregar. 
            oNivel.setAtePontosXP((i==99?Integer.MAX_VALUE: (100*i)-1));

            _oListNivel.add(oNivel);
        }
    }
    
    public List<Entidades.Nivel> getNiveis()
    {
        return _oListNivel;
    }
}
