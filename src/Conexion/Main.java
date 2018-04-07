package Conexion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Program/UILogin.fxml"));
        primaryStage.setTitle("Bases de Datos II");
        primaryStage.setScene(new Scene(root, 700, 261));
        primaryStage.show();
        System.out.println("asdasda");
    }

    public static void main(String[] args) {

        launch(args);
    }
}
