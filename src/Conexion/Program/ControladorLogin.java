package Conexion.Program;

import Conexion.Clases.Usuario;
import Conexion.Connect;
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
    Connect con;
    @FXML
    Button login_bto_forgotPassword,sign_in;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    public void initialize(URL fxmlLocations, ResourceBundle resources){
        login_bto_forgotPassword.setOnAction(event -> {

        });
        sign_in.setOnAction(event -> {
            System.out.println("aaaaaaaaaa");
            String user = username.getText();
            String pass = password.getText();
            String pss = Usuario.encripta(pass);
            con = new Connect(user,pss);

            if(con.isConnected()){
                System.out.println("bbbbbbbb");
                if(con.isAdministrador()){
                    System.out.println("ccccccc");
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UIAdministrador.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Administrador");
                        stage.setScene(new Scene(root, 672, 655));
                        stage.show();

                        ControladorAdministrador a = fxmlLoader.getController();
                        a.setCon(con);
                        a.setAlias();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                else if(con.isParticipante()){
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UIParticipante.fxml"));
                        Parent root = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Participante");
                        stage.setScene(new Scene(root, 676, 693));
                        stage.show();

                        ControladorParticipante a = fxmlLoader.getController();
                        a.setCon(con);
                        a.setAlias();
                        a.rellenarComboboxPrimario();
                        a.rellenarComboboxIdSubastaComprador();
                        a.rellenarComboboxIdSubastaVendedor();
                        a.rellenarComboboxIdSubasta();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                username.setText("");
                password.setText("");//TODO QUE NO CONECTE POR QUE NO ES PARTICIPANTE NI USUARIOs
            }else{
                new Alert(Alert.AlertType.ERROR, "No se encontraron datos con este usuario/contraseña, intente de nuevo.").showAndWait();//TODO QUE SI NO SE CONECTA SALGA UNA VENTANA DE QUE INTENTE DE NUEVO
            }
        });
    }


}
