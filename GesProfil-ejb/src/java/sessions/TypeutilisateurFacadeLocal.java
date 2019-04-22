/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Typeutilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucien FOTSA
 */
@Local
public interface TypeutilisateurFacadeLocal {

    void create(Typeutilisateur typeutilisateur);

    void edit(Typeutilisateur typeutilisateur);

    void remove(Typeutilisateur typeutilisateur);

    Typeutilisateur find(Object id);

    List<Typeutilisateur> findAll();

    List<Typeutilisateur> findRange(int[] range);

    int count();
    
}
