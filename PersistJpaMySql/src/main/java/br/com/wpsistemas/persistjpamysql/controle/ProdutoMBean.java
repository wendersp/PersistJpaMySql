
package br.com.wpsistemas.persistjpamysql.controle;

import br.com.wpsistemas.persistjpamysql.model.dao.ProdutoDao;
import br.com.wpsistemas.persistjpamysql.model.entidades.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author wender
 */
@Named(value = "produtoMBean")
@SessionScoped
public class ProdutoMBean implements Serializable {

    private final String FORM_CAD = "produtoFrm";
    private final String FORM_CONS = "produtoCons";
    
    private Produto produto;
    private ProdutoDao produtoDao;
    
    private String nomePesquisar;
    private List<Produto> listProdutos;
    
    public String voltar() {
        return this.FORM_CONS;
    }
    
    public String novo() {
        this.produto = new Produto();
        return this.FORM_CAD;
    }
    
    public String salvar() {
        if (produtoDao == null) {
            produtoDao = new ProdutoDao();
        }        
        produtoDao.salvar(produto);        
        return this.FORM_CONS;
    }
    
    public void pesquisar() {
        if (produtoDao == null) {
            produtoDao = new ProdutoDao();
        } 
        listProdutos = produtoDao.pesquisar(this.nomePesquisar);
   }
    
    public String editar() {        
        return this.FORM_CAD;
    }
    
    public void excluir() {
        if (produtoDao == null) {
            produtoDao = new ProdutoDao();
        } 
        produtoDao.excluir(produto);
    }
    

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getNomePesquisar() {
        return nomePesquisar;
    }

    public void setNomePesquisar(String nomePesquisar) {
        this.nomePesquisar = nomePesquisar;
    }

    public List<Produto> getListProdutos() {
        return listProdutos;
    }

    public void setListProdutos(List<Produto> listProdutos) {
        this.listProdutos = listProdutos;
    }
    
    
   
    
    
}
