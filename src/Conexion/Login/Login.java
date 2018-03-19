package Conexion.Login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Login  implements Initializable {
    @FXML
    Button login_bto_forgotPassword;
    public void initialize(URL fxmlLocations, ResourceBundle resources){
        login_bto_forgotPassword.setOnAction(event -> {});
    }
}
