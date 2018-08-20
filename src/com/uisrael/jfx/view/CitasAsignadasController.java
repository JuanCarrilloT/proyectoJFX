/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.jfx.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class CitasAsignadasController implements Initializable {

    /**
     * Initializes the controller class.
     */
        
    @FXML
    private AnchorPane citasAsignadas;

    @FXML
    private JFXComboBox<?> cmbEspecialidad;

    @FXML
    private JFXComboBox<?> cmbMedico;

    @FXML
    private JFXButton btnbuscar;

    @FXML
    private JFXButton btnverhcl;

    @FXML
    void buscarCita(ActionEvent event) {

    }

    @FXML
    void buscarComboE(ActionEvent event) {

    }

    @FXML
    void buscarComboM(ActionEvent event) {

    }

    @FXML
    void dtTable(ActionEvent event) {

    }

    @FXML
    void verHcl(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    
}
