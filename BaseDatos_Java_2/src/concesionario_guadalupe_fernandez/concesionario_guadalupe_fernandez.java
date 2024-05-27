/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package concesionario_guadalupe_fernandez;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author bemen3
 */
public class concesionario_guadalupe_fernandez extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));
        primaryStage.setTitle("Concesionario Guadalupe-Fernández");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    } catch (IOException e) {
        System.err.println("Error al cargar el archivo FXML: " + e.getMessage());
        e.printStackTrace();
    }
    }
    
}