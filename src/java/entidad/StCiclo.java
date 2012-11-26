/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "st_ciclo", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StCiclo.findAll", query = "SELECT s FROM StCiclo s"),
    @NamedQuery(name = "StCiclo.findByAnoCiclo", query = "SELECT s FROM StCiclo s WHERE s.anoCiclo = :anoCiclo"),
    @NamedQuery(name = "StCiclo.findByNumeroCiclo", query = "SELECT s FROM StCiclo s WHERE s.numeroCiclo = :numeroCiclo"),
    @NamedQuery(name = "StCiclo.findByFechaInicioCiclo", query = "SELECT s FROM StCiclo s WHERE s.fechaInicioCiclo = :fechaInicioCiclo"),
    @NamedQuery(name = "StCiclo.findByCodigoCiclo", query = "SELECT s FROM StCiclo s WHERE s.codigoCiclo = :codigoCiclo"),
    @NamedQuery(name = "StCiclo.findByFechaFinCiclo", query = "SELECT s FROM StCiclo s WHERE s.fechaFinCiclo = :fechaFinCiclo")})
public class StCiclo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 4)
    @Column(name = "AnoCiclo", length = 4)
    private String anoCiclo;
    @Size(max = 2)
    @Column(name = "NumeroCiclo", length = 2)
    private String numeroCiclo;
    @Column(name = "FechaInicioCiclo")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioCiclo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoCiclo", nullable = false)
    private Integer codigoCiclo;
    @Column(name = "FechaFinCiclo")
    @Temporal(TemporalType.DATE)
    private Date fechaFinCiclo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCiclo")
    private Collection<StTaller> stTallerCollection;

    public StCiclo() {
    }

    public StCiclo(Integer codigoCiclo) {
        this.codigoCiclo = codigoCiclo;
    }

    public String getAnoCiclo() {
        return anoCiclo;
    }

    public void setAnoCiclo(String anoCiclo) {
        this.anoCiclo = anoCiclo;
    }

    public String getNumeroCiclo() {
        return numeroCiclo;
    }

    public void setNumeroCiclo(String numeroCiclo) {
        this.numeroCiclo = numeroCiclo;
    }

    public Date getFechaInicioCiclo() {
        return fechaInicioCiclo;
    }

    public void setFechaInicioCiclo(Date fechaInicioCiclo) {
        this.fechaInicioCiclo = fechaInicioCiclo;
    }

    public Integer getCodigoCiclo() {
        return codigoCiclo;
    }

    public void setCodigoCiclo(Integer codigoCiclo) {
        this.codigoCiclo = codigoCiclo;
    }

    public Date getFechaFinCiclo() {
        return fechaFinCiclo;
    }

    public void setFechaFinCiclo(Date fechaFinCiclo) {
        this.fechaFinCiclo = fechaFinCiclo;
    }

    @XmlTransient
    public Collection<StTaller> getStTallerCollection() {
        return stTallerCollection;
    }

    public void setStTallerCollection(Collection<StTaller> stTallerCollection) {
        this.stTallerCollection = stTallerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCiclo != null ? codigoCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StCiclo)) {
            return false;
        }
        StCiclo other = (StCiclo) object;
        if ((this.codigoCiclo == null && other.codigoCiclo != null) || (this.codigoCiclo != null && !this.codigoCiclo.equals(other.codigoCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return anoCiclo +"-" +numeroCiclo;
    }
    
}
