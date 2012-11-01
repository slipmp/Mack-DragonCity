/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

/**
 *
 * @author Slipmp
 */
public class Util {
    
    public static boolean IsNumeric(String strEntrada)
    {
        try
        {
            Integer.parseInt(strEntrada);

            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
}
