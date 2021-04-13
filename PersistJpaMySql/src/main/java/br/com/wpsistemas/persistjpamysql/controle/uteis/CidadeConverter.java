/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wpsistemas.persistjpamysql.controle.uteis;

import br.com.wpsistemas.persistjpamysql.model.dao.CidadeDao;
import br.com.wpsistemas.persistjpamysql.model.entidades.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author wender
 */
@FacesConverter("cidadeConverter")
public class CidadeConverter implements Converter{

    private Cidade cidade = new Cidade();    
    
      @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value != null && value.trim().length() > 0) {
            Long id = Long.parseLong(value);
            cidade = new CidadeDao().pesquisar(id);
        }
        return cidade;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
        if (value != null) {
            cidade = (Cidade) value;
            return cidade.getId().toString();
        }
        return null;
    }
    
}
