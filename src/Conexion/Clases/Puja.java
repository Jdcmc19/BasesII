package Conexion.Clases;

import java.math.BigDecimal;
import java.sql.Date;

public class Puja {
    private BigDecimal valorOferta;
    private String alias;
    private int id;
    private String itemName;
    private Date fecha;

    public Puja(BigDecimal valorOferta, String alias, int id, String itemName, Date fecha) {
        this.valorOferta = valorOferta;
        this.alias = alias;
        this.id = id;
        this.itemName = itemName;
        this.fecha = fecha;
    }

    public Puja(BigDecimal valorOferta, String alias, int id) {
        this.valorOferta = valorOferta;
        this.alias = alias;
        this.id = id;
    }

    public BigDecimal getValorOferta() {
        return valorOferta;
    }

    public void setValorOferta(BigDecimal valorOferta) {
        this.valorOferta = valorOferta;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
