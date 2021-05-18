/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wpsistemas.persistjpamysql.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author wender
 */
public class GenericDao {
    
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    protected void iniciarConexaoBD() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PresistJpaMysqlUP");
        entityManager = entityManagerFactory.createEntityManager();
    }

    protected void finalizarConexaoBD() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
    
}
