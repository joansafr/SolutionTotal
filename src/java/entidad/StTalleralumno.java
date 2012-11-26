/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "st_talleralumno", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StTalleralumno.findAll", query = "SELECT s FROM StTalleralumno s"),
    @NamedQuery(name = "StTalleralumno.findByCodigoTallerAlumno", query = "SELECT s FROM StTalleralumno s WHERE s.codigoTallerAlumno = :codigoTallerAlumno")})
public class StTalleralumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoTallerAlumno", nullable = false)
    private Integer codigoTallerAlumno;
    @JoinColumn(name = "CodigoFormaPago", referencedColumnName = "CodigoFormaPago", nullable = false)
    @ManyToOne(optional = false)
    private StFormapago codigoFormaPago;
    @JoinColumn(name = "CodigoTaller", referencedColumnName = "CodigoTaller", nullable = false)
    @ManyToOne(optional = false)
    private StTaller codigoTaller;
    @JoinColumn(name = "CodigoAlumno", referencedColumnName = "CodigoAlumno", nullable = false)
    @ManyToOne(optional = false)
    private StAlumno codigoAlumno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTallerAlumno")
    private Collection<StAsistencia> stAsistenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTallerAlumno")
    private Collection<StPago> stPagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTallerAlumno")
    private Collection<StNota> stNotaCollection;

    public StTalleralumno() {
    }

    public StTalleralumno(Integer codigoTallerAlumno) {
        this.codigoTallerAlumno = codigoTallerAlumno;
    }

    public Integer getCodigoTallerAlumno() {
        return codigoTallerAlumno;
    }

    public void setCodigoTallerAlumno(Integer codigoTallerAlumno) {
        this.codigoTallerAlumno = codigoTallerAlumno;
    }

    public StFormapago getCodigoFormaPago() {
        return codigoFormaPago;
    }

    public void setCodigoFormaPago(StFormapago codigoFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
    }

    public StTaller getCodigoTaller() {
        return codigoTaller;
    }

    public void setCodigoTaller(StTaller codigoTaller) {
        this.codigoTaller = codigoTaller;
    }

    public StAlumno getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(StAlumno codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    @XmlTransient
    public Collection<StAsistencia> getStAsistenciaCollection() {
        return stAsistenciaCollection;
    }

    public void setStAsistenciaCollection(Collection<StAsistencia> stAsistenciaCollection) {
        this.stAsistenciaCollection = stAsistenciaCollection;
    }

    @XmlTransient
    public Collection<StPago> getStPagoCollection() {
        return stPagoCollection;
    }

    public void setStPagoCollection(Collection<StPago> stPagoCollection) {
        this.stPagoCollection = stPagoCollection;
    }

    @XmlTransient
    public Collection<StNota> getStNotaCollection() {
        return stNotaCollection;
    }

    public void setStNotaCollection(Collection<StNota> stNotaCollection) {
        this.stNotaCollection = stNotaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTallerAlumno != null ? codigoTallerAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StTalleralumno)) {
            return false;
        }
        StTalleralumno other = (StTalleralumno) object;
        if ((this.codigoTallerAlumno == null && other.codigoTallerAlumno != null) || (this.codigoTallerAlumno != null && !this.codigoTallerAlumno.equals(other.codigoTallerAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "["+codigoTaller.getCodigoCiclo().getAnoCiclo()+"-"+codigoTaller.getCodigoCiclo().getNumeroCiclo()+"] "+ codigoTaller.getCodigoCurso().getNombreCurso() +" ("+codigoTaller.getPrecioTaller().toString()+")"+
                " - " +"["+ codigoAlumno.getCodigoAlumno().toString()+")] "+  codigoAlumno.getNombreAlumno()+" "+ codigoAlumno.getApellidoPaternoAlumno() +" "+ codigoAlumno.getApellidoMaternoAlumno();
    }
    
}
