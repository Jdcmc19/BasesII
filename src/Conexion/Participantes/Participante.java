package Conexion.Participantes;

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

public class Participante implements Initializable {
    @FXML
    Button insert_auction,insert_bid,insert_comment,choose_image,go_consultas;
    @FXML
    TextField price_auction,delivery_auction,name_item,description_item,comment_comments,auction_bid,price_bid;
    @FXML
    DatePicker until_auction;
    @FXML
    ComboBox primary_item,secondary_item,auction_comment,calification_comment;

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
        insert_comment.setOnAction(event -> {
            int auction = Integer.parseInt(auction_comment.getValue().toString());
            String comment = comment_comments.getText();
            int calificacion = Integer.parseInt(calification_comment.getValue().toString());
        });
    }
}


