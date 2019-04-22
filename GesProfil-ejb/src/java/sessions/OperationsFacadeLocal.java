/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Operations;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucien FOTSA
 */
@Local
public interface OperationsFacadeLocal {

    void create(Operations operations);

    void edit(Operations operations);

    void remove(Operations operations);

    Operations find(Object id);

    List<Operations> findAll();

    List<Operations> findRange(int[] range);

    int count();
    
}
