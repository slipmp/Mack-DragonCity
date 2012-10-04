/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RegrasNegocio;

/**
 *
 * @author Slipmp
 */
public class HabitatRegrasNegocio 
{
    private AcessoDados.HabitatDados oHabitatDados=new AcessoDados.HabitatDados();
    
    public String getHabitatDescricoes()
    {
        return oHabitatDados.getHabitatDescricoes();
    }
    
    public Entidades.HabitatTipo getHabitatTipoPorId(int iCodigo)
    {
        return oHabitatDados.getHabitatTipoPorId(iCodigo);
    }
}
