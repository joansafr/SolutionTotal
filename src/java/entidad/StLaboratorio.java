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
@Table(name = "st_laboratorio", catalog = "st", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StLaboratorio.findAll", query = "SELECT s FROM StLaboratorio s"),
    @NamedQuery(name = "StLaboratorio.findByCodigoLaboratorio", query = "SELECT s FROM StLaboratorio s WHERE s.codigoLaboratorio = :codigoLaboratorio"),
    @NamedQuery(name = "StLaboratorio.findByPabellonLaboratorio", query = "SELECT s FROM StLaboratorio s WHERE s.pabellonLaboratorio = :pabellonLaboratorio"),
    @NamedQuery(name = "StLaboratorio.findByPisoLaboratorio", query = "SELECT s FROM StLaboratorio s WHERE s.pisoLaboratorio = :pisoLaboratorio"),
    @NamedQuery(name = "StLaboratorio.findByNumeroLaboratorio", query = "SELECT s FROM StLaboratorio s WHERE s.numeroLaboratorio = :numeroLaboratorio"),
    @NamedQuery(name = "StLaboratorio.findByMaximaCapacidadLaboratorio", query = "SELECT s FROM StLaboratorio s WHERE s.maximaCapacidadLaboratorio = :maximaCapacidadLaboratorio")})
public class StLaboratorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoLaboratorio", nullable = false)
    private Integer codigoLaboratorio;
    @Size(max = 2)
    @Column(name = "PabellonLaboratorio", length = 2)
    private String pabellonLaboratorio;
    @Column(name = "PisoLaboratorio")
    private Integer pisoLaboratorio;
    @Column(name = "NumeroLaboratorio")
    private Integer numeroLaboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaximaCapacidadLaboratorio", nullable = false)
    private int maximaCapacidadLaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoLaboratorio")
    private Collection<StTallerlaboratorio> stTallerlaboratorioCollection;

    public StLaboratorio() {
    }

    public StLaboratorio(Integer codigoLaboratorio) {
        this.codigoLaboratorio = codigoLaboratorio;
    }

    public StLaboratorio(Integer codigoLaboratorio, int maximaCapacidadLaboratorio) {
        this.codigoLaboratorio = codigoLaboratorio;
        this.maximaCapacidadLaboratorio = maximaCapacidadLaboratorio;
    }

    public Integer getCodigoLaboratorio() {
        return codigoLaboratorio;
    }

    public void setCodigoLaboratorio(Integer codigoLaboratorio) {
        this.codigoLaboratorio = codigoLaboratorio;
    }

    public String getPabellonLaboratorio() {
        return pabellonLaboratorio;
    }

    public void setPabellonLaboratorio(String pabellonLaboratorio) {
        this.pabellonLaboratorio = pabellonLaboratorio;
    }

    public Integer getPisoLaboratorio() {
        return pisoLaboratorio;
    }

    public void setPisoLaboratorio(Integer pisoLaboratorio) {
        this.pisoLaboratorio = pisoLaboratorio;
    }

    public Integer getNumeroLaboratorio() {
        return numeroLaboratorio;
    }

    public void setNumeroLaboratorio(Integer numeroLaboratorio) {
        this.numeroLaboratorio = numeroLaboratorio;
    }

    public int getMaximaCapacidadLaboratorio() {
        return maximaCapacidadLaboratorio;
    }

    public void setMaximaCapacidadLaboratorio(int maximaCapacidadLaboratorio) {
        this.maximaCapacidadLaboratorio = maximaCapacidadLaboratorio;
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
        hash += (codigoLaboratorio != null ? codigoLaboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StLaboratorio)) {
            return false;
        }
        StLaboratorio other = (StLaboratorio) object;
        if ((this.codigoLaboratorio == null && other.codigoLaboratorio != null) || (this.codigoLaboratorio != null && !this.codigoLaboratorio.equals(other.codigoLaboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pabellonLaboratorio + "-" +pisoLaboratorio.toString() + "-" + numeroLaboratorio.toString();
    }
    
}
