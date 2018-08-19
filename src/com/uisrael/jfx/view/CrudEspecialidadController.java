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
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import com.uisrael.jfx.controller.EspecialidadController;

import com.uisrael.modelo.Entidades.Especialidad;
import com.uisrael.modelo.Entidades.Medico;
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
public class CrudEspecialidadController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     * 
     */   
    private Especialidad nuevo;
    private Especialidad selectEspecialidad;
    private EspecialidadController especialidadcontroller;
    
    
      @FXML
    private AnchorPane registroEspecialidad;

    @FXML
    private JFXTextField txtnombre;

    @FXML
    private JFXButton btnguardar;

    @FXML
    private JFXButton btnactualizar;

    @FXML
    private JFXButton btncancelar;

    @FXML
    private JFXButton btneliminar;

    
    @FXML
    private JFXTextField txtidesp;

     
    @FXML
    private TableView<Especialidad> dtTable;
    

    @FXML
    void actualizaEspecialidad(ActionEvent event) {
        
      actualiza();

    }

    @FXML
    void eliminaEspecialidad(ActionEvent event) {

    }

    @FXML
    void guardarEspecialidad(ActionEvent event) {
     
      guarda();
     
    }   
    
      public CrudEspecialidadController() {
        especialidadcontroller = new EspecialidadController();

    }
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    JFXDepthManager.setDepth(registroEspecialidad, 2);
    codigo();
      crearGrid();
    llenarDatos();
    
    }  
    private void codigo(){
    
    txtidesp.setText(Integer.toString(especialidadcontroller.codigo()));
    
    }
   
    private void actualiza (){
    
     nuevo = new Especialidad ();
         nuevo.setEspecialidad(txtnombre.getText());
         nuevo.setIdesp(selectEspecialidad.getIdesp());
         if (especialidadcontroller.actualizarEspecialidad(nuevo)) {
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
         codigo();
    }
    
    private void guarda(){
    
     nuevo = new Especialidad();
        nuevo.setEspecialidad(txtnombre.getText());
        
         if (especialidadcontroller.insertarEspecialidad(nuevo)) {
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
       codigo();
    
    }
    
    
   public void crearGrid() {
        TableColumn idesp = new TableColumn("Codigo");
        idesp.setCellValueFactory(new PropertyValueFactory<Especialidad, String>("idesp"));
        TableColumn especialidad = new TableColumn("Nombre");
        especialidad.setCellValueFactory(new PropertyValueFactory<Especialidad, String>("especialidad"));
        TableColumn estado = new TableColumn("Estado");
        estado.setCellValueFactory(new PropertyValueFactory<Medico, String>("estado"));
        dtTable.getColumns().add(idesp);
        dtTable.getColumns().add(especialidad);
        dtTable.getColumns().add(estado);
        dtTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                onEdit();
            }
        });

    }
     
      public void llenarDatos() {

        ArrayList<Especialidad> list = null;
        list = (ArrayList<Especialidad>) especialidadcontroller.getListEspecialidad();
        ObservableList<Especialidad> data = FXCollections.observableList(list);
        dtTable.setItems(data);

    }
      
      public void onEdit() {
        if (dtTable.getSelectionModel().getSelectedItem() != null) {
            selectEspecialidad = dtTable.getSelectionModel().getSelectedItem();
            txtidesp.setText(Integer.toHexString(selectEspecialidad.getIdesp()));                  
            txtnombre.setText(selectEspecialidad.getEspecialidad());
            btnactualizar.setDisable(false);
        }
    }
    
   
    private void limpiarText(){
        txtnombre.setText("");
        txtidesp.setText("");
       
    }
    
    
    
    
    
}
