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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "st_formapago", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StFormapago.findAll", query = "SELECT s FROM StFormapago s"),
    @NamedQuery(name = "StFormapago.findByCodigoFormaPago", query = "SELECT s FROM StFormapago s WHERE s.codigoFormaPago = :codigoFormaPago"),
    @NamedQuery(name = "StFormapago.findByDescripcionFormaPago", query = "SELECT s FROM StFormapago s WHERE s.descripcionFormaPago = :descripcionFormaPago"),
    @NamedQuery(name = "StFormapago.findByInteresFormaPago", query = "SELECT s FROM StFormapago s WHERE s.interesFormaPago = :interesFormaPago")})
public class StFormapago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoFormaPago", nullable = false)
    private Integer codigoFormaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DescripcionFormaPago", nullable = false, length = 50)
    private String descripcionFormaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "InteresFormaPago", nullable = false, precision = 9, scale = 2)
    private BigDecimal interesFormaPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoFormaPago")
    private Collection<StTalleralumno> stTalleralumnoCollection;

    public StFormapago() {
    }

    public StFormapago(Integer codigoFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
    }

    public StFormapago(Integer codigoFormaPago, String descripcionFormaPago, BigDecimal interesFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
        this.descripcionFormaPago = descripcionFormaPago;
        this.interesFormaPago = interesFormaPago;
    }

    public Integer getCodigoFormaPago() {
        return codigoFormaPago;
    }

    public void setCodigoFormaPago(Integer codigoFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
    }

    public String getDescripcionFormaPago() {
        return descripcionFormaPago;
    }

    public void setDescripcionFormaPago(String descripcionFormaPago) {
        this.descripcionFormaPago = descripcionFormaPago;
    }

    public BigDecimal getInteresFormaPago() {
        return interesFormaPago;
    }

    public void setInteresFormaPago(BigDecimal interesFormaPago) {
        this.interesFormaPago = interesFormaPago;
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
        hash += (codigoFormaPago != null ? codigoFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StFormapago)) {
            return false;
        }
        StFormapago other = (StFormapago) object;
        if ((this.codigoFormaPago == null && other.codigoFormaPago != null) || (this.codigoFormaPago != null && !this.codigoFormaPago.equals(other.codigoFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcionFormaPago;
    }
    
}
