/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Region;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucien FOTSA
 */
@Local
public interface RegionFacadeLocal {

    void create(Region region);

    void edit(Region region);

    void remove(Region region);

    Region find(Object id);

    List<Region> findAll();

    List<Region> findRange(int[] range);

    int count();
    
}
