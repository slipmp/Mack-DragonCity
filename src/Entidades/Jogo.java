package Entidades;

import java.util.List;

public class Jogo implements java.io.Serializable{

    private int vlrTotalOuro;

    private int vlrTotalComida;

    private int qtdTotalPontosXP;

    private Jogador jogador;

    private List<Dragao> listDragao;

    private Mapa mapa;

    public int getVlrTotalOuro() {
        return vlrTotalOuro;
    }

    public void setVlrTotalOuro(int vlrTotalOuro) {
        this.vlrTotalOuro = vlrTotalOuro;
    }

    public int getVlrTotalComida() {
        return vlrTotalComida;
    }

    public void setVlrTotalComida(int vlrTotalComida) {
        this.vlrTotalComida = vlrTotalComida;
    }

    public int getQtdTotalPontosXP() {
        return qtdTotalPontosXP;
    }

    public void setQtdTotalPontosXP(int qtdTotalPontosXP) {
        this.qtdTotalPontosXP = qtdTotalPontosXP;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public List<Dragao> getListDragao() {
        return listDragao;
    }

    public void setListDragao(List<Dragao> listDragao) {
        this.listDragao = listDragao;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
}
