/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Operations;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lucien FOTSA
 */
@Stateless
public class OperationsFacade extends AbstractFacade<Operations> implements OperationsFacadeLocal {
    @PersistenceContext(unitName = "GesProfil-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperationsFacade() {
        super(Operations.class);
    }
    
}
