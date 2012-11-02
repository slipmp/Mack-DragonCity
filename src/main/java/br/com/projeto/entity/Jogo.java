package br.com.projeto.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbJogo")
public class Jogo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3077288306332878109L;

	@Id
	@Column(name = "ID")
    protected int codigo;
	
	@Column(name="VlrTotalOuro")
    private int vlrTotalOuro;

	@Column(name="VlrTotalComida")
    private int vlrTotalComida;

	@Column(name="QtdTotalPontosXP")
    private int qtdTotalPontosXP;

    @OneToOne
	@JoinColumn(name = "IdJogador")
    private Jogador jogador;

    @OneToMany(mappedBy="jogo",cascade=CascadeType.ALL)
    private List<Dragao> listDragao;

    @OneToOne
	@JoinColumn(name = "IdMapa")
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
