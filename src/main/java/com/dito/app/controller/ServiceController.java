package com.dito.app.controller;

import com.dito.app.bean.Service;
import com.dito.app.factory.ConnectionFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dell on 27/10/2017.
 */
@ManagedBean
@ViewScoped
public class ServiceController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Service serviceSelecionado = new Service();

    public List<Service> buscaServicos(String descricao) {
        return getProdutosPelaDescricao(descricao);
    }

    private List<Service> getProdutosPelaDescricao(String descricao) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        List<Service> services = connectionFactory.readStatement(descricao);
        return services.stream().filter(p -> p.getDescricao().contains(descricao)).collect(Collectors.toList());
    }

    public Service getServiceSelecionado() {
        return serviceSelecionado;
    }

    public void setServiceSelecionado(Service serviceSelecionado) {
        this.serviceSelecionado = serviceSelecionado;
    }

}
