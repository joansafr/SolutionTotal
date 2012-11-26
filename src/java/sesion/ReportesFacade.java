/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Antonio
 */
@Stateless
public class ReportesFacade extends AbstractFacade<StAlumnoFacade> {
    @PersistenceContext(unitName = "SolutionTotalPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ReportesFacade() {
        super(StAlumnoFacade.class);
    }


     public List<Object> pa_ST_AlumnosPorTaller(Integer Taller) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_ST_AlumnosPorTaller(?) }"); 
            query.setParameter(1, Taller); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_ST_ProgramacionPorCiclo(Integer Ciclo) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_ST_ProgramacionPorCiclo(?) }"); 
            query.setParameter(1, Ciclo); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }

     /*TRANSPORTE*/
    
}
