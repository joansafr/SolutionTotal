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
@Table(name = "st_usuariotipo", catalog = "st", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NombreUsuarioTipo"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StUsuariotipo.findAll", query = "SELECT s FROM StUsuariotipo s"),
    @NamedQuery(name = "StUsuariotipo.findByNombreUsuarioTipo", query = "SELECT s FROM StUsuariotipo s WHERE s.nombreUsuarioTipo = :nombreUsuarioTipo"),
    @NamedQuery(name = "StUsuariotipo.findByCodigoUsuarioTipo", query = "SELECT s FROM StUsuariotipo s WHERE s.codigoUsuarioTipo = :codigoUsuarioTipo")})
public class StUsuariotipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NombreUsuarioTipo", nullable = false, length = 20)
    private String nombreUsuarioTipo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoUsuarioTipo", nullable = false)
    private Integer codigoUsuarioTipo;
    @OneToMany(mappedBy = "codigoUsuarioTipo")
    private Collection<StUsuario> stUsuarioCollection;

    public StUsuariotipo() {
    }

    public StUsuariotipo(Integer codigoUsuarioTipo) {
        this.codigoUsuarioTipo = codigoUsuarioTipo;
    }

    public StUsuariotipo(Integer codigoUsuarioTipo, String nombreUsuarioTipo) {
        this.codigoUsuarioTipo = codigoUsuarioTipo;
        this.nombreUsuarioTipo = nombreUsuarioTipo;
    }

    public String getNombreUsuarioTipo() {
        return nombreUsuarioTipo;
    }

    public void setNombreUsuarioTipo(String nombreUsuarioTipo) {
        this.nombreUsuarioTipo = nombreUsuarioTipo;
    }

    public Integer getCodigoUsuarioTipo() {
        return codigoUsuarioTipo;
    }

    public void setCodigoUsuarioTipo(Integer codigoUsuarioTipo) {
        this.codigoUsuarioTipo = codigoUsuarioTipo;
    }

    @XmlTransient
    public Collection<StUsuario> getStUsuarioCollection() {
        return stUsuarioCollection;
    }

    public void setStUsuarioCollection(Collection<StUsuario> stUsuarioCollection) {
        this.stUsuarioCollection = stUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuarioTipo != null ? codigoUsuarioTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StUsuariotipo)) {
            return false;
        }
        StUsuariotipo other = (StUsuariotipo) object;
        if ((this.codigoUsuarioTipo == null && other.codigoUsuarioTipo != null) || (this.codigoUsuarioTipo != null && !this.codigoUsuarioTipo.equals(other.codigoUsuarioTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreUsuarioTipo;
    }
    
}
