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
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import com.uisrael.jfx.controller.DiagnosticoController;
import com.uisrael.modelo.Entidades.Diagnostico;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author PC
 */
public class CrudDiagnosticoController implements Initializable {

    /**
     * Initializes the controller class.
     */
     private Diagnostico nuevo;
    private Diagnostico selectDiagnostico;
    private DiagnosticoController diagnosticocontroller;
      @FXML
    private AnchorPane registroDiagnostico;

    @FXML
    private AnchorPane registroEspecialidad;

    @FXML
    private JFXButton btnguardar;

    @FXML
    private JFXButton btnactualizar;

    @FXML
    private JFXButton btncancelar;

    @FXML
    private JFXButton btneliminar;

    @FXML
    private JFXTextField txtcie;

    @FXML
    private TableView<Diagnostico> dtTable;

    @FXML
    private JFXTextArea txtdescripcion;

    @FXML
    void actualizaCie(ActionEvent event) {
        actualiza();
    }

    @FXML
    void eliminaCie(ActionEvent event) {
       
    }

    @FXML
    void guardarCie(ActionEvent event) {
         guarda();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        JFXDepthManager.setDepth(registroDiagnostico, 2);
    
     crearGrid();
    llenarDatos();
    }   

    public CrudDiagnosticoController() {
        
        diagnosticocontroller = new DiagnosticoController();
    }
    
    
      private void actualiza (){
    
     nuevo = new Diagnostico();
         nuevo.setDescripcion(selectDiagnostico.getDescripcion());
         nuevo.setCie(selectDiagnostico.getCie());
         if (diagnosticocontroller.actualizarDiagnostico(nuevo)) {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setContentText("Datos actualizados Correctamente");
            mensaje.showAndWait();
            llenarDatos();
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("No se actualizo");
            mensaje.showAndWait();
        }
         limpiarText();
       
    }
    
      
       private void guarda(){
    
     nuevo = new Diagnostico();
     
        nuevo.setCie(txtcie.getText());
        nuevo.setDescripcion(txtdescripcion.getText());
        
         if (diagnosticocontroller.insertarDiagnostico(nuevo)) {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setContentText("Especialidad se registro Correctamente");
            mensaje.showAndWait();
            llenarDatos();
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("No se registro");
            mensaje.showAndWait();
        }
       limpiarText();
       
    
    }
       public void crearGrid() {
        TableColumn cie = new TableColumn("Cie");
        cie.setCellValueFactory(new PropertyValueFactory<Diagnostico, String>("cie"));
        TableColumn descripcion = new TableColumn("Descripcion");
        descripcion.setCellValueFactory(new PropertyValueFactory<Diagnostico, String>("descripcion"));
      
        dtTable.getColumns().add(cie);
        dtTable.getColumns().add(descripcion);
        
        dtTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                onEdit();
            }
        });

    }
     
      public void llenarDatos() {

        ArrayList<Diagnostico> list = null;
        list = (ArrayList<Diagnostico>) diagnosticocontroller.getListDiagnostico();
        ObservableList<Diagnostico> data = FXCollections.observableList(list);
        dtTable.setItems(data);

    }
      
      public void onEdit() {
        if (dtTable.getSelectionModel().getSelectedItem() != null) {
            selectDiagnostico = dtTable.getSelectionModel().getSelectedItem();
            txtcie.setText(selectDiagnostico.getCie());                  
            txtdescripcion.setText(selectDiagnostico.getDescripcion());
            btnactualizar.setDisable(false);
        }
    }
    
   
    private void limpiarText(){
        txtdescripcion.setText("");
        txtcie.setText("");
       
    }
}
