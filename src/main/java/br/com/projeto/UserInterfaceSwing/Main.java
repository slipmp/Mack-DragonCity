/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaceSwing;

import javax.swing.JOptionPane;

/**
 *
 * @author Slipmp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        frmMain ofrmMain=new frmMain();
        ofrmMain.setLocationRelativeTo(null);
        ofrmMain.setVisible(true);
        //MetodoTeste();
    }
    
     /**
     * Apenas para testar algumas funcionaldiades do MackDragonCity
     */
    private static void MetodoTeste()
    {
        try
        {
            frmMain ofrmMain=new frmMain();
            ofrmMain.setLocationRelativeTo(null);
            //ofrmMain.show();

            RegrasNegocio.JogoRegrasNegocio oJogoRegrasNegocio=new RegrasNegocio.JogoRegrasNegocio();

            Entidades.Jogador oJogador=new Entidades.Jogador();
            oJogador.setCodigo(1);
            oJogador.setNome("Marcos");

            Entidades.Jogo oJogo=oJogoRegrasNegocio.CriarNovoJogo(oJogador);

            oJogoRegrasNegocio.GravarJogo(oJogo);
            oJogoRegrasNegocio.LerJogo();
            oJogoRegrasNegocio.GravarJogo(oJogo);
            oJogoRegrasNegocio.LerJogo();
            System.exit(0);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao Executar! Descrição: "+ ex.getMessage());
        }
    }
}

