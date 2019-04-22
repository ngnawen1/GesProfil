/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucien FOTSA
 */
@Entity
@Table(name = "profil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profil.findAll", query = "SELECT p FROM Profil p"),
    @NamedQuery(name = "Profil.findByIdprofil", query = "SELECT p FROM Profil p WHERE p.idprofil = :idprofil"),
    @NamedQuery(name = "Profil.findByConfig", query = "SELECT p FROM Profil p WHERE p.config = :config")})
public class Profil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprofil")
    private Integer idprofil;
    @Size(max = 2147483647)
    @Column(name = "config")
    private String config;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne
    private Utilisateur idutilisateur;
    @JoinColumn(name = "idtypeutilisateur", referencedColumnName = "idtypeutilisateur")
    @ManyToOne
    private Typeutilisateur idtypeutilisateur;

    public Profil() {
    }

    public Profil(Integer idprofil) {
        this.idprofil = idprofil;
    }

    public Integer getIdprofil() {
        return idprofil;
    }

    public void setIdprofil(Integer idprofil) {
        this.idprofil = idprofil;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Typeutilisateur getIdtypeutilisateur() {
        return idtypeutilisateur;
    }

    public void setIdtypeutilisateur(Typeutilisateur idtypeutilisateur) {
        this.idtypeutilisateur = idtypeutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofil != null ? idprofil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profil)) {
            return false;
        }
        Profil other = (Profil) object;
        if ((this.idprofil == null && other.idprofil != null) || (this.idprofil != null && !this.idprofil.equals(other.idprofil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Profil[ idprofil=" + idprofil + " ]";
    }
    
}
