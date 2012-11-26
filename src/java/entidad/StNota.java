/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "st_nota", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StNota.findAll", query = "SELECT s FROM StNota s"),
    @NamedQuery(name = "StNota.findByCodigoNota", query = "SELECT s FROM StNota s WHERE s.codigoNota = :codigoNota"),
    @NamedQuery(name = "StNota.findByNota", query = "SELECT s FROM StNota s WHERE s.nota = :nota")})
public class StNota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoNota", nullable = false)
    private Integer codigoNota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nota", nullable = false)
    private int nota;
    @JoinColumn(name = "CodigoTallerAlumno", referencedColumnName = "CodigoTallerAlumno", nullable = false)
    @ManyToOne(optional = false)
    private StTalleralumno codigoTallerAlumno;

    public StNota() {
    }

    public StNota(Integer codigoNota) {
        this.codigoNota = codigoNota;
    }

    public StNota(Integer codigoNota, int nota) {
        this.codigoNota = codigoNota;
        this.nota = nota;
    }

    public Integer getCodigoNota() {
        return codigoNota;
    }

    public void setCodigoNota(Integer codigoNota) {
        this.codigoNota = codigoNota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
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
        hash += (codigoNota != null ? codigoNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StNota)) {
            return false;
        }
        StNota other = (StNota) object;
        if ((this.codigoNota == null && other.codigoNota != null) || (this.codigoNota != null && !this.codigoNota.equals(other.codigoNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.StNota[ codigoNota=" + codigoNota + " ]";
    }
    
}
