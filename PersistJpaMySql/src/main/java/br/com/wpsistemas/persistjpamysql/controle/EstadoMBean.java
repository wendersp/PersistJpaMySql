
package br.com.wpsistemas.persistjpamysql.controle;

import br.com.wpsistemas.persistjpamysql.model.dao.EstadoDao;
import br.com.wpsistemas.persistjpamysql.model.entidades.Estado;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author wender
 */
@Named(value = "estadoMBean")
@SessionScoped
public class EstadoMBean implements Serializable {

    private EstadoDao estadoDao;
    private Estado estado;
    private String nomePesquisar;
    private List<Estado> listEstados;
    
    private final String FORM_CAD = "estadoFrm";
    private final String FORM_CONS = "estadoCons";
    
    public String novo() {
        this.estado = new Estado();
        return this.FORM_CAD;
    }
    
    public void pesquisar() {
        if (this.estadoDao == null) {
            this.estadoDao = new EstadoDao();
        }
       this.listEstados =  this.estadoDao.pesquisar(nomePesquisar);
    }
    
    public String editar() {
        
        return this.FORM_CAD;
    }
   
    public void excluir() {
        if (this.estadoDao == null) {
            this.estadoDao = new EstadoDao();
        }
        this.estadoDao.excluir(estado);
    }
    
    public String voltar() {        
        return this.FORM_CONS;
    }
    
    public String salvar() {
         if (this.estadoDao == null) {
            this.estadoDao = new EstadoDao();
        }
        this.estadoDao.salvar(estado);        
        return this.FORM_CONS;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNomePesquisar() {
        return nomePesquisar;
    }

    public void setNomePesquisar(String nomePesquisar) {
        this.nomePesquisar = nomePesquisar;
    }

    public List<Estado> getListEstados() {
        return listEstados;
    }

    public void setListEstados(List<Estado> listEstados) {
        this.listEstados = listEstados;
    }
    
    
    
    
}
