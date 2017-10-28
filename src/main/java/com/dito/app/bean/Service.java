package com.dito.app.bean;

/**
 * Created by dell on 27/10/2017.
 */
public class Service {

    private long id;
    private String descricao;
    private int valor;

    public Service() {
    }

    public Service(long id, String descricao, int valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }

}

