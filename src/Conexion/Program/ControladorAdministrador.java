package Conexion.Program;

import Conexion.Clases.Usuario;
import Conexion.Connect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
            if(password.equals(confirm)){
                Usuario user = new Usuario(id, email, nick, name,lastName, address, password);
                if(checkAdmi.isSelected()){
                    try{
                        con.add_administrador(user,tel);
                    }catch (SQLException e){e.printStackTrace();}
                }
                else{
                    try{
                        con.add_participante(user,tel);
                    }catch (SQLException e){e.printStackTrace();}
                }
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
        });
        add_phone.setOnAction(event -> {
            int number  = Integer.parseInt(number_phone.getText());
            String nick = nick_phone.getText();

            try {
                con.add_telefono(nick,number);
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
        });
        add_percentageIncrease.setOnAction(event -> {
            int i = Integer.parseInt(percentage_requirement.getText());
            try{
                con.mod_porcentaje(i);
            }catch(SQLException e){e.printStackTrace();}
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
