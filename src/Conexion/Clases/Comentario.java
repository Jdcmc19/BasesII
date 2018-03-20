package Conexion.Clases;

import java.math.BigDecimal;

public class Comentario {
    private String nombreItem;
    private BigDecimal precioBase;
    private BigDecimal precioFinal;
    private String comentario;

    public Comentario(String nombreItem, BigDecimal precioBase, BigDecimal precioFinal, String comentario) {
        this.nombreItem = nombreItem;
        this.precioBase = precioBase;
        this.precioFinal = precioFinal;
        this.comentario = comentario;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
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
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
