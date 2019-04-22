/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Typeutilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lucien FOTSA
 */
@Stateless
public class TypeutilisateurFacade extends AbstractFacade<Typeutilisateur> implements TypeutilisateurFacadeLocal {
    @PersistenceContext(unitName = "GesProfil-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeutilisateurFacade() {
        super(Typeutilisateur.class);
    }
    
}
