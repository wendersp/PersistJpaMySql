package br.com.wpsistemas.persistjpamysql.model.dao;

import br.com.wpsistemas.persistjpamysql.model.entidades.Produto;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author wender
 */
public class ProdutoDao extends GenericDao {

    public void salvar(Produto produto) {
        super.iniciarConexaoBD();
        super.entityManager.getTransaction().begin();
        produto.setPrecoVenda(calcPrecoVenda(produto));
        if (produto.getId() == null) {
            super.entityManager.persist(produto);
        } else {
            super.entityManager.merge(produto);
        }
        super.entityManager.getTransaction().commit();
        super.finalizarConexaoBD();
    }

    private double calcPrecoVenda(Produto produto) {
        double pVenda = produto.getPrecoCusto() + (produto.getPrecoCusto() * produto.getMargemLucro());
        return pVenda;
    }

    public void excluir(Produto produto) {
        excluir(produto.getId());
    }

    public void excluir(Long id) {
        super.iniciarConexaoBD();
        super.entityManager.getTransaction().begin();
        super.entityManager.remove(pesquisar(id));
        super.entityManager.getTransaction().commit();
        super.finalizarConexaoBD();
    }

    public Produto pesquisar(Long id) {
        super.iniciarConexaoBD();
        Produto produto = super.entityManager.find(Produto.class, id);
        super.finalizarConexaoBD();
        return produto;
    }

    public List<Produto> pesquisar(String nome) {
        super.iniciarConexaoBD();
        Query consulta = super.entityManager.createNamedQuery("Produto.findByNome");
        consulta.setParameter("nome", nome + "%");
        List<Produto> listProduto = consulta.getResultList();
        super.finalizarConexaoBD();
        return listProduto;
    }
}
