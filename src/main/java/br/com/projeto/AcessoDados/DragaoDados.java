package AcessoDados;

import br.com.projeto.entity.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Slipmp
 */
public class DragaoDados 
{
    private static List<DragaoTipo> _oListDragaoTipo;
    private static List<DragaoEstado> _oListDragaoEstado;

    public static final int iDRAGAO_FOGO=1;
    public static final int iDRAGAO_AGUA=2;
    public static final int iDRAGAO_GELO=3;
    public static final int iDRAGAO_PLANTA=4;
    public static final int iDRAGAO_ACO=5;
    public static final int iDRAGAO_RAIO=6;
    
    private static List<DragaoTipo> getoListDragaoTipo() {
        if(_oListDragaoTipo==null) {
            PreencherListDragaoTipo();
        }
        
        return _oListDragaoTipo;
    }

    private static List<DragaoEstado> getoListDragaoEstado() {
        if(_oListDragaoEstado==null) {
            PreencherListDragaoEstado();
        }
        return _oListDragaoEstado;
    }

    private static void setoListDragaoEstado(List<DragaoEstado> _oListDragaoEstado) {
        DragaoDados._oListDragaoEstado = _oListDragaoEstado;
    }
    
    private static void PreencherListDragaoEstado()
    {
        //Esses dados em tese deveriam vir de um banco de dados.
        DragaoEstado oDragaoEstado=new DragaoEstado();
        oDragaoEstado.setCodigo(1);
        oDragaoEstado.setNomeEstado("Ovo");
        oDragaoEstado.setLevelDe(0);
        oDragaoEstado.setLevelPara(0);
        oDragaoEstado.setImagem("SEM IMAGEM");
        _oListDragaoEstado.add(oDragaoEstado);
        
        oDragaoEstado=new DragaoEstado();
        oDragaoEstado.setCodigo(2);
        oDragaoEstado.setNomeEstado("Bebê");
        oDragaoEstado.setLevelDe(1);
        oDragaoEstado.setLevelPara(5);
        oDragaoEstado.setImagem("SEM IMAGEM");
        _oListDragaoEstado.add(oDragaoEstado);
        
        oDragaoEstado=new DragaoEstado();
        oDragaoEstado.setCodigo(3);
        oDragaoEstado.setNomeEstado("Semi-Adulto");
        oDragaoEstado.setLevelDe(6);
        oDragaoEstado.setLevelPara(12);
        oDragaoEstado.setImagem("SEM IMAGEM");
        _oListDragaoEstado.add(oDragaoEstado);
        
        oDragaoEstado=new DragaoEstado();
        oDragaoEstado.setCodigo(4);
        oDragaoEstado.setNomeEstado("Adulto");
        oDragaoEstado.setLevelDe(13);
        oDragaoEstado.setLevelPara(20);
        oDragaoEstado.setImagem("SEM IMAGEM");
        _oListDragaoEstado.add(oDragaoEstado);
    }
    
    private static void PreencherListDragaoTipo()
    {   
        HabitatDados oHabitatDados=new HabitatDados();
        _oListDragaoTipo=new ArrayList();
        
        //Normalmente esses dados viriam de um banco de dados. Porém estarão fixos aqui.
        DragaoTipo oDragaoTipo=new DragaoTipo();
        oDragaoTipo.setCodigo(iDRAGAO_FOGO);
        oDragaoTipo.setLevelJogadorRequerido(1);
        oDragaoTipo.setNomeTipoDragao("Fogo");
        oDragaoTipo.setValor(100);
        oDragaoTipo.setOuroFornece(10);
        oDragaoTipo.setPontosXPFornece(20);
        _oListDragaoTipo.add(oDragaoTipo);
        oDragaoTipo.setoHabitatTipo(oHabitatDados.getHabitatTipoPorId(HabitatDados.iHABITAT_FOGO));
        
        
        oDragaoTipo=new DragaoTipo();
        oDragaoTipo.setCodigo(iDRAGAO_AGUA);
        oDragaoTipo.setLevelJogadorRequerido(3);
        oDragaoTipo.setNomeTipoDragao("Água");
        oDragaoTipo.setValor(150);
        oDragaoTipo.setOuroFornece(20);
        oDragaoTipo.setPontosXPFornece(30);
        _oListDragaoTipo.add(oDragaoTipo);
        oDragaoTipo.setoHabitatTipo(oHabitatDados.getHabitatTipoPorId(HabitatDados.iHABITAT_AGUA));
        
        oDragaoTipo=new DragaoTipo();
        oDragaoTipo.setCodigo(iDRAGAO_GELO);
        oDragaoTipo.setLevelJogadorRequerido(5);
        oDragaoTipo.setNomeTipoDragao("Gelo");
        oDragaoTipo.setValor(200);
        oDragaoTipo.setOuroFornece(30);
        oDragaoTipo.setPontosXPFornece(40);
        _oListDragaoTipo.add(oDragaoTipo);
        oDragaoTipo.setoHabitatTipo(oHabitatDados.getHabitatTipoPorId(HabitatDados.iHABITAT_GELO));
        
        oDragaoTipo=new DragaoTipo();
        oDragaoTipo.setCodigo(iDRAGAO_PLANTA);
        oDragaoTipo.setLevelJogadorRequerido(7);
        oDragaoTipo.setNomeTipoDragao("Planta");
        oDragaoTipo.setValor(250);
        oDragaoTipo.setOuroFornece(40);
        oDragaoTipo.setPontosXPFornece(50);
        _oListDragaoTipo.add(oDragaoTipo);
        oDragaoTipo.setoHabitatTipo(oHabitatDados.getHabitatTipoPorId(HabitatDados.iHABITAT_PLANTA));
        
        oDragaoTipo=new DragaoTipo();
        oDragaoTipo.setCodigo(iDRAGAO_ACO);
        oDragaoTipo.setLevelJogadorRequerido(10);
        oDragaoTipo.setNomeTipoDragao("Aço");
        oDragaoTipo.setValor(300);
        oDragaoTipo.setOuroFornece(50);
        oDragaoTipo.setPontosXPFornece(60);
        _oListDragaoTipo.add(oDragaoTipo);
        oDragaoTipo.setoHabitatTipo(oHabitatDados.getHabitatTipoPorId(HabitatDados.iHABITAT_ACO));
        
        oDragaoTipo=new DragaoTipo();
        oDragaoTipo.setCodigo(iDRAGAO_RAIO);
        oDragaoTipo.setLevelJogadorRequerido(15);
        oDragaoTipo.setNomeTipoDragao("Raio");
        oDragaoTipo.setValor(400);
        oDragaoTipo.setOuroFornece(100);
        oDragaoTipo.setPontosXPFornece(100);
        _oListDragaoTipo.add(oDragaoTipo);
        oDragaoTipo.setoHabitatTipo(oHabitatDados.getHabitatTipoPorId(HabitatDados.iHABITAT_RAIO));
    }
    public List<DragaoTipo> getDragoesTipos()
    {
        return getoListDragaoTipo();
    }
    
    public List<DragaoEstado> getDragoesEstados()
    {
        return getoListDragaoEstado();
    }
    
    
    /**
     * Esse método não seria necessário caso os dados de dragões estivessem vindo de um banco de dados.
     * Como eles não estão, eu fiz esses métodos auxiliares para associa-los com os seus devidos Habitats.
     */
    public DragaoTipo getDragaoTipoPorId(int iCodigo)
    {
        for(DragaoTipo oDragaoTipo:getoListDragaoTipo())
        {
            if(oDragaoTipo.getCodigo()==iCodigo)
            {
                return oDragaoTipo;
            }
        }
        return null;
    }
    
    public String getDragoesTipoDescricoes()
    {
        String strResultado="";
        for(DragaoTipo oDragaoTipo :getoListDragaoTipo())
        {
            strResultado=strResultado+"\n"+ oDragaoTipo.getCodigo() + " - " + oDragaoTipo.getNomeTipoDragao() +  " - Level Requerido: "+oDragaoTipo.getLevelJogadorRequerido()+  " - Ouro Requerido: "+oDragaoTipo.getValor();
        }
        return strResultado;
    }
    
}
