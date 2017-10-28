package com.dito.app.dao;

import com.dito.app.bean.Service;
import com.dito.app.factory.ConnectionFactory;

/**
 * Created by dell on 27/10/2017.
 */
public class ServiceDAO {

    public Service buscaPorId(String id){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Service service = connectionFactory.buscaPorId(Long.valueOf(id));
        if(service != null){
            return service;
        }
        return new Service();
    }

}
