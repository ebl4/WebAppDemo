package com.dito.app.conversor;

import com.dito.app.bean.Service;
import com.dito.app.dao.ServiceDAO;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by dell on 27/10/2017.
 */
@FacesConverter("serviceConverter")
public class ServiceConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ServiceDAO serviceDAO = new ServiceDAO();
        Service service = serviceDAO.buscaPorId(value);
        return service;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Service) value).getId());
    }

}
