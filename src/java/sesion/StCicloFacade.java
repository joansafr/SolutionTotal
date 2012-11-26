/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import entidad.StCiclo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class StCicloFacade extends AbstractFacade<StCiclo> {
    @PersistenceContext(unitName = "SolutionTotalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StCicloFacade() {
        super(StCiclo.class);
    }
    
}
