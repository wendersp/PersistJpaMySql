package br.com.wpsistemas.persistjpamysql.model.dao;

import br.com.wpsistemas.persistjpamysql.model.entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wender
 */
public class UsuarioDao extends GenericDao {

   

    /* Criar Novo e Altera */
    public void salvar(Usuario usuario) {
        iniciarConexaoBD();
        entityManager.getTransaction().begin();
        if (usuario.getId() == null) {
            //Insert
            entityManager.persist(usuario);
        } else {
            //Update
            entityManager.merge(usuario);
        }
        entityManager.getTransaction().commit();
        finalizarConexaoBD();        
    }

    //remover
    public void excluir(Usuario usuario) {
//        iniciarConexaoBD();
//        entityManager.remove(entityManager.find(Usuario.class, usuario.getId()));
//        finalizarConexaoBD();
        this.excluir(usuario.getId());
    }
    //remover
    public void excluir(Long id) {
        iniciarConexaoBD();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Usuario.class, id));
        entityManager.getTransaction().commit();
        System.out.println("Usuario excluida com sucesso...");
        finalizarConexaoBD();
    }
    
    //Read 
    public Usuario pesquisar(Long id) {
        iniciarConexaoBD();
        Usuario usuario = (Usuario) entityManager.find(Usuario.class, id);
        finalizarConexaoBD();
        return usuario;
    }
    //Read 
    public List<Usuario> pesquisar(String nome) {
        iniciarConexaoBD();
        List<Usuario> lstUsuario;
        Query consulta = entityManager.createNamedQuery("Usuario.findByNome");
        consulta.setParameter("nome", nome.toUpperCase() + "%");
        lstUsuario = consulta.getResultList();
        finalizarConexaoBD();
        return lstUsuario;
    }
    
}
