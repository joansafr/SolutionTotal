/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "st_taller", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StTaller.findAll", query = "SELECT s FROM StTaller s"),
    @NamedQuery(name = "StTaller.findByCodigoTaller", query = "SELECT s FROM StTaller s WHERE s.codigoTaller = :codigoTaller"),
    @NamedQuery(name = "StTaller.findByCantidadHorasTaller", query = "SELECT s FROM StTaller s WHERE s.cantidadHorasTaller = :cantidadHorasTaller"),
    @NamedQuery(name = "StTaller.findByPrecioTaller", query = "SELECT s FROM StTaller s WHERE s.precioTaller = :precioTaller")})
public class StTaller implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoTaller", nullable = false)
    private Integer codigoTaller;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CantidadHorasTaller", nullable = false)
    private int cantidadHorasTaller;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecioTaller", nullable = false, precision = 9, scale = 2)
    private BigDecimal precioTaller;
    @JoinColumn(name = "CodigoCurso", referencedColumnName = "CodigoCurso", nullable = false)
    @ManyToOne(optional = false)
    private StCurso codigoCurso;
    @JoinColumn(name = "CodigoCiclo", referencedColumnName = "CodigoCiclo", nullable = false)
    @ManyToOne(optional = false)
    private StCiclo codigoCiclo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTaller")
    private Collection<StTalleralumno> stTalleralumnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTaller")
    private Collection<StTallerlaboratorio> stTallerlaboratorioCollection;

    public StTaller() {
    }

    public StTaller(Integer codigoTaller) {
        this.codigoTaller = codigoTaller;
    }

    public StTaller(Integer codigoTaller, int cantidadHorasTaller, BigDecimal precioTaller) {
        this.codigoTaller = codigoTaller;
        this.cantidadHorasTaller = cantidadHorasTaller;
        this.precioTaller = precioTaller;
    }

    public Integer getCodigoTaller() {
        return codigoTaller;
    }

    public void setCodigoTaller(Integer codigoTaller) {
        this.codigoTaller = codigoTaller;
    }

    public int getCantidadHorasTaller() {
        return cantidadHorasTaller;
    }

    public void setCantidadHorasTaller(int cantidadHorasTaller) {
        this.cantidadHorasTaller = cantidadHorasTaller;
    }

    public BigDecimal getPrecioTaller() {
        return precioTaller;
    }

    public void setPrecioTaller(BigDecimal precioTaller) {
        this.precioTaller = precioTaller;
    }

    public StCurso getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(StCurso codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public StCiclo getCodigoCiclo() {
        return codigoCiclo;
    }

    public void setCodigoCiclo(StCiclo codigoCiclo) {
        this.codigoCiclo = codigoCiclo;
    }

    @XmlTransient
    public Collection<StTalleralumno> getStTalleralumnoCollection() {
        return stTalleralumnoCollection;
    }

    public void setStTalleralumnoCollection(Collection<StTalleralumno> stTalleralumnoCollection) {
        this.stTalleralumnoCollection = stTalleralumnoCollection;
    }

    @XmlTransient
    public Collection<StTallerlaboratorio> getStTallerlaboratorioCollection() {
        return stTallerlaboratorioCollection;
    }

    public void setStTallerlaboratorioCollection(Collection<StTallerlaboratorio> stTallerlaboratorioCollection) {
        this.stTallerlaboratorioCollection = stTallerlaboratorioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTaller != null ? codigoTaller.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StTaller)) {
            return false;
        }
        StTaller other = (StTaller) object;
        if ((this.codigoTaller == null && other.codigoTaller != null) || (this.codigoTaller != null && !this.codigoTaller.equals(other.codigoTaller))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "["+codigoCiclo.getAnoCiclo()+"-"+codigoCiclo.getNumeroCiclo()+"] "+ codigoCurso.getNombreCurso() +" ("+precioTaller.toString()+")" ;
    }
    
}
