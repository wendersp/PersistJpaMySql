
package br.com.wpsistemas.persistjpamysql.controle;

import br.com.wpsistemas.persistjpamysql.controle.uteis.FacesUtil;
import br.com.wpsistemas.persistjpamysql.model.dao.LoginServe;
import br.com.wpsistemas.persistjpamysql.model.entidades.Usuario;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author wender
 */
@Named(value = "loginMbean")
@SessionScoped
public class LoginMbean implements Serializable {
    
    private Usuario usuarioLogado = null;
    private String email = "";
    private String senha = "";
    
    LoginServe loginServe;

    public String logar() {
        if (loginServe == null) {
            this.loginServe = new LoginServe();
        }
        if ((email == null) || (email.equals(""))) {
            FacesUtil.addErrorMessage("Informe o E-mail.");
            return "login?faces-redirect=true";
        }
        if ((senha == null) || (senha.equals(""))) {
            FacesUtil.addErrorMessage("informe a senha.");
            return "login?faces-redirect=true";
        }
        this.usuarioLogado = this.loginServe.logar(email, senha);
        if ((this.usuarioLogado == null) || (this.usuarioLogado.getId() == null)) {
            FacesUtil.addErrorMessage("Usuario ou senha informado não encontrado.");
            return "login?faces-redirect=true";
        }
        FacesUtil.setObjetoSession("usuarioLogado", this.usuarioLogado);
        return "home?faces-redirect=true";
    }
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
