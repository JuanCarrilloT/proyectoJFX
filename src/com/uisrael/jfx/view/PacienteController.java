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
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;


/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class PacienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    



       @FXML
    private JFXTextField jfxUserName;

    @FXML
    private JFXPasswordField jfxPassword;

    @FXML
    private JFXButton jbfxIngresar;



    
}
