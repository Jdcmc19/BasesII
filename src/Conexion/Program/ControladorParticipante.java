package Conexion.Program;

import Conexion.Connect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;


import java.math.BigDecimal;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class ControladorParticipante implements Initializable {
    Connect con;
    @FXML
    Label lblAlias;
    @FXML
    Button insert_auction,insert_bid,insert_commentS,choose_image,go_consultas,insert_commentB;
    @FXML
    TextField price_auction,delivery_auction,name_item,description_item,comment_commentsS,auction_bid,price_bid,comment_commentsB;
    @FXML
    DatePicker until_auction;
    @FXML
    ComboBox primary_item,secondary_item,auction_commentS,calification_commentS,auction_commentB;

    public void initialize(URL fxmlLocations, ResourceBundle resources){

        insert_auction.setOnAction(event -> {
            String name = name_item.getText();
            String description = description_item.getText();
            String primary = primary_item.getValue().toString();
            String secondary = secondary_item.getValue().toString();

            BigDecimal price = new BigDecimal(price_auction.getText());
            String delivery = delivery_auction.getText();

            LocalDate localDate = until_auction.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);

        });
        choose_image.setOnAction(event -> {});
        insert_bid.setOnAction(event -> {
            BigDecimal price = new BigDecimal(price_bid.getText());
            int auction = Integer.parseInt(auction_bid.getText());
        });
        insert_commentS.setOnAction(event -> {
            int auction = Integer.parseInt(auction_commentS.getValue().toString());
            String comment = comment_commentsS.getText();
            int calificacion = Integer.parseInt(calification_commentS.getValue().toString());
        });
        insert_commentB.setOnAction(event -> {
            int auction = Integer.parseInt(auction_commentB.getValue().toString());
            String comment = comment_commentsB.getText();
        });
    }
    public void setCon(Connect con) {
        this.con = con;
    }
    public void setAlias(){
        lblAlias.setText(con.getUsername());
    }
}


