package Conexion.Program;

import Conexion.Clases.Comentario;
import Conexion.Clases.Puja;
import Conexion.Clases.Subasta;
import Conexion.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class ControladorConsulta implements Initializable {
    Connect con;

    @FXML
    Label lblAlias;
    @FXML
    ImageView imagen_item;
    @FXML
    TableView<Subasta> subastas_consulta;
    @FXML
    TableView<Puja> ofertas_consulta;
    @FXML
    TableView<Comentario> comentario_consulta;
    @FXML
    TableColumn id_subasta,value_subasta,until_subasta,delivery_subasta,nick_subasta,name_subasta;
    @FXML
    TableColumn id_oferta,date_oferta,value_oferta,itemname_oferta,nick_oferta;
    @FXML
    TableColumn itemname_comentario,inicial_comentario,final_comentario,comment_comentario;
    @FXML
    Button search_subasta,myAuction_subasta,bidsAuction_oferta,myBid_oferta;
    @FXML
    ComboBox primary_subasta,secondary_subasta,idsubasta_oferta;
    public void initialize(URL fxmlLocations, ResourceBundle resources){

        primary_subasta.setOnAction(event -> {
            rellenarComboboxSegundario(primary_subasta.getValue().toString());
        });

        id_subasta.setCellValueFactory(new PropertyValueFactory<Subasta,Integer>("id"));
        value_subasta.setCellValueFactory(new PropertyValueFactory<Subasta,BigDecimal>("precioInicial"));
        until_subasta.setCellValueFactory(new PropertyValueFactory<Subasta,Timestamp>("fechaFinal"));
        delivery_subasta.setCellValueFactory(new PropertyValueFactory<Subasta,String>("descripcionEntrega"));
        nick_subasta.setCellValueFactory(new PropertyValueFactory<Subasta,String>("aliasVendedor"));
        name_subasta.setCellValueFactory(new PropertyValueFactory<Subasta,String>("nombreItem"));

        id_oferta.setCellValueFactory(new PropertyValueFactory<Puja,Integer>("id"));
        date_oferta.setCellValueFactory(new PropertyValueFactory<Puja,Timestamp>("fecha"));
        value_oferta.setCellValueFactory(new PropertyValueFactory<Puja,BigDecimal>("valorOferta"));
        itemname_oferta.setCellValueFactory(new PropertyValueFactory<Puja,String>("itemName"));
        nick_oferta.setCellValueFactory(new PropertyValueFactory<Puja,String>("alias"));

        itemname_comentario.setCellValueFactory(new PropertyValueFactory<Comentario,String>("nombreItem"));
        inicial_comentario.setCellValueFactory(new PropertyValueFactory<Comentario,BigDecimal>("precioBase"));
        final_comentario.setCellValueFactory(new PropertyValueFactory<Comentario,BigDecimal>("precioFinal"));
        comment_comentario.setCellValueFactory(new PropertyValueFactory<Comentario,String>("comentario"));

        subastas_consulta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                try{
                    Subasta s = subastas_consulta.getSelectionModel().getSelectedItem();
                    String path = con.get_imagen(s.getNombreItem());
                    imagen_item.setImage(new Image("file:"+path));
                }catch(SQLException e){e.printStackTrace();}
            }
        });
        //1
        search_subasta.setOnAction(event -> {
            try {
                ObservableList<Subasta> a = FXCollections.observableArrayList(con.listar_subasta(primary_subasta.getValue().toString(),secondary_subasta.getValue().toString()));
                subastas_consulta.setItems(a);
            }catch (SQLException e){e.printStackTrace();}
        });
        //3
        myAuction_subasta.setOnAction(event -> {
            try {
                ObservableList<Comentario> a = FXCollections.observableArrayList(con.listar_subastas_usuario(con.getUsername()));
                comentario_consulta.setItems(a);
            }catch (SQLException e){e.printStackTrace();}
        });
        //2
        bidsAuction_oferta.setOnAction(event -> {
            try {
                ObservableList<Puja> a = FXCollections.observableArrayList(con.listar_pujas_subasta(Integer.parseInt(idsubasta_oferta.getValue().toString())));
                ofertas_consulta.setItems(a);
            }catch (SQLException e){e.printStackTrace();}
        });
        //3
        myBid_oferta.setOnAction(event -> {
            try {
                ObservableList<Comentario> a = FXCollections.observableArrayList(con.listar_pujas_usuario(con.getUsername()));
                comentario_consulta.setItems(a);
            }catch (SQLException e){e.printStackTrace();}
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
            primary_subasta.setItems(a);
        }catch (SQLException e){e.printStackTrace();}

    }
    public void rellenarComboboxSegundario(String primaria){
        try {
            ObservableList<String> a = FXCollections.observableArrayList(con.listar_subcategorias(primaria));
            secondary_subasta.setItems(a);
        }catch (SQLException e){e.printStackTrace();}

    }
    public void rellenarComboboxIdSubasta(){
        try {
            ObservableList<Integer> a = FXCollections.observableArrayList(con.listar_idsubastas_completas());
            idsubasta_oferta.setItems(a);
        }catch (SQLException e){e.printStackTrace();}
    }
}
