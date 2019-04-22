/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lucien FOTSA
 */
@Entity
@Table(name = "typeutilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typeutilisateur.findAll", query = "SELECT t FROM Typeutilisateur t"),
    @NamedQuery(name = "Typeutilisateur.findByIdtypeutilisateur", query = "SELECT t FROM Typeutilisateur t WHERE t.idtypeutilisateur = :idtypeutilisateur"),
    @NamedQuery(name = "Typeutilisateur.findByNom", query = "SELECT t FROM Typeutilisateur t WHERE t.nom = :nom")})
public class Typeutilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtypeutilisateur")
    private Integer idtypeutilisateur;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @JoinTable(name = "utilissateurtypeutilisateur", joinColumns = {
        @JoinColumn(name = "idtypeutilisateur", referencedColumnName = "idtypeutilisateur")}, inverseJoinColumns = {
        @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")})
    @ManyToMany
    private Collection<Utilisateur> utilisateurCollection;
    @OneToMany(mappedBy = "idtypeutilisateur")
    private Collection<Profil> profilCollection;

    public Typeutilisateur() {
    }

    public Typeutilisateur(Integer idtypeutilisateur) {
        this.idtypeutilisateur = idtypeutilisateur;
    }

    public Integer getIdtypeutilisateur() {
        return idtypeutilisateur;
    }

    public void setIdtypeutilisateur(Integer idtypeutilisateur) {
        this.idtypeutilisateur = idtypeutilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @XmlTransient
    public Collection<Profil> getProfilCollection() {
        return profilCollection;
    }

    public void setProfilCollection(Collection<Profil> profilCollection) {
        this.profilCollection = profilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypeutilisateur != null ? idtypeutilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeutilisateur)) {
            return false;
        }
        Typeutilisateur other = (Typeutilisateur) object;
        if ((this.idtypeutilisateur == null && other.idtypeutilisateur != null) || (this.idtypeutilisateur != null && !this.idtypeutilisateur.equals(other.idtypeutilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typeutilisateur[ idtypeutilisateur=" + idtypeutilisateur + " ]";
    }
}
