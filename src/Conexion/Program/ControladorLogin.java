package Conexion.Program;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorLogin implements Initializable {
    @FXML
    Button login_bto_forgotPassword,sign_in;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    public void initialize(URL fxmlLocations, ResourceBundle resources){
        login_bto_forgotPassword.setOnAction(event -> {
            System.out.println("asdasda");
        });
        sign_in.setOnAction(event -> {
            System.out.println("adadaaaa");
            try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("_Administrador.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("prueba");
            stage.setScene(new Scene(root));
            stage.show();
            }catch (IOException e){
                e.printStackTrace();
            }

        });
    }
}
