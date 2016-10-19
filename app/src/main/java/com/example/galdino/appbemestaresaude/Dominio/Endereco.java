package com.example.galdino.appbemestaresaude.Dominio;

/**
 * Created by Galdino on 15/10/2016.
 */
public class Endereco extends EntidadeDominio {
    private String rua;
    private Cliente cliente;

    // Gets
    public String getRua() {
        return rua;
    }
    public Cliente getCliente() {
        return cliente;
    }


    // Sets
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
