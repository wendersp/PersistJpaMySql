
package br.com.wpsistemas.persistjpamysql.model.dao;

import br.com.wpsistemas.persistjpamysql.model.entidades.Cidade;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author wender
 */
public class CidadeDao extends GenericDao {
    
    public void salvar(Cidade cidade) {
        iniciarConexaoBD();

        entityManager.getTransaction().begin();

        System.out.println("Salvando a pessoa.");
        if (cidade.getId() == null) {
            entityManager.persist(cidade);
        } else {
            entityManager.merge(cidade);
        }
        entityManager.getTransaction().commit();
        finalizarConexaoBD();
        System.out.println("Usuario Salvo com sucesso...");
    }

    public void excluir(Cidade cidade) {
        this.excluir(cidade.getId());
    }

    public void excluir(Long id) {
        iniciarConexaoBD();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Cidade.class, id));
        entityManager.getTransaction().commit();
        System.out.println("Cidade excluida com sucesso...");
        finalizarConexaoBD();
    }

    public List<Cidade> pesquisarAll() {
        iniciarConexaoBD();
        List<Cidade> lstCidade;
        Query consulta = entityManager.createNamedQuery("Cidade.findAll");
        lstCidade = consulta.getResultList();
        finalizarConexaoBD();
        return lstCidade;
    }
    
    
    public Cidade pesquisar(Long id) {
        iniciarConexaoBD();
        Cidade cidade = (Cidade) entityManager.find(Cidade.class, id);
        finalizarConexaoBD();
        return cidade;
    }

    public List<Cidade> pesquisar(String nome) {
        iniciarConexaoBD();
        List<Cidade> lstCidade;
        Query consulta = entityManager.createNamedQuery("Cidade.findByNome");
        consulta.setParameter("nome", nome.toUpperCase() + "%");
        lstCidade = consulta.getResultList();
        finalizarConexaoBD();
        return lstCidade;
    }

    public List<Cidade> pesquisarPorEstado(String estado) {
        iniciarConexaoBD();
        List<Cidade> lstCidade;
        Query consulta = entityManager.createNamedQuery("Cidade.findByUf");
        consulta.setParameter("uf", estado);
        lstCidade = consulta.getResultList();
        finalizarConexaoBD();
        return lstCidade;
    }
}
