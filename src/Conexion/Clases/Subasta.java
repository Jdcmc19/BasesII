package Conexion.Clases;

import java.math.BigDecimal;
import java.sql.Date;

public class Subasta {
    private BigDecimal precioInicial;
    private Date fechaFinal;
    private String descripcionEntrega;
    private String aliasVendedor;
    private String nombreItem;
    private String descItem;
    private String primCat;
    private String segCat;
    private int id;

    public Subasta(BigDecimal precioInicial, Date fechaFinal, String descripcionEntrega, String aliasVendedor, String nombreItem, String descItem, String primCat, String segCat) {
        this.precioInicial = precioInicial;
        this.fechaFinal = fechaFinal;
        this.descripcionEntrega = descripcionEntrega;
        this.aliasVendedor = aliasVendedor;
        this.nombreItem = nombreItem;
        this.descItem = descItem;
        this.primCat = primCat;
        this.segCat = segCat;
    }

    public Subasta(BigDecimal precioInicial, Date fechaFinal, String descripcionEntrega, String aliasVendedor, String nombreItem, String descItem, String primCat, String segCat, int id) {
        this.precioInicial = precioInicial;
        this.fechaFinal = fechaFinal;
        this.descripcionEntrega = descripcionEntrega;
        this.aliasVendedor = aliasVendedor;
        this.nombreItem = nombreItem;
        this.descItem = descItem;
        this.primCat = primCat;
        this.segCat = segCat;
        this.id = id;
    }

    public BigDecimal getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(BigDecimal precioInicial) {
        this.precioInicial = precioInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDescripcionEntrega() {
        return descripcionEntrega;
    }

    public void setDescripcionEntrega(String descripcionEntrega) {
        this.descripcionEntrega = descripcionEntrega;
    }

    public String getAliasVendedor() {
        return aliasVendedor;
    }

    public void setAliasVendedor(String aliasVendedor) {
        this.aliasVendedor = aliasVendedor;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    public String getPrimCat() {
        return primCat;
    }

    public void setPrimCat(String primCat) {
        this.primCat = primCat;
    }

    public String getSegCat() {
        return segCat;
    }

    public void setSegCat(String segCat) {
        this.segCat = segCat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
