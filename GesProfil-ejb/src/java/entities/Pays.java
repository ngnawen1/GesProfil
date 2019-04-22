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
@Table(name = "pays")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pays.findAll", query = "SELECT p FROM Pays p"),
    @NamedQuery(name = "Pays.nextId", query = "SELECT MAX(p.idpays) FROM Pays p"),
    @NamedQuery(name = "Pays.findByIdpays", query = "SELECT p FROM Pays p WHERE p.idpays = :idpays"),
    @NamedQuery(name = "Pays.findByNom", query = "SELECT p FROM Pays p WHERE p.nom = :nom")})
public class Pays implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpays")
    private Integer idpays;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy = "idpays")
    private Collection<Region> regionCollection;
    @OneToMany(mappedBy = "idpays")
    private Collection<Utilisateur> utilisateurCollection;

    public Pays() {
    }

    public Pays(Integer idpays) {
        this.idpays = idpays;
    }

    public Integer getIdpays() {
        return idpays;
    }

    public void setIdpays(Integer idpays) {
        this.idpays = idpays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Region> getRegionCollection() {
        return regionCollection;
    }

    public void setRegionCollection(Collection<Region> regionCollection) {
        this.regionCollection = regionCollection;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpays != null ? idpays.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pays)) {
            return false;
        }
        Pays other = (Pays) object;
        if ((this.idpays == null && other.idpays != null) || (this.idpays != null && !this.idpays.equals(other.idpays))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pays[ idpays=" + idpays + " ]";
    }
}
