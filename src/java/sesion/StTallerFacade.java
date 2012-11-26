/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.StTaller;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class StTallerFacade extends AbstractFacade<StTaller> {
    @PersistenceContext(unitName = "SolutionTotalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StTallerFacade() {
        super(StTaller.class);
    }
    
}
