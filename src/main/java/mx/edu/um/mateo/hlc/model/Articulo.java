/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.um.mateo.hlc.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import mx.edu.um.mateo.general.model.Empresa;
import mx.edu.um.mateo.general.model.Usuario;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author osoto
 */
@Entity
@Table(name = "articulos")
public class Articulo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;
    @Column(nullable = false, unique = true)
    private BigInteger codigo;
    @NotBlank
    @Column(nullable = false)
    private String descripcion;
    @Column(name = "descripcion_1")
    private String descripcion1;
    @Column
    private String sustancia;
    @Column
    private String um;
    @Column
    private String gpoProducto;
    @Column
    private BigInteger cBarra;
    @ManyToOne
    private Usuario usuario;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column    
    private Date fecha;
    @ManyToOne
    private Empresa empresa;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return the codigo
     */
    public BigInteger getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the descripcion1
     */
    public String getDescripcion1() {
        return descripcion1;
    }

    /**
     * @param descripcion1 the descripcion1 to set
     */
    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    /**
     * @return the sustancia
     */
    public String getSustancia() {
        return sustancia;
    }

    /**
     * @param sustancia the sustancia to set
     */
    public void setSustancia(String sustancia) {
        this.sustancia = sustancia;
    }

    /**
     * @return the um
     */
    public String getUm() {
        return um;
    }

    /**
     * @param um the um to set
     */
    public void setUm(String um) {
        this.um = um;
    }

    /**
     * @return the gpoProducto
     */
    public String getGpoProducto() {
        return gpoProducto;
    }

    /**
     * @param gpoProducto the gpoProducto to set
     */
    public void setGpoProducto(String gpoProducto) {
        this.gpoProducto = gpoProducto;
    }

    /**
     * @return the cBarra
     */
    public BigInteger getcBarra() {
        return cBarra;
    }

    /**
     * @param cBarra the cBarra to set
     */
    public void setcBarra(BigInteger cBarra) {
        this.cBarra = cBarra;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.version);
        hash = 59 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Articulo other = (Articulo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", version=" + version + ", codigo=" + codigo + ", descripcion=" + descripcion + ", descripcion1=" + descripcion1 + ", sustancia=" + sustancia + ", um=" + um + ", gpoProducto=" + gpoProducto + ", cBarra=" + cBarra + ", usuario=" + usuario.getId() + ", fecha=" + fecha + ", empresa=" + empresa.getId() + '}';
    }
    
    
    
}
