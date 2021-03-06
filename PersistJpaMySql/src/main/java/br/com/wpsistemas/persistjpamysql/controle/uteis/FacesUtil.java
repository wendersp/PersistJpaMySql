package br.com.wpsistemas.persistjpamysql.controle.uteis;

import java.io.Serializable;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wender
 */
public class FacesUtil implements Serializable {

    public static void addErrorMessage(String message) {        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));        
        /*Faz com que a mensgam sobreviva ao redirecionamento*/
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public static void addInfoMensage(String message) {
        FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
        FacesContext.getCurrentInstance().addMessage(null, fmsg);        
        /*Faz com que a mensgam sobreviva ao redirecionamento*/
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    public static void setObjetoSession(String paramento, Object objeto) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.setAttribute(paramento, objeto);
    }

    public static Object getObjetoSession(String paramento) {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        return session.getAttribute(paramento);
    }

    public static void performNavigation(String pagina) {
        ConfigurableNavigationHandler configurableNavigationHandler
                = (ConfigurableNavigationHandler) FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
        configurableNavigationHandler.performNavigation(pagina + "?faces-redirect=true");
    }
}
