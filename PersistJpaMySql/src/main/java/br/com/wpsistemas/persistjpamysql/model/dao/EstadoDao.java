
package br.com.wpsistemas.persistjpamysql.model.dao;

import br.com.wpsistemas.persistjpamysql.model.entidades.Estado;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author wender
 */
public class EstadoDao extends GenericDao {
            
    public void salvar(Estado estado) {
        super.iniciarConexaoBD();
        super.entityManager.getTransaction().begin();
        if (estado.getId() == null) {
            super.entityManager.persist(estado);
        } else {
            super.entityManager.merge(estado);
        }        
        super.entityManager.getTransaction().commit();
        super.finalizarConexaoBD();
    }    
    
    public void excluir(Estado estado) {
        super.iniciarConexaoBD();
        super.entityManager.getTransaction().begin();
        super.entityManager.remove(super.entityManager.find(Estado.class, estado.getId()));        
        super.entityManager.getTransaction().commit();
        super.finalizarConexaoBD();
    }
    
    public void excluir(Long id) {
        super.iniciarConexaoBD();
        super.entityManager.getTransaction().begin();
        super.entityManager.remove(super.entityManager.find(Estado.class,id));        
        super.entityManager.getTransaction().commit();
        super.finalizarConexaoBD();
    }
    
    public Estado pesquisar(Long id) {
        super.iniciarConexaoBD();
        Estado estado = super.entityManager.find(Estado.class,id);        
        super.finalizarConexaoBD();        
        return estado;
    }
    
    public List<Estado> pesquisar(String nome) {
         super.iniciarConexaoBD();
         List<Estado> listaEstados;
        Query consulta = super.entityManager.createNamedQuery("Estado.findByNome");
        consulta.setParameter("nome", nome + "%");
        listaEstados = consulta.getResultList();
        super.finalizarConexaoBD();        
        return listaEstados;
    }
    
    
}
