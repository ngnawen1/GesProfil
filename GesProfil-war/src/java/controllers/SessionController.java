/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lucien FOTSA
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    private String language = "fr";

    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }

    public String inFrench() {
        language = "fr";
        ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
        return ext.getRequestPathInfo() + "?faces-redirect=true";
    }
    
    public String inEnglish() {
        language = "en";
        ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
        return ext.getRequestPathInfo() + "?faces-redirect=true";
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
