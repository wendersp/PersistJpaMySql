/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wpsistemas.persistjpamysql.controle.uteis;

import br.com.wpsistemas.persistjpamysql.model.dao.CidadeDao;
import br.com.wpsistemas.persistjpamysql.model.dao.EstadoDao;
import br.com.wpsistemas.persistjpamysql.model.entidades.Cidade;
import br.com.wpsistemas.persistjpamysql.model.entidades.Estado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author wender
 */
@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter{

    private Estado estado = new Estado();    
    
      @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value != null && value.trim().length() > 0) {
            Long id = Long.parseLong(value);
            estado = new EstadoDao().pesquisar(id);
        }
        return estado;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
        if (value != null) {
            estado = (Estado) value;
            return estado.getId().toString();
        }
        return null;
    }
    
}
