/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package concesionario_guadalupe_fernandez;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author bemen3
 */
public class FXML_LoginController implements Initializable {

    @FXML
    private Button boton_acceder;
    
    @FXML
    private TextField contrasena;

    @FXML
    private TextField usuario;
    
    @FXML
    public void BotonEntrar(ActionEvent event) throws IOException {
        
        String sUsuario = usuario.getText();
        String sContrasena = contrasena.getText();
        
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios");
            while (resultSet.next()) {
                System.out.printf("%s\t%s\n",
                        resultSet.getInt("nombre"),
                        resultSet.getInt("contrasena"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(concesionario_guadalupe_fernandez.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    // Si no están todos los campos rellenados --> botón Acceder deshabilitado
        boton_acceder.setDisable(true);

        usuario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (usuario.getText().isEmpty() || contrasena.getText().isEmpty()) {
                boton_acceder.setDisable(true);
            } else {
                boton_acceder.setDisable(false);
            }
        });

        contrasena.textProperty().addListener((observable, oldValue, newValue) -> {
            if (usuario.getText().isEmpty() || contrasena.getText().isEmpty()) {
                boton_acceder.setDisable(true);
            } else {
                boton_acceder.setDisable(false);
            }
        }); 
    }    
    
    
}
