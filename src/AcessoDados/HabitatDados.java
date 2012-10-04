/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AcessoDados;

import Entidades.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Slipmp
 */
public class HabitatDados 
{
    private static List<HabitatTipo> _oListHabitatTipo;
    
    public static final int iHABITAT_FOGO=1;
    public static final int iHABITAT_AGUA=2;
    public static final int iHABITAT_GELO=3;
    public static final int iHABITAT_PLANTA=4;
    public static final int iHABITAT_ACO=5;
    public static final int iHABITAT_RAIO=6;
    
    public static List<HabitatTipo> getoListHabitatTipo() {
        if(_oListHabitatTipo==null) {
            PreencherListHabitatTipo();
        }
        
        return _oListHabitatTipo;
    }
    
    private static void PreencherListHabitatTipo()
    {   
        DragaoDados oDragaoDados=new DragaoDados();
        _oListHabitatTipo=new ArrayList();
        
        //Esses dados em tese deveriam vir de um banco de dados.
        HabitatTipo oHabitatTipo=new HabitatTipo();
        oHabitatTipo.setCodigo(iHABITAT_FOGO);
        oHabitatTipo.setTipo("Fogo");
        oHabitatTipo.setValor(100);
        oHabitatTipo.setPontosXPFornecido(30);
        _oListHabitatTipo.add(oHabitatTipo);
        oHabitatTipo.setoDragaoTipo(oDragaoDados.getDragaoTipoPorId(DragaoDados.iDRAGAO_FOGO));
        
        oHabitatTipo=new HabitatTipo();
        oHabitatTipo.setCodigo(iHABITAT_AGUA);
        oHabitatTipo.setTipo("Água");
        oHabitatTipo.setValor(150);
        oHabitatTipo.setPontosXPFornecido(60);
        _oListHabitatTipo.add(oHabitatTipo);
        oHabitatTipo.setoDragaoTipo(oDragaoDados.getDragaoTipoPorId(DragaoDados.iDRAGAO_AGUA));
        
        oHabitatTipo=new HabitatTipo();
        oHabitatTipo.setCodigo(iHABITAT_GELO);
        oHabitatTipo.setTipo("Gelo");
        oHabitatTipo.setValor(200);
        oHabitatTipo.setPontosXPFornecido(90);
        _oListHabitatTipo.add(oHabitatTipo);
        oHabitatTipo.setoDragaoTipo(oDragaoDados.getDragaoTipoPorId(DragaoDados.iDRAGAO_GELO));
        
        oHabitatTipo=new HabitatTipo();
        oHabitatTipo.setCodigo(iHABITAT_PLANTA);
        oHabitatTipo.setTipo("Planta");
        oHabitatTipo.setValor(250);
        oHabitatTipo.setPontosXPFornecido(120);
        _oListHabitatTipo.add(oHabitatTipo);
        oHabitatTipo.setoDragaoTipo(oDragaoDados.getDragaoTipoPorId(DragaoDados.iDRAGAO_PLANTA));
        
        oHabitatTipo=new HabitatTipo();
        oHabitatTipo.setCodigo(iHABITAT_ACO);
        oHabitatTipo.setTipo("Aço");
        oHabitatTipo.setPontosXPFornecido(150);
        oHabitatTipo.setValor(300);
        _oListHabitatTipo.add(oHabitatTipo);
        oHabitatTipo.setoDragaoTipo(oDragaoDados.getDragaoTipoPorId(DragaoDados.iDRAGAO_ACO));
        
        oHabitatTipo=new HabitatTipo();
        oHabitatTipo.setCodigo(iHABITAT_RAIO);
        oHabitatTipo.setTipo("Raio");
        oHabitatTipo.setValor(400);
        oHabitatTipo.setPontosXPFornecido(180);
        _oListHabitatTipo.add(oHabitatTipo);
        oHabitatTipo.setoDragaoTipo(oDragaoDados.getDragaoTipoPorId(DragaoDados.iDRAGAO_RAIO));
    }
    
      /**
     * Esse método não seria necessário caso os dados de dragões estivessem vindo de um banco de dados.
     * Como eles não estão, eu fiz esses métodos auxiliares para associa-los com os seus devidos Habitats.
     */
    public HabitatTipo getHabitatTipoPorId(int iCodigo)
    {
        for(HabitatTipo oHabitatTipo:getoListHabitatTipo())
        {
            if(oHabitatTipo.getCodigo()==iCodigo)
            {
                return oHabitatTipo;
            }
        }
        return null;
    }
    
    public String getHabitatDescricoes()
    {
        PreencherListHabitatTipo();
        String strResultado="";
        for(HabitatTipo oHabitatTipo :getoListHabitatTipo())
        {
            strResultado=strResultado+"\n"+ oHabitatTipo.getCodigo() + " - " + oHabitatTipo.getTipo() +  " - Level Requerido: "+oHabitatTipo.getoDragaoTipo().getLevelJogadorRequerido()+  " - Ouro Requerido: "+oHabitatTipo.getValor();
        }
        return strResultado;
    }
}
