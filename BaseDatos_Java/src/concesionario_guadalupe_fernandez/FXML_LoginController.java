/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package concesionario_guadalupe_fernandez;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // Importación de PreparedStatement
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private Button boton_entrar;
    
    @FXML
    private TextField contrasena;

    @FXML
    private TextField usuario;
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/Concesionario_Guadalupe_Fernandez";
    static final String DB_USER = "userBD";
    static final String DB_PASSWD = "userBD";
    static Connection connection = null;
    static Statement statement = null;

    public static void CrearConnexio() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FXML_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void BotonEntrar(ActionEvent event) throws IOException {
        String sUsuario = usuario.getText();
        String sContrasena = contrasena.getText();

        String query = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sUsuario);
            preparedStatement.setString(2, sContrasena);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Usuario y contraseña correctos
                    System.out.println("Inicio de sesión exitoso");
                    // Aquí puedes redirigir al usuario a la siguiente pantalla
                    // Por ejemplo: redirigir(event);
                } else {
                    // Usuario o contraseña incorrectos
                    System.out.println("Usuario o contraseña incorrectos");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXML_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    // Si no están todos los campos rellenados --> botón Acceder deshabilitado
        boton_entrar.setDisable(true);
        CrearConnexio();
        usuario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (usuario.getText().isEmpty() || contrasena.getText().isEmpty()) {
                boton_entrar.setDisable(true);
            } else {
                boton_entrar.setDisable(false);
            }
        });

        contrasena.textProperty().addListener((observable, oldValue, newValue) -> {
            if (usuario.getText().isEmpty() || contrasena.getText().isEmpty()) {
                boton_entrar.setDisable(true);
            } else {
                boton_entrar.setDisable(false);
            }
        }); 
    }    
    
    
}
