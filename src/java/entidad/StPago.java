/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "st_pago", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StPago.findAll", query = "SELECT s FROM StPago s"),
    @NamedQuery(name = "StPago.findByCodigoPago", query = "SELECT s FROM StPago s WHERE s.codigoPago = :codigoPago"),
    @NamedQuery(name = "StPago.findByMontoPago", query = "SELECT s FROM StPago s WHERE s.montoPago = :montoPago")})
public class StPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoPago", nullable = false)
    private Integer codigoPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MontoPago", nullable = false, precision = 9, scale = 2)
    private BigDecimal montoPago;
    @JoinColumn(name = "CodigoTallerAlumno", referencedColumnName = "CodigoTallerAlumno", nullable = false)
    @ManyToOne(optional = false)
    private StTalleralumno codigoTallerAlumno;

    public StPago() {
    }

    public StPago(Integer codigoPago) {
        this.codigoPago = codigoPago;
    }

    public StPago(Integer codigoPago, BigDecimal montoPago) {
        this.codigoPago = codigoPago;
        this.montoPago = montoPago;
    }

    public Integer getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(Integer codigoPago) {
        this.codigoPago = codigoPago;
    }

    public BigDecimal getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(BigDecimal montoPago) {
        this.montoPago = montoPago;
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
        hash += (codigoPago != null ? codigoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StPago)) {
            return false;
        }
        StPago other = (StPago) object;
        if ((this.codigoPago == null && other.codigoPago != null) || (this.codigoPago != null && !this.codigoPago.equals(other.codigoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.StPago[ codigoPago=" + codigoPago + " ]";
    }
    
}
