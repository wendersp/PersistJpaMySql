
package br.com.wpsistemas.persistjpamysql.controle;

import br.com.wpsistemas.persistjpamysql.model.dao.CidadeDao;
import br.com.wpsistemas.persistjpamysql.model.dao.UsuarioDao;
import br.com.wpsistemas.persistjpamysql.model.entidades.Cidade;
import br.com.wpsistemas.persistjpamysql.model.entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author wender
 */
@Named(value = "usuarioMBean")
@SessionScoped
public class UsuarioMBean implements Serializable {

    private Usuario usuario;
    private List<Cidade> listCidades;
    private List<Usuario> listUsuarios;
    
    private String nomePesquisar;
    
    private UsuarioDao usuarioDao = new UsuarioDao();
    private CidadeDao cidadeDao = new CidadeDao();
    
   
    public UsuarioMBean() {
        usuario = new Usuario();
        carregarListCidade();
        listUsuarios = new UsuarioDao().pesquisar("");
        
    }
    
    public void salvar() {        
        usuarioDao.salvar(usuario);
        usuario = new Usuario();
        carregarListCidade();
    }

    public void pesquisarPorNome() {
        if (usuarioDao ==  null) {
            usuarioDao = new UsuarioDao();
        }
        listUsuarios = usuarioDao.pesquisar(nomePesquisar);
        nomePesquisar = "";
    }
    
    
    private void carregarListCidade() {
        if (cidadeDao ==  null) {
            cidadeDao = new CidadeDao();
        }
        listCidades = cidadeDao.pesquisarAll();
    }
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Cidade> getListCidades() {
        return listCidades;
    }

    public void setListCidades(List<Cidade> listCidades) {
        this.listCidades = listCidades;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public String getNomePesquisar() {
        return nomePesquisar;
    }

    public void setNomePesquisar(String nomePesquisar) {
        this.nomePesquisar = nomePesquisar;
    }
    
    
   
    
    
    
}
