/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "st_tallerlaboratorio", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StTallerlaboratorio.findAll", query = "SELECT s FROM StTallerlaboratorio s"),
    @NamedQuery(name = "StTallerlaboratorio.findByCodigoTallerLaboratorio", query = "SELECT s FROM StTallerlaboratorio s WHERE s.codigoTallerLaboratorio = :codigoTallerLaboratorio"),
    @NamedQuery(name = "StTallerlaboratorio.findByFechaTallerLaboratorio", query = "SELECT s FROM StTallerlaboratorio s WHERE s.fechaTallerLaboratorio = :fechaTallerLaboratorio"),
    @NamedQuery(name = "StTallerlaboratorio.findByHoraInicioTallerLaboratorio", query = "SELECT s FROM StTallerlaboratorio s WHERE s.horaInicioTallerLaboratorio = :horaInicioTallerLaboratorio"),
    @NamedQuery(name = "StTallerlaboratorio.findByHoraTerminoTallerLaboratorio", query = "SELECT s FROM StTallerlaboratorio s WHERE s.horaTerminoTallerLaboratorio = :horaTerminoTallerLaboratorio")})
public class StTallerlaboratorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoTallerLaboratorio", nullable = false)
    private Integer codigoTallerLaboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaTallerLaboratorio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaTallerLaboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HoraInicioTallerLaboratorio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicioTallerLaboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HoraTerminoTallerLaboratorio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaTerminoTallerLaboratorio;
    @JoinColumn(name = "CodigoLaboratorio", referencedColumnName = "CodigoLaboratorio", nullable = false)
    @ManyToOne(optional = false)
    private StLaboratorio codigoLaboratorio;
    @JoinColumn(name = "CodigoTaller", referencedColumnName = "CodigoTaller", nullable = false)
    @ManyToOne(optional = false)
    private StTaller codigoTaller;

    public StTallerlaboratorio() {
    }

    public StTallerlaboratorio(Integer codigoTallerLaboratorio) {
        this.codigoTallerLaboratorio = codigoTallerLaboratorio;
    }

    public StTallerlaboratorio(Integer codigoTallerLaboratorio, Date fechaTallerLaboratorio, Date horaInicioTallerLaboratorio, Date horaTerminoTallerLaboratorio) {
        this.codigoTallerLaboratorio = codigoTallerLaboratorio;
        this.fechaTallerLaboratorio = fechaTallerLaboratorio;
        this.horaInicioTallerLaboratorio = horaInicioTallerLaboratorio;
        this.horaTerminoTallerLaboratorio = horaTerminoTallerLaboratorio;
    }

    public Integer getCodigoTallerLaboratorio() {
        return codigoTallerLaboratorio;
    }

    public void setCodigoTallerLaboratorio(Integer codigoTallerLaboratorio) {
        this.codigoTallerLaboratorio = codigoTallerLaboratorio;
    }

    public Date getFechaTallerLaboratorio() {
        return fechaTallerLaboratorio;
    }

    public void setFechaTallerLaboratorio(Date fechaTallerLaboratorio) {
        this.fechaTallerLaboratorio = fechaTallerLaboratorio;
    }

    public Date getHoraInicioTallerLaboratorio() {
        return horaInicioTallerLaboratorio;
    }

    public void setHoraInicioTallerLaboratorio(Date horaInicioTallerLaboratorio) {
        this.horaInicioTallerLaboratorio = horaInicioTallerLaboratorio;
    }

    public Date getHoraTerminoTallerLaboratorio() {
        return horaTerminoTallerLaboratorio;
    }

    public void setHoraTerminoTallerLaboratorio(Date horaTerminoTallerLaboratorio) {
        this.horaTerminoTallerLaboratorio = horaTerminoTallerLaboratorio;
    }

    public StLaboratorio getCodigoLaboratorio() {
        return codigoLaboratorio;
    }

    public void setCodigoLaboratorio(StLaboratorio codigoLaboratorio) {
        this.codigoLaboratorio = codigoLaboratorio;
    }

    public StTaller getCodigoTaller() {
        return codigoTaller;
    }

    public void setCodigoTaller(StTaller codigoTaller) {
        this.codigoTaller = codigoTaller;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTallerLaboratorio != null ? codigoTallerLaboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StTallerlaboratorio)) {
            return false;
        }
        StTallerlaboratorio other = (StTallerlaboratorio) object;
        if ((this.codigoTallerLaboratorio == null && other.codigoTallerLaboratorio != null) || (this.codigoTallerLaboratorio != null && !this.codigoTallerLaboratorio.equals(other.codigoTallerLaboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.StTallerlaboratorio[ codigoTallerLaboratorio=" + codigoTallerLaboratorio + " ]";
    }
    
}
