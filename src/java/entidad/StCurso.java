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
@Table(name = "st_curso", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StCurso.findAll", query = "SELECT s FROM StCurso s"),
    @NamedQuery(name = "StCurso.findByCodigoCurso", query = "SELECT s FROM StCurso s WHERE s.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "StCurso.findByNombreCurso", query = "SELECT s FROM StCurso s WHERE s.nombreCurso = :nombreCurso"),
    @NamedQuery(name = "StCurso.findByMaximaCantidadHorasCurso", query = "SELECT s FROM StCurso s WHERE s.maximaCantidadHorasCurso = :maximaCantidadHorasCurso")})
public class StCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoCurso", nullable = false)
    private Integer codigoCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NombreCurso", nullable = false, length = 50)
    private String nombreCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaximaCantidadHorasCurso", nullable = false)
    private int maximaCantidadHorasCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCurso")
    private Collection<StTaller> stTallerCollection;
    @JoinColumn(name = "CodigoCursoTipo", referencedColumnName = "CodigoCursoTipo")
    @ManyToOne
    private StCursotipo codigoCursoTipo;

    public StCurso() {
    }

    public StCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public StCurso(Integer codigoCurso, String nombreCurso, int maximaCantidadHorasCurso) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.maximaCantidadHorasCurso = maximaCantidadHorasCurso;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getMaximaCantidadHorasCurso() {
        return maximaCantidadHorasCurso;
    }

    public void setMaximaCantidadHorasCurso(int maximaCantidadHorasCurso) {
        this.maximaCantidadHorasCurso = maximaCantidadHorasCurso;
    }

    @XmlTransient
    public Collection<StTaller> getStTallerCollection() {
        return stTallerCollection;
    }

    public void setStTallerCollection(Collection<StTaller> stTallerCollection) {
        this.stTallerCollection = stTallerCollection;
    }

    public StCursotipo getCodigoCursoTipo() {
        return codigoCursoTipo;
    }

    public void setCodigoCursoTipo(StCursotipo codigoCursoTipo) {
        this.codigoCursoTipo = codigoCursoTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCurso != null ? codigoCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StCurso)) {
            return false;
        }
        StCurso other = (StCurso) object;
        if ((this.codigoCurso == null && other.codigoCurso != null) || (this.codigoCurso != null && !this.codigoCurso.equals(other.codigoCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCurso;
    }
    
}
