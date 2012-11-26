/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "st_asistencia", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StAsistencia.findAll", query = "SELECT s FROM StAsistencia s"),
    @NamedQuery(name = "StAsistencia.findByCodigoAsistencia", query = "SELECT s FROM StAsistencia s WHERE s.codigoAsistencia = :codigoAsistencia"),
    @NamedQuery(name = "StAsistencia.findByFechaTallerAlumno", query = "SELECT s FROM StAsistencia s WHERE s.fechaTallerAlumno = :fechaTallerAlumno"),
    @NamedQuery(name = "StAsistencia.findByUsuarioAuditoria", query = "SELECT s FROM StAsistencia s WHERE s.usuarioAuditoria = :usuarioAuditoria")})
public class StAsistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoAsistencia", nullable = false)
    private Integer codigoAsistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaTallerAlumno", nullable = false, length = 18)
    @Temporal(TemporalType.DATE)
    private Date fechaTallerAlumno;
    @Size(max = 20)
    @Column(name = "UsuarioAuditoria", length = 20)
    private String usuarioAuditoria;
    @JoinColumn(name = "CodigoTallerAlumno", referencedColumnName = "CodigoTallerAlumno", nullable = false)
    @ManyToOne(optional = false)
    private StTalleralumno codigoTallerAlumno;

    public StAsistencia() {
    }

    public StAsistencia(Integer codigoAsistencia) {
        this.codigoAsistencia = codigoAsistencia;
    }

    public StAsistencia(Integer codigoAsistencia, Date fechaTallerAlumno) {
        this.codigoAsistencia = codigoAsistencia;
        this.fechaTallerAlumno = fechaTallerAlumno;
    }

    public Integer getCodigoAsistencia() {
        return codigoAsistencia;
    }

    public void setCodigoAsistencia(Integer codigoAsistencia) {
        this.codigoAsistencia = codigoAsistencia;
    }

    public Date getFechaTallerAlumno() {
        return fechaTallerAlumno;
    }

    public void setFechaTallerAlumno(Date fechaTallerAlumno) {
        this.fechaTallerAlumno = fechaTallerAlumno;
    }

    public String getUsuarioAuditoria() {
        return usuarioAuditoria;
    }

    public void setUsuarioAuditoria(String usuarioAuditoria) {
        this.usuarioAuditoria = usuarioAuditoria;
    }

    public StTalleralumno getCodigoTallerAlumno() {
        return codigoTallerAlumno;
    }

    public void setCodigoTallerAlumno(StTalleralumno codigoTallerAlumno) {
        this.codigoTallerAlumno = codigoTallerAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAsistencia != null ? codigoAsistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StAsistencia)) {
            return false;
        }
        StAsistencia other = (StAsistencia) object;
        if ((this.codigoAsistencia == null && other.codigoAsistencia != null) || (this.codigoAsistencia != null && !this.codigoAsistencia.equals(other.codigoAsistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.StAsistencia[ codigoAsistencia=" + codigoAsistencia + " ]";
    }
    
}
