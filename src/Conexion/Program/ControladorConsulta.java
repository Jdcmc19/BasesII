package Conexion.Program;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorConsulta implements Initializable {
    @FXML
    TableView subastas_consulta,ofertas_consulta;
    @FXML
    TableColumn id_subasta,value_subasta,until_subasta,delivery_subasta,nick_subasta,name_subasta,bidId_subasta;
    @FXML
    TableColumn id_oferta,date_oferta,value_oferta,auctionId_oferta,nick_oferta;
    @FXML
    Button search_subasta,myAuction_subasta,bidsAuction_oferta,myBid_oferta;
    @FXML
    ComboBox primary_subasta,secondary_subasta,idsubasta_oferta;
    public void initialize(URL fxmlLocations, ResourceBundle resources){
        search_subasta.setOnAction(event -> {});
        myAuction_subasta.setOnAction(event -> {});
        bidsAuction_oferta.setOnAction(event -> {});
        myBid_oferta.setOnAction(event -> {});
    }
}
