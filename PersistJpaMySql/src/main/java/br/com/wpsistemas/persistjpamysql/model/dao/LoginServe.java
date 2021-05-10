package br.com.wpsistemas.persistjpamysql.model.dao;

import br.com.wpsistemas.persistjpamysql.model.entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author wender
 */
public class LoginServe {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private void iniciarConexaoBD() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PresistJpaMysqlUP");
        entityManager = entityManagerFactory.createEntityManager();
    }

    private void finalizarConexaoBD() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public Usuario logar(String email, String senha) {
        iniciarConexaoBD();
        Usuario usuarioLogado;
        try {
            Query consultar = entityManager.createNamedQuery("Usuario.login");
            consultar.setParameter("email", email);
            consultar.setParameter("senha", senha);
            usuarioLogado = (Usuario) consultar.getSingleResult();
            finalizarConexaoBD();
            return usuarioLogado;
        } catch (NoResultException ex) {
            return null;
        }        
    }

}
