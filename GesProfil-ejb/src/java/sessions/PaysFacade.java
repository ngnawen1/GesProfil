/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Pays;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Lucien FOTSA
 */
@Stateless
public class PaysFacade extends AbstractFacade<Pays> implements PaysFacadeLocal {

    @PersistenceContext(unitName = "GesProfil-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaysFacade() {
        super(Pays.class);
    }

    @Override
    public int nextId() {
        Query query = em.createNamedQuery("Pays.nextId");
        List listObj = query.getResultList();
        if (listObj.isEmpty()) {
            return 1;
        } else {
            return ((Integer) listObj.get(0)) + 1;
        }
    }

    @Override
    public List<Pays> findByNom(String nom) {
        Query query = em.createNamedQuery("Pays.findByNom");
        query.setParameter("nom", nom);
        List listObj = query.getResultList();
        return listObj;
    }
}
