package Conexion.Program;

import Conexion.Clases.Puja;
import Conexion.Clases.Subasta;
import Conexion.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladorParticipante implements Initializable {
    Connect con;
    String path;
    @FXML
    Label lblAlias;
    @FXML
    Button insert_auction,insert_bid,insert_commentS,choose_image,go_consultas,insert_commentB;
    @FXML
    TextField price_auction,delivery_auction,name_item,description_item,comment_commentsS,price_bid,comment_commentsB;
    @FXML
    DatePicker until_auction;
    @FXML
    ComboBox primary_item,secondary_item,auction_commentS,calification_commentS,auction_commentB,auction_bid,comboHora,comboMin,comboSeg;

    public void initialize(URL fxmlLocations, ResourceBundle resources){

        calification_commentS.getItems().addAll(1,2,3,4,5);
        comboHora.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i=0;i<60;i++){
            tmp.add(i);
        }
        comboMin.getItems().addAll();
        primary_item.setOnAction(event -> {
            rellenarComboboxSegundario(primary_item.getValue().toString());
        });

        ObservableList<Integer> tmp2 = FXCollections.observableArrayList(tmp);
        comboMin.getItems().addAll(tmp2);
        comboSeg.getItems().addAll(tmp2);

        insert_auction.setOnAction(event -> {
            String name = name_item.getText();
            String description = description_item.getText();
            String primary = primary_item.getValue().toString();
            String secondary = secondary_item.getValue().toString();

            BigDecimal price = new BigDecimal(price_auction.getText());
            String delivery = delivery_auction.getText();

            System.out.println(until_auction.getValue());
            String fechaHora = until_auction.getValue() + " " + comboHora.getValue().toString()+ ":" +comboMin.getValue().toString() + ":" + comboSeg.getValue().toString();

            Timestamp date = Timestamp.valueOf(fechaHora);

            Subasta subasta = new Subasta(price,date,delivery,con.getUsername(),name,description,primary,secondary);
            try{
                con.add_subasta(subasta);
                con.add_imagen(name,path);
                path="";
            }catch (SQLException e){e.printStackTrace();}
            rellenarComboboxIdSubastaVendedor();
            rellenarComboboxIdSubasta();
            rellenarComboboxIdSubastaComprador();
            limpiarSubasta();

        });
        choose_image.setOnAction(event -> {
            choose_image.setDisable(true);
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(null);
            if (file != null) {
                path = file.toString();

            }
            choose_image.setDisable(false);
        });
        insert_bid.setOnAction(event -> {
            BigDecimal price = new BigDecimal(price_bid.getText());
            int auction = Integer.parseInt(auction_bid.getValue().toString());

            Puja puja = new Puja(price,con.getUsername(),auction);

            try{
                if(!con.add_oferta(puja)){
                    new Alert(Alert.AlertType.ERROR, "No se insertó la puja, verifique datos.").showAndWait();
                }else{
                    price_bid.setText("");
                }
            }catch (SQLException e){e.printStackTrace();}

            rellenarComboboxIdSubastaComprador();

        });
        insert_commentS.setOnAction(event -> {
            int auction = Integer.parseInt(auction_commentS.getValue().toString());
            String comment = comment_commentsS.getText();
            int calificacion = Integer.parseInt(calification_commentS.getValue().toString());

            try{
                con.add_comentario_vendedor(calificacion,comment,auction);
            }catch (SQLException e){e.printStackTrace();}
            comment_commentsS.setText("");
        });
        insert_commentB.setOnAction(event -> {
            int auction = Integer.parseInt(auction_commentB.getValue().toString());
            String comment = comment_commentsB.getText();
            try{
                con.add_comentario_comprador(comment,auction);
            }catch (SQLException e){e.printStackTrace();}
            comment_commentsB.setText("");
        });
        go_consultas.setOnAction(event -> {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UIConsulta.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Consulta");
                stage.setScene(new Scene(root, 914, 648));
                stage.show();

                ControladorConsulta a = fxmlLoader.getController();
                a.setCon(con);
                a.setAlias();
                a.rellenarComboboxPrimario();
                a.rellenarComboboxIdSubasta();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }
    public void setCon(Connect con) {
        this.con = con;
    }
    public void setAlias(){
        lblAlias.setText(con.getUsername());
    }
    public void rellenarComboboxPrimario(){
        try {
            ObservableList<String> a = FXCollections.observableArrayList(con.listar_categorias());
            primary_item.setItems(a);
        }catch (SQLException e){e.printStackTrace();}

    }
    public void rellenarComboboxSegundario(String primaria){
        try {
            ObservableList<String> a = FXCollections.observableArrayList(con.listar_subcategorias(primaria));
            secondary_item.setItems(a);
        }catch (SQLException e){e.printStackTrace();}

    }
    public void rellenarComboboxIdSubastaVendedor(){
        try {
            ObservableList<Integer> a = FXCollections.observableArrayList(con.listar_idsubastas_vendedor(con.getUsername()));
            auction_commentS.setItems(a);
        }catch (SQLException e){e.printStackTrace();}
    }
    public void rellenarComboboxIdSubastaComprador(){
        try {
            ObservableList<Integer> a = FXCollections.observableArrayList(con.listar_idsubastas_comprador(con.getUsername()));
            auction_commentB.setItems(a);
        }catch (SQLException e){e.printStackTrace();}
    }
    public void rellenarComboboxIdSubasta(){
        try {
            ObservableList<Integer> a = FXCollections.observableArrayList(con.listar_idsubastas_completas());
            auction_bid.setItems(a);
        }catch (SQLException e){e.printStackTrace();}
    }
    public void limpiarSubasta(){
        price_auction.setText("");
        delivery_auction.setText("");
        name_item.setText("");
        description_item.setText("");
    }
}


