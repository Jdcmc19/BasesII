package Conexion.Program;

import Conexion.Connect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorAdministrador implements Initializable {
    Connect con;
    @FXML
    Label lblAlias;
    @FXML
    Button register_registerUser,edit_editUser,add_phone,add_minimumIncrease,add_percentageIncrease,go_consultas;
    @FXML
    TextField id_registerUser,name_registerUser,lastName_registerUser,email_registerUser,nick_registerUser,address_registerUser;
    @FXML
    TextField id_editUser,name_editUser,lastName_editUser,email_editUser,address_editUser;
    @FXML
    TextField number_phone,nick_phone,percentage_requirement,minimun_requirement;
    @FXML
    PasswordField password_registerUser,confirm_registerUser;
    public void initialize(URL fxmlLocations, ResourceBundle resources){
        register_registerUser.setOnAction(event -> {
            int id = Integer.parseInt(id_registerUser.getText());
            String name = name_registerUser.getText();
            String lastName = lastName_registerUser.getText();
            String email = email_registerUser.getText();
            String nick = nick_registerUser.getText();
            String password = password_registerUser.getText();
            String confirm = confirm_registerUser.getText();
            //TODO VERIFICAR QUE LAS CONTRASENAS SEAN IGUALES
            String address = address_registerUser.getText();
        });
        edit_editUser.setOnAction(event -> {
            int id = Integer.parseInt(id_editUser.getText());
            String name = name_editUser.getText();
            String lastName = lastName_editUser.getText();
            String email = email_editUser.getText();
            String address = address_editUser.getText();
        });
        add_phone.setOnAction(event -> {
            int number  = Integer.parseInt(number_phone.getText());
            String nick = nick_phone.getText();
        });
        add_minimumIncrease.setOnAction(event -> {
            int i = Integer.parseInt(minimun_requirement.getText());
        });
        add_percentageIncrease.setOnAction(event -> {
            int i = Integer.parseInt(percentage_requirement.getText());
        });
        go_consultas.setOnAction(event -> {});
    }
    public void setCon(Connect con) {
        this.con = con;
    }
    public void setAlias(){
        lblAlias.setText(con.getUsername());
    }
}
