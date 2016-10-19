package com.example.galdino.appbemestaresaude.Dominio;

/**
 * Created by Galdino on 17/10/2016.
 */
public class PedidoVenda extends EntidadeDominio {
    // O Certo é uma lista de produto, acertar******
    private Produto produto;
    private String sDtInclusao;
    private Double vlr_total;
    private Double nrPonto;

    // Gets

    public String getsDtInclusao() {
        return sDtInclusao;
    }

    public Double getVlr_total() {
        return vlr_total;
    }

    public Double getNrPonto() {
        return nrPonto;
    }

    public Produto getProduto() {
        return produto;
    }

    // Sets

    public void setsDtInclusao(String sDtInclusao) {
        this.sDtInclusao = sDtInclusao;
    }

    public void setVlr_total(Double vlr_total) {
        this.vlr_total = vlr_total;
    }

    public void setNrPonto(Double nrPonto) {
        this.nrPonto = nrPonto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
