/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "st_usuario", catalog = "st", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"IdentificadorUsuario"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StUsuario.findAll", query = "SELECT s FROM StUsuario s"),
    @NamedQuery(name = "StUsuario.findByNombreUsuario", query = "SELECT s FROM StUsuario s WHERE s.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "StUsuario.findByApellidoPaternoUsuario", query = "SELECT s FROM StUsuario s WHERE s.apellidoPaternoUsuario = :apellidoPaternoUsuario"),
    @NamedQuery(name = "StUsuario.findByApellidoMaternoUsuario", query = "SELECT s FROM StUsuario s WHERE s.apellidoMaternoUsuario = :apellidoMaternoUsuario"),
    @NamedQuery(name = "StUsuario.findByCorreoElectronicoUsuario", query = "SELECT s FROM StUsuario s WHERE s.correoElectronicoUsuario = :correoElectronicoUsuario"),
    @NamedQuery(name = "StUsuario.findByTelefonoFijoUsuario", query = "SELECT s FROM StUsuario s WHERE s.telefonoFijoUsuario = :telefonoFijoUsuario"),
    @NamedQuery(name = "StUsuario.findByTelefonoMovilUsuario", query = "SELECT s FROM StUsuario s WHERE s.telefonoMovilUsuario = :telefonoMovilUsuario"),
    @NamedQuery(name = "StUsuario.findByIdentificadorUsuario", query = "SELECT s FROM StUsuario s WHERE s.identificadorUsuario = :identificadorUsuario"),
    @NamedQuery(name = "StUsuario.findByContrasenaUsuario", query = "SELECT s FROM StUsuario s WHERE s.contrasenaUsuario = :contrasenaUsuario"),
    @NamedQuery(name = "StUsuario.findByCodigoUsuario", query = "SELECT s FROM StUsuario s WHERE s.codigoUsuario = :codigoUsuario")})
public class StUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NombreUsuario", nullable = false, length = 50)
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ApellidoPaternoUsuario", nullable = false, length = 50)
    private String apellidoPaternoUsuario;
    @Size(max = 50)
    @Column(name = "ApellidoMaternoUsuario", length = 50)
    private String apellidoMaternoUsuario;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "CorreoElectronicoUsuario", nullable = false, length = 50)
    private String correoElectronicoUsuario;
    @Basic(optional = false)
    @Size(min = 1, max = 15)
    @Column(name = "TelefonoFijoUsuario", nullable = false, length = 15)
    private String telefonoFijoUsuario;
    @Size(max = 15)
    @Column(name = "TelefonoMovilUsuario", length = 15)
    private String telefonoMovilUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IdentificadorUsuario", nullable = false, length = 20)
    private String identificadorUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "ContrasenaUsuario", nullable = false, length = 64)
    private String contrasenaUsuario;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoUsuario", nullable = false)
    private Integer codigoUsuario;
    @JoinColumn(name = "CodigoUsuarioTipo", referencedColumnName = "CodigoUsuarioTipo")
    @ManyToOne
    private StUsuariotipo codigoUsuarioTipo;

    public StUsuario() {
    }

    public StUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public StUsuario(Integer codigoUsuario, String nombreUsuario, String apellidoPaternoUsuario, String correoElectronicoUsuario, String telefonoFijoUsuario, String identificadorUsuario, String contrasenaUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
        this.correoElectronicoUsuario = correoElectronicoUsuario;
        this.telefonoFijoUsuario = telefonoFijoUsuario;
        this.identificadorUsuario = identificadorUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPaternoUsuario() {
        return apellidoPaternoUsuario;
    }

    public void setApellidoPaternoUsuario(String apellidoPaternoUsuario) {
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
    }

    public String getApellidoMaternoUsuario() {
        return apellidoMaternoUsuario;
    }

    public void setApellidoMaternoUsuario(String apellidoMaternoUsuario) {
        this.apellidoMaternoUsuario = apellidoMaternoUsuario;
    }

    public String getCorreoElectronicoUsuario() {
        return correoElectronicoUsuario;
    }

    public void setCorreoElectronicoUsuario(String correoElectronicoUsuario) {
        this.correoElectronicoUsuario = correoElectronicoUsuario;
    }

    public String getTelefonoFijoUsuario() {
        return telefonoFijoUsuario;
    }

    public void setTelefonoFijoUsuario(String telefonoFijoUsuario) {
        this.telefonoFijoUsuario = telefonoFijoUsuario;
    }

    public String getTelefonoMovilUsuario() {
        return telefonoMovilUsuario;
    }

    public void setTelefonoMovilUsuario(String telefonoMovilUsuario) {
        this.telefonoMovilUsuario = telefonoMovilUsuario;
    }

    public String getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    public void setIdentificadorUsuario(String identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public StUsuariotipo getCodigoUsuarioTipo() {
        return codigoUsuarioTipo;
    }

    public void setCodigoUsuarioTipo(StUsuariotipo codigoUsuarioTipo) {
        this.codigoUsuarioTipo = codigoUsuarioTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StUsuario)) {
            return false;
        }
        StUsuario other = (StUsuario) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.StUsuario[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
