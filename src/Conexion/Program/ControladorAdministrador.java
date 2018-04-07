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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControladorAdministrador implements Initializable {
    Connect con;
    @FXML
    CheckBox checkAdmi;
    @FXML
    Label lblAlias;
    @FXML
    Button register_registerUser,edit_editUser,add_phone,add_minimumIncrease,add_percentageIncrease,go_consultas;
    @FXML
    TextField id_registerUser,name_registerUser,lastName_registerUser,email_registerUser,nick_registerUser,address_registerUser,tel_registerUser;
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
            String address = address_registerUser.getText();
            int tel = Integer.parseInt(tel_registerUser.getText());
            if(password.equals(confirm) && password.length()>= 8 && password.length()<=15){
                String pss = Usuario.encripta(password);
                Usuario user = new Usuario(id, email, nick, name,lastName, address, pss);
                if(checkAdmi.isSelected()){
                    try{
                        if(!con.add_administrador(user,tel)){
                            new Alert(Alert.AlertType.ERROR, "No se insertó el administrador, verifique datos.").showAndWait();
                        }else{
                            limpiarRegisterUser();
                        }
                    }catch (SQLException e){e.printStackTrace();}
                }
                else{
                    try{
                        if(!con.add_participante(user,tel)){
                            new Alert(Alert.AlertType.ERROR, "No se insertó el participante, verifique datos.").showAndWait();
                        }else{
                            limpiarRegisterUser();
                        }
                    }catch (SQLException e){e.printStackTrace();}
                }

            }else{
                new Alert(Alert.AlertType.ERROR, "La contraseña no cumple con los requisitos.").showAndWait();
            }//TODO que salga una ventana de que esta mamando

        });
        edit_editUser.setOnAction(event -> {
            int id = Integer.parseInt(id_editUser.getText());
            String name = name_editUser.getText();
            String lastName = lastName_editUser.getText();
            String email = email_editUser.getText();
            String address = address_editUser.getText();


            Usuario user = new Usuario(id,email,name,lastName,address);

            try{
                con.mod_usuario(user);
            }catch (SQLException e){e.printStackTrace();}
            limpiarEditUser();
        });
        add_phone.setOnAction(event -> {
            int number  = Integer.parseInt(number_phone.getText());
            String nick = nick_phone.getText();

            try {
                if(!con.add_telefono(nick,number)){
                    new Alert(Alert.AlertType.ERROR, "El telefono no se inserto, verifique datos.").showAndWait();
                }else{
                    limpiarTelefono();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }

        });
        add_minimumIncrease.setOnAction(event -> {
            int i = Integer.parseInt(minimun_requirement.getText());
            try{
                con.mod_minimo(i);
            }catch (SQLException e){
                e.printStackTrace();
            }
            minimun_requirement.setText("");
        });
        add_percentageIncrease.setOnAction(event -> {
            int i = Integer.parseInt(percentage_requirement.getText());
            try{
                con.mod_porcentaje(i);
            }catch(SQLException e){e.printStackTrace();}
            percentage_requirement.setText("");
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
    public void limpiarRegisterUser(){
        id_registerUser.setText("");
        name_registerUser.setText("");
        lastName_registerUser.setText("");
        email_registerUser.setText("");
        nick_registerUser.setText("");
        password_registerUser.setText("");
        confirm_registerUser.setText("");
        address_registerUser.setText("");
        tel_registerUser.setText("");
        checkAdmi.setSelected(false);
    }
    public void limpiarEditUser(){
        id_editUser.setText("");
        name_editUser.setText("");
        lastName_editUser.setText("");
        email_editUser.setText("");
        address_editUser.setText("");
    }
    public void limpiarTelefono(){
        number_phone.setText("");
        nick_phone.setText("");
    }
}
