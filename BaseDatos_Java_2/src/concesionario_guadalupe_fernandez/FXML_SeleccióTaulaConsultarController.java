/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package concesionario_guadalupe_fernandez;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author bemen3
 */
public class FXML_SeleccióTaulaConsultarController implements Initializable {
    
    @FXML
    private Button acceder;

    @FXML
    private ComboBox<String> combomarca;

    @FXML
    private ComboBox<String> combomodelo;

    @FXML
    private ComboBox<String> comboprecio;

    @FXML
    private ComboBox<String> combovehiculo;

    @FXML
    void acceder(ActionEvent event) {
        System.out.println("Botón Acceder presionado");
    }

    @FXML
    void combomarca(ActionEvent event) {
        String selectedMarca = combomarca.getSelectionModel().getSelectedItem();
        System.out.println("Marca seleccionada: " + selectedMarca);
    }

    @FXML
    void combomodelo(ActionEvent event) {
        String selectedModelo = combomodelo.getSelectionModel().getSelectedItem();
        System.out.println("Modelo seleccionado: " + selectedModelo);
    }

    @FXML
    void comboprecio(ActionEvent event) {
        String selectedPrecio = comboprecio.getSelectionModel().getSelectedItem();
        System.out.println("Precio seleccionado: " + selectedPrecio);
    }

    @FXML
    void combovehiculo(ActionEvent event) {
        String selectedVehiculo = combovehiculo.getSelectionModel().getSelectedItem();
        System.out.println("Vehículo seleccionado: " + selectedVehiculo);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combovehiculo.getItems().addAll("Coche", "Moto");
        combovehiculo.setValue("Vehiculo");
        
        String selectedMarca = combomarca.getSelectionModel().getSelectedItem();
        
        if (selectedMarca.equals("Coche")){
            combomarca.getItems().addAll("Nissan", "Honda", "Toyota");
            combomarca.setValue("Marcas");
        }else{
            
        }
    }    
}
