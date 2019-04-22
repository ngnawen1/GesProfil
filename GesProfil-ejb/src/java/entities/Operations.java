/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucien FOTSA
 */
@Entity
@Table(name = "operations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operations.findAll", query = "SELECT o FROM Operations o"),
    @NamedQuery(name = "Operations.findByIdoperations", query = "SELECT o FROM Operations o WHERE o.idoperations = :idoperations"),
    @NamedQuery(name = "Operations.findByNom", query = "SELECT o FROM Operations o WHERE o.nom = :nom"),
    @NamedQuery(name = "Operations.findByCible", query = "SELECT o FROM Operations o WHERE o.cible = :cible"),
    @NamedQuery(name = "Operations.findByDateop", query = "SELECT o FROM Operations o WHERE o.dateop = :dateop"),
    @NamedQuery(name = "Operations.findByHeureop", query = "SELECT o FROM Operations o WHERE o.heureop = :heureop")})
public class Operations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idoperations")
    private Integer idoperations;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "cible")
    private String cible;
    @Column(name = "dateop")
    @Temporal(TemporalType.DATE)
    private Date dateop;
    @Column(name = "heureop")
    @Temporal(TemporalType.TIME)
    private Date heureop;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne
    private Utilisateur idutilisateur;

    public Operations() {
    }

    public Operations(Integer idoperations) {
        this.idoperations = idoperations;
    }

    public Integer getIdoperations() {
        return idoperations;
    }

    public void setIdoperations(Integer idoperations) {
        this.idoperations = idoperations;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCible() {
        return cible;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }

    public Date getDateop() {
        return dateop;
    }

    public void setDateop(Date dateop) {
        this.dateop = dateop;
    }

    public Date getHeureop() {
        return heureop;
    }

    public void setHeureop(Date heureop) {
        this.heureop = heureop;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoperations != null ? idoperations.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operations)) {
            return false;
        }
        Operations other = (Operations) object;
        if ((this.idoperations == null && other.idoperations != null) || (this.idoperations != null && !this.idoperations.equals(other.idoperations))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operations[ idoperations=" + idoperations + " ]";
    }
    
}
