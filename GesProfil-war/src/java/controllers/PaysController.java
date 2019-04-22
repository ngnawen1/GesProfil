/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Utils;
import entities.Pays;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sessions.PaysFacadeLocal;

/**
 *
 * @author Lucien FOTSA
 */
@Named(value = "paysController")
@SessionScoped
public class PaysController implements Serializable {

    @Inject
    private PaysFacadeLocal paysFacade;
    private List<Pays> listPays = new ArrayList<Pays>();
    private Pays pays = new Pays();
    private String msg = "";
    private boolean showMsg = false;

    /**
     * Creates a new instance of PaysController
     */
    public PaysController() {
    }

    public void prepareCreate() {
        pays = new Pays();
    }

    public void prepareEdit() {
    }
    
    public String imprimer(){
        try{
            (new Utils()).print("Reports/ListePays.jasper");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
            return ext.getRequestPathInfo()+"?faces-redirect=true";
        }
    }

    public String pays() {
        listPays.clear();
        listPays.addAll(paysFacade.findAll());
        return "pays.xhtml?faces-redirect=true";
    }

    public String savePays() {
        try {
            if (paysFacade.findByNom(pays.getNom()).isEmpty()) {
                pays.setIdpays(paysFacade.nextId());
                paysFacade.create(pays);
                msg = "Enregistrement effectué avec succès!";
            } else {
                msg = "Le pays : " + pays.getNom() + " existe déjà!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Echec de l'opération!";
        } finally {
            showMsg = true;
            return pays();
        }
    }

    public String editPays() {
        try {
            if (paysFacade.findByNom(pays.getNom()).isEmpty()) {
                paysFacade.edit(pays);
                msg = "Modification effectuée avec succès!";
            } else {
                msg = "Le pays : " + pays.getNom() + " existe déjà!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Echec de l'opération!";
        } finally {
            showMsg = true;
            return pays();
        }
    }

    public String deletePays() {
        try {
            paysFacade.remove(pays);
            msg = "Suppression effectuée avec succès!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Echec de l'opération!";
        } finally {
            showMsg = true;
            return pays();
        }
    }

    public List<Pays> getListPays() {
        return listPays;
    }

    public void setListPays(List<Pays> listPays) {
        this.listPays = listPays;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isShowMsg() {
        return showMsg;
    }

    public void setShowMsg(boolean showMsg) {
        this.showMsg = showMsg;
    }
}
