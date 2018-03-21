package Conexion.Clases;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class Subasta {
    private BigDecimal precioInicial;
    private Timestamp fechaFinal;
    private SimpleStringProperty descripcionEntrega;
    private SimpleStringProperty aliasVendedor;
    private SimpleStringProperty nombreItem;
    private SimpleStringProperty descItem;
    private SimpleStringProperty primCat;
    private SimpleStringProperty segCat;
    private SimpleIntegerProperty id;

    public Subasta(BigDecimal precioInicial, Timestamp fechaFinal, String descripcionEntrega, String aliasVendedor, String nombreItem, String descItem, String primCat, String segCat) {
        this.precioInicial = precioInicial;
        this.fechaFinal = fechaFinal;
        this.descripcionEntrega = new SimpleStringProperty(descripcionEntrega);
        this.aliasVendedor = new SimpleStringProperty(aliasVendedor);
        this.nombreItem = new SimpleStringProperty(nombreItem);
        this.descItem = new SimpleStringProperty(descItem);
        this.primCat = new SimpleStringProperty(primCat);
        this.segCat = new SimpleStringProperty(segCat);
    }

    public Subasta(BigDecimal precioInicial, Timestamp fechaFinal, String descripcionEntrega, String aliasVendedor, String nombreItem, String descItem, String primCat, String segCat, int id) {
        this.precioInicial = precioInicial;
        this.fechaFinal = fechaFinal;
        this.descripcionEntrega = new SimpleStringProperty(descripcionEntrega);
        this.aliasVendedor = new SimpleStringProperty(aliasVendedor);
        this.nombreItem = new SimpleStringProperty(nombreItem);
        this.descItem =new SimpleStringProperty( descItem);
        this.primCat = new SimpleStringProperty(primCat);
        this.segCat =new SimpleStringProperty( segCat);
        this.id = new SimpleIntegerProperty(id);
    }

    public BigDecimal getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(BigDecimal precioInicial) {
        this.precioInicial = precioInicial;
    }

    public Timestamp getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Timestamp fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDescripcionEntrega() {
        return descripcionEntrega.get();
    }

    public void setDescripcionEntrega(String descripcionEntrega) {
        this.descripcionEntrega = new SimpleStringProperty(descripcionEntrega);
    }

    public String getAliasVendedor() {
        return aliasVendedor.get();
    }

    public void setAliasVendedor(String aliasVendedor) {
        this.aliasVendedor = new SimpleStringProperty(aliasVendedor);
    }

    public String getNombreItem() {
        return nombreItem.get();
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = new SimpleStringProperty(nombreItem);
    }

    public String getDescItem() {
        return descItem.get();
    }

    public void setDescItem(String descItem) {
        this.descItem = new SimpleStringProperty(descItem);
    }

    public String getPrimCat() {
        return primCat.get();
    }

    public void setPrimCat(String primCat) {
        this.primCat = new SimpleStringProperty(primCat);
    }

    public String getSegCat() {
        return segCat.get();
    }

    public void setSegCat(String segCat) {
        this.segCat = new SimpleStringProperty(segCat);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }
}
