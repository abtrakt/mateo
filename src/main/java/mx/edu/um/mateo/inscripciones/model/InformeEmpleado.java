/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.um.mateo.inscripciones.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import mx.edu.um.mateo.general.model.Empresa;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author develop
 */
@Entity
@Table(name = "informeEmpleado")
public class InformeEmpleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;
    private String numNomina;
    private String nombreEmpleado;
    private String RFCProveedor;
    private String folioFactura;
    private String nombreProveedor;
    private BigDecimal subtotal;
    private BigDecimal IVA;
    private BigDecimal total;
    private String status;
    private Boolean informe;
    private Boolean pesos;
    private Boolean dolares;
    private Boolean reembolso;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date fechaInforme;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @ManyToOne(optional = false)
    private Empresa empresa;
    private String pathPDF;
    private String pathXMl;

    public InformeEmpleado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getNumNomina() {
        return numNomina;
    }

    public void setNumNomina(String NumNomina) {
        this.numNomina = NumNomina;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.nombreEmpleado = NombreEmpleado;
    }

    public String getRFCProveedor() {
        return RFCProveedor;
    }

    public void setRFCProveedor(String RFCProveedor) {
        this.RFCProveedor = RFCProveedor;
    }

    public String getFolioFactura() {
        return folioFactura;
    }

    public void setFolioFactura(String FolioFactura) {
        this.folioFactura = FolioFactura;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String NombreProveedor) {
        this.nombreProveedor = NombreProveedor;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIVA() {
        return IVA;
    }

    public void setIVA(BigDecimal IVA) {
        this.IVA = IVA;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal Total) {
        this.total = Total;
    }

    public Date getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(Date fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getPathPDF() {
        return pathPDF;
    }

    public void setPathPDF(String pathPDF) {
        this.pathPDF = pathPDF;
    }

    public String getPathXMl() {
        return pathXMl;
    }

    public void setPathXMl(String pathXMl) {
        this.pathXMl = pathXMl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getInforme() {
        return informe;
    }

    public void setInforme(Boolean informe) {
        this.informe = informe;
    }

    public Boolean getPesos() {
        return pesos;
    }

    public void setPesos(Boolean pesos) {
        this.pesos = pesos;
    }

    public Boolean getDolares() {
        return dolares;
    }

    public void setDolares(Boolean dolares) {
        this.dolares = dolares;
    }

    public Boolean getReembolso() {
        return reembolso;
    }

    public void setReembolso(Boolean reembolso) {
        this.reembolso = reembolso;
    }

    @Override
    public String toString() {
        return "InformeEmpleado{" + "id=" + id + ", version=" + version + ", NumNomina=" + numNomina
                + ", NombreEmpleado=" + nombreEmpleado + ", RFCProveedor=" + RFCProveedor
                + ", FolioFactura=" + folioFactura + ", NombreProveedor=" + nombreProveedor
                + ", subtotal=" + subtotal + ", IVA=" + IVA + ", Total=" + total
                + ", status=" + status + ", informe=" + informe + ", pesos=" + pesos
                + ", dolares=" + dolares + ", reembolso=" + reembolso + ", fechaInforme=" + fechaInforme
                + ", fechaFactura=" + fechaFactura + ", empresa=" + empresa + ", pathPDF=" + pathPDF + ", pathXMl=" + pathXMl + '}';
    }
}
