/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Slipmp
 */
public class Util {
    
    public static boolean IsNumeric(String strEntrada)
    {
        try
        {
            int iEntrada=Integer.parseInt(strEntrada);

            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
}
