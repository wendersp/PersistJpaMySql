
package br.com.wpsistemas.persistjpamysql.controle;

import br.com.wpsistemas.persistjpamysql.controle.uteis.FacesUtil;
import br.com.wpsistemas.persistjpamysql.model.entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author wender
 */
@Named(value = "homeMBean")
@RequestScoped
public class HomeMBean implements Serializable {

    private Usuario usuarioLogado;
   
    public HomeMBean() {
        this.obterUsuarioLogado();
    }
    
  
    public void obterUsuarioLogado() {
        this.usuarioLogado = (Usuario)FacesUtil.getObjetoSession("usuarioLogado");
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    
}
