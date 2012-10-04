/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RegrasNegocio;

import AcessoDados.*;
import Entidades.*;

/**
 *
 * @author Slipmp
 */
public class DragaoRegrasNegocio {
 
    DragaoDados oDragaoDados=new DragaoDados();
    public String getDragoesTipoDescricoes()
    {
        return oDragaoDados.getDragoesTipoDescricoes();
    }
    
    public DragaoTipo getDragaoTipoPorId(int iCodigo)
    {
        return oDragaoDados.getDragaoTipoPorId(iCodigo);
    }
}
