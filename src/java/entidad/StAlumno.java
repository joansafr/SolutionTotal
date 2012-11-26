/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "st_alumno", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StAlumno.findAll", query = "SELECT s FROM StAlumno s"),
    @NamedQuery(name = "StAlumno.findByCodigoAlumno", query = "SELECT s FROM StAlumno s WHERE s.codigoAlumno = :codigoAlumno"),
    @NamedQuery(name = "StAlumno.findByNombreAlumno", query = "SELECT s FROM StAlumno s WHERE s.nombreAlumno = :nombreAlumno"),
    @NamedQuery(name = "StAlumno.findByApellidoPaternoAlumno", query = "SELECT s FROM StAlumno s WHERE s.apellidoPaternoAlumno = :apellidoPaternoAlumno"),
    @NamedQuery(name = "StAlumno.findByApellidoMaternoAlumno", query = "SELECT s FROM StAlumno s WHERE s.apellidoMaternoAlumno = :apellidoMaternoAlumno"),
    @NamedQuery(name = "StAlumno.findByCorreoElectronicoAlumno", query = "SELECT s FROM StAlumno s WHERE s.correoElectronicoAlumno = :correoElectronicoAlumno"),
    @NamedQuery(name = "StAlumno.findByTelefonoFijoAlumno", query = "SELECT s FROM StAlumno s WHERE s.telefonoFijoAlumno = :telefonoFijoAlumno"),
    @NamedQuery(name = "StAlumno.findByTelefonoMovilAlumno", query = "SELECT s FROM StAlumno s WHERE s.telefonoMovilAlumno = :telefonoMovilAlumno")})
public class StAlumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoAlumno", nullable = false)
    private Integer codigoAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NombreAlumno", nullable = false, length = 50)
    private String nombreAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ApellidoPaternoAlumno", nullable = false, length = 50)
    private String apellidoPaternoAlumno;
    @Size(max = 50)
    @Column(name = "ApellidoMaternoAlumno", length = 50)
    private String apellidoMaternoAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CorreoElectronicoAlumno", nullable = false, length = 50)
    private String correoElectronicoAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "TelefonoFijoAlumno", nullable = false, length = 15)
    private String telefonoFijoAlumno;
    @Size(max = 15)
    @Column(name = "TelefonoMovilAlumno", length = 15)
    private String telefonoMovilAlumno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoAlumno")
    private Collection<StTalleralumno> stTalleralumnoCollection;

    public StAlumno() {
    }

    public StAlumno(Integer codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public StAlumno(Integer codigoAlumno, String nombreAlumno, String apellidoPaternoAlumno, String correoElectronicoAlumno, String telefonoFijoAlumno) {
        this.codigoAlumno = codigoAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoPaternoAlumno = apellidoPaternoAlumno;
        this.correoElectronicoAlumno = correoElectronicoAlumno;
        this.telefonoFijoAlumno = telefonoFijoAlumno;
    }

    public Integer getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(Integer codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoPaternoAlumno() {
        return apellidoPaternoAlumno;
    }

    public void setApellidoPaternoAlumno(String apellidoPaternoAlumno) {
        this.apellidoPaternoAlumno = apellidoPaternoAlumno;
    }

    public String getApellidoMaternoAlumno() {
        return apellidoMaternoAlumno;
    }

    public void setApellidoMaternoAlumno(String apellidoMaternoAlumno) {
        this.apellidoMaternoAlumno = apellidoMaternoAlumno;
    }

    public String getCorreoElectronicoAlumno() {
        return correoElectronicoAlumno;
    }

    public void setCorreoElectronicoAlumno(String correoElectronicoAlumno) {
        this.correoElectronicoAlumno = correoElectronicoAlumno;
    }

    public String getTelefonoFijoAlumno() {
        return telefonoFijoAlumno;
    }

    public void setTelefonoFijoAlumno(String telefonoFijoAlumno) {
        this.telefonoFijoAlumno = telefonoFijoAlumno;
    }

    public String getTelefonoMovilAlumno() {
        return telefonoMovilAlumno;
    }

    public void setTelefonoMovilAlumno(String telefonoMovilAlumno) {
        this.telefonoMovilAlumno = telefonoMovilAlumno;
    }

    @XmlTransient
    public Collection<StTalleralumno> getStTalleralumnoCollection() {
        return stTalleralumnoCollection;
    }

    public void setStTalleralumnoCollection(Collection<StTalleralumno> stTalleralumnoCollection) {
        this.stTalleralumnoCollection = stTalleralumnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAlumno != null ? codigoAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StAlumno)) {
            return false;
        }
        StAlumno other = (StAlumno) object;
        if ((this.codigoAlumno == null && other.codigoAlumno != null) || (this.codigoAlumno != null && !this.codigoAlumno.equals(other.codigoAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "["+codigoAlumno + "] "+nombreAlumno+" "+apellidoPaternoAlumno+" "+apellidoMaternoAlumno ;
    }
    
}
