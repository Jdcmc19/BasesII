package Conexion.Clases;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Puja {
    private BigDecimal valorOferta;
    private SimpleStringProperty alias;
    private SimpleIntegerProperty id;
    private SimpleStringProperty itemName;
    private Timestamp fecha;

    public Puja(BigDecimal valorOferta, String alias, int id, String itemName, Timestamp fecha) {
        this.valorOferta = valorOferta;
        this.alias = new SimpleStringProperty(alias);
        this.id = new SimpleIntegerProperty(id);
        this.itemName = new SimpleStringProperty(itemName);
        this.fecha = fecha;
    }

    public Puja(BigDecimal valorOferta, String alias, int id) {
        this.valorOferta = valorOferta;
        this.alias = new SimpleStringProperty(alias);
        this.id = new SimpleIntegerProperty(id);
    }

    public BigDecimal getValorOferta() {
        return valorOferta;
    }

    public void setValorOferta(BigDecimal valorOferta) {
        this.valorOferta = valorOferta;
    }

    public String getAlias() {
        return alias.get();
    }

    public void setAlias(String alias) {
        this.alias = new SimpleStringProperty(alias);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName = new SimpleStringProperty(itemName);
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
