/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.StCiclo;
import entidad.StTaller;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import sesion.ReportesFacade;

/**
 *
 * @author Antonio
 */
@ManagedBean
@SessionScoped
public class Reporte {
    //Constructor
    public Reporte() {
    }
    //Constructor
    //Parametros
    private StCiclo _Ciclo;
    private StTaller _Taller;

    public StCiclo getCiclo() {
        return _Ciclo;
    }

    public void setCiclo(StCiclo _Ciclo) {
        this._Ciclo = _Ciclo;
    }

    public StTaller getTaller() {
        return _Taller;
    }

    public void setTaller(StTaller _Taller) {
        this._Taller = _Taller;
    }

    //Parametros
    
    //Global
    private DataModel DMReporte = null;
    @EJB
    private sesion.ReportesFacade ReportesFacade;
    
    public DataModel getDMReporte() {
        return DMReporte;
    }

    public void setDMReporte(DataModel DMReporte) {
        this.DMReporte = DMReporte;
    }
    //Global
    
    //Recuperacion
    public DataModel pa_ST_AlumnosPorTaller() 
     {
        if (ValidarParametro() == true) {
             DMReporte = new ListDataModel(ReportesFacade.pa_ST_AlumnosPorTaller(getTaller().getCodigoTaller())); 
            }
            return DMReporte;
     }
     public DataModel pa_ST_ProgramacionPorCiclo() 
     {
        if (ValidarParametro() == true) {
             DMReporte = new ListDataModel(ReportesFacade.pa_ST_ProgramacionPorCiclo(getCiclo().getCodigoCiclo())); 
            }
            return DMReporte;
     }
     //Recuperacion
    //Mostrar
     public void AlumnosPorTaller() 
     {
         DMReporte = pa_ST_AlumnosPorTaller(); 
     }
     public void ProgramacionPorCiclo() 
     {
         DMReporte = pa_ST_ProgramacionPorCiclo(); 
     }
    //Mostrar 
    
    
    public boolean ValidarParametro(){
        boolean _EsValido = true;
        ///Validar los Parametros  
        return _EsValido;
    }
    public String ir(String URL){
        DMReporte = null;
        return URL;
    }
}
