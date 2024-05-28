/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package concesionario_guadalupe_fernandez;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


/**
 * FXML Controller class
 *
 * @author bemen3
 */
public class FXML_MenuController implements Initializable {
    
    @FXML
    private Button botonconsultar;

    @FXML
    private Button botoneliminar;

    @FXML
    private Button botoninsertar;

    @FXML
    private Button botonmodificar;

    @FXML
    void botonconsultar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXML_Consultar.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void botoneliminar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXML_Insertar.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void botoninsertar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXML_Eliminar.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void botonmodificar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXML_Modificar.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
