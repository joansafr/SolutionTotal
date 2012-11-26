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
@Table(name = "st_cursotipo", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StCursotipo.findAll", query = "SELECT s FROM StCursotipo s"),
    @NamedQuery(name = "StCursotipo.findByCodigoCursoTipo", query = "SELECT s FROM StCursotipo s WHERE s.codigoCursoTipo = :codigoCursoTipo"),
    @NamedQuery(name = "StCursotipo.findByNombreCursoTipo", query = "SELECT s FROM StCursotipo s WHERE s.nombreCursoTipo = :nombreCursoTipo")})
public class StCursotipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoCursoTipo", nullable = false)
    private Integer codigoCursoTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NombreCursoTipo", nullable = false, length = 50)
    private String nombreCursoTipo;
    @OneToMany(mappedBy = "codigoCursoTipo")
    private Collection<StCurso> stCursoCollection;

    public StCursotipo() {
    }

    public StCursotipo(Integer codigoCursoTipo) {
        this.codigoCursoTipo = codigoCursoTipo;
    }

    public StCursotipo(Integer codigoCursoTipo, String nombreCursoTipo) {
        this.codigoCursoTipo = codigoCursoTipo;
        this.nombreCursoTipo = nombreCursoTipo;
    }

    public Integer getCodigoCursoTipo() {
        return codigoCursoTipo;
    }

    public void setCodigoCursoTipo(Integer codigoCursoTipo) {
        this.codigoCursoTipo = codigoCursoTipo;
    }

    public String getNombreCursoTipo() {
        return nombreCursoTipo;
    }

    public void setNombreCursoTipo(String nombreCursoTipo) {
        this.nombreCursoTipo = nombreCursoTipo;
    }

    @XmlTransient
    public Collection<StCurso> getStCursoCollection() {
        return stCursoCollection;
    }

    public void setStCursoCollection(Collection<StCurso> stCursoCollection) {
        this.stCursoCollection = stCursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCursoTipo != null ? codigoCursoTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StCursotipo)) {
            return false;
        }
        StCursotipo other = (StCursotipo) object;
        if ((this.codigoCursoTipo == null && other.codigoCursoTipo != null) || (this.codigoCursoTipo != null && !this.codigoCursoTipo.equals(other.codigoCursoTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCursoTipo;
    }
    
}
