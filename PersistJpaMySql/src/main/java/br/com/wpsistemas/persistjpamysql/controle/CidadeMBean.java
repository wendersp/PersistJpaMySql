package br.com.wpsistemas.persistjpamysql.controle;

import br.com.wpsistemas.persistjpamysql.model.dao.CidadeDao;
import br.com.wpsistemas.persistjpamysql.model.entidades.Cidade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author wender
 */
@Named(value = "cidadeMBean")
@SessionScoped
public class CidadeMBean implements Serializable {

    private List<Cidade> listCidades;
    private Cidade cidade;
    private String nomePesquisar;
    
    private CidadeDao cidadeDao;
    
    
    public CidadeMBean() {
        
    }

    private void carregarDao() {
        if (cidadeDao == null) {
            cidadeDao = new CidadeDao();
        }
    }
    
    public String novo() {
        cidade = new Cidade();        
        return "cidadeFrm";
    }
    
    public String salvar() {
        carregarDao();
        cidadeDao.salvar(cidade);
        cidade = null;
        return "cidadeCons";
    }
    
    public String editar() {        
        return "cidadeFrm";
    }
    
    public void excluir() {
        System.out.println("Excluindo cidade.....");
        carregarDao();
        cidadeDao.excluir(cidade);
        cidade = null;
        pesquisar();
    }
    
    
    
    public void pesquisar() {
       carregarDao();
        listCidades = cidadeDao.pesquisar(nomePesquisar);
        
    }
    
    
    public List<Cidade> getListCidades() {
        return listCidades;
    }

    public void setListCidades(List<Cidade> listCidades) {
        this.listCidades = listCidades;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNomePesquisar() {
        return nomePesquisar;
    }

    public void setNomePesquisar(String nomePesquisar) {
        this.nomePesquisar = nomePesquisar;
    }
        
    
}
