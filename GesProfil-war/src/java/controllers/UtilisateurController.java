/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Utilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sessions.UtilisateurFacadeLocal;

/**
 *
 * @author Lucien FOTSA
 */
@Named(value = "utilisateurController")
@SessionScoped
public class UtilisateurController implements Serializable {

    @Inject
    private UtilisateurFacadeLocal utilisateurFacade;
    private List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
    private Utilisateur utilisateur = new Utilisateur();
    
    /**
     * Creates a new instance of UtilisateurController
     */
    public UtilisateurController() {
    }
    
    public String utilisateur(){
        listUtilisateur.clear();
        listUtilisateur.addAll(utilisateurFacade.findAll());
        return "utilisateur.xhtml?faces-redirect=true";
    }

    public UtilisateurFacadeLocal getUtilisateurFacade() {
        return utilisateurFacade;
    }

    public void setUtilisateurFacade(UtilisateurFacadeLocal utilisateurFacade) {
        this.utilisateurFacade = utilisateurFacade;
    }

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
        this.listUtilisateur = listUtilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
