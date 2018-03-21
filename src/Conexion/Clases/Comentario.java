package Conexion.Clases;

import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;

public class Comentario {
    private SimpleStringProperty nombreItem;
    private BigDecimal precioBase;
    private BigDecimal precioFinal;
    private SimpleStringProperty comentario;

    public Comentario(String nombreItem, BigDecimal precioBase, BigDecimal precioFinal, String comentario) {
        this.nombreItem = new SimpleStringProperty(nombreItem);
        this.precioBase = precioBase;
        this.precioFinal = precioFinal;
        this.comentario = new SimpleStringProperty(comentario);
    }

    public String getNombreItem() {
        return nombreItem.get();
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = new SimpleStringProperty(nombreItem);
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public BigDecimal getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(BigDecimal precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getComentario() {
        return comentario.get();
    }

    public void setComentario(String comentario) {
        this.comentario = new SimpleStringProperty(comentario);
    }
}
