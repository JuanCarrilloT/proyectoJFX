/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.jfx.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import com.uisrael.jfx.controller.EspecialidadController;
import com.uisrael.jfx.controller.MedicoController;
import com.uisrael.modelo.Dao.EspecialidadDao;
import com.uisrael.modelo.Entidades.Especialidad;
import com.uisrael.modelo.Entidades.Medico;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class CrudMedicosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Medico nuevo;
    private Medico selectMedico;
    private MedicoController medicocontroller;
    private EspecialidadController especialidadcontroller;
    
        @FXML
    private TableView<Medico> dtTable;

    @FXML
    private JFXButton btnguardar;

    @FXML
    private JFXButton btnactualizar;

    @FXML
    private JFXButton btncancelar;

    @FXML
    private JFXTextField txtlicencia;

    @FXML
    private JFXTextField txtidentificacion;

    @FXML
    private JFXTextField txtnombre;

    @FXML
    private JFXTextField txtapellido;

    @FXML
    private JFXComboBox<String> cmbespecialidad;
     @FXML
    private AnchorPane registroMedico;


    @FXML
    void actualizaMedico(ActionEvent event) {
        actualizarMedico();
    }

    @FXML
    void eliminaMedico(ActionEvent event) {

    }

     @FXML
    void guardarMedico(ActionEvent event) {
       nuevo = new Medico();
        nuevo.setLicencia(txtlicencia.getText());
        nuevo.setIdentificacion(txtidentificacion.getText());
        nuevo.setNombre(txtnombre.getText());
        nuevo.setApellido(txtapellido.getText());
        nuevo.setLicencia(txtlicencia.getText());
       nuevo.setEspecialidad(codigoE());
       if (medicocontroller.insertarMedico(nuevo)) {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setContentText("Medico se registro Correctamente");
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
    
    public int codigoE(){
     int a=especialidadcontroller.codigoespe(cmbespecialidad.getValue());
        
    return a; 
    }
  
    
     public CrudMedicosController() {
        medicocontroller = new MedicoController();
        especialidadcontroller = new EspecialidadController();

    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       JFXDepthManager.setDepth(registroMedico, 2);
         crearGrid();
       llenarDatos();
       llenarCmb();
    } 
    
    @FXML
    private void closeStage(MouseEvent event) {
        Platform.exit();
    }
    
    public void crearGrid() {
        TableColumn licencia = new TableColumn("Licencia");
        licencia.setCellValueFactory(new PropertyValueFactory<Medico, String>("licencia"));
        TableColumn nombre = new TableColumn("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<Medico, String>("nombre"));
        TableColumn apellido = new TableColumn("Apellido");
        apellido.setCellValueFactory(new PropertyValueFactory<Medico, String>("apellido"));
        TableColumn especialidad = new TableColumn("Especialidad");
        especialidad.setCellValueFactory(new PropertyValueFactory<Medico, String>("especialidad"));
        TableColumn estado = new TableColumn("Estado");
        estado.setCellValueFactory(new PropertyValueFactory<Medico, String>("estado"));
        dtTable.getColumns().add(licencia);
        dtTable.getColumns().add(nombre);
        dtTable.getColumns().add(apellido);
        dtTable.getColumns().add(especialidad);
        dtTable.getColumns().add(estado);
        dtTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                onEdit();
            }
        });

    }
    
    
     public void llenarDatos() {

        ArrayList<Medico> list = null;
        list = (ArrayList<Medico>) medicocontroller.getListMedico();
        ObservableList<Medico> data = FXCollections.observableList(list);
        dtTable.setItems(data);
        
       
    }
     
     public void llenarCmb() {
        
      EspecialidadDao espe = new EspecialidadDao();
      List<Especialidad> especialidadList = espe.obtener();
      especialidadList.forEach((e) -> {
          cmbespecialidad.getItems().add(e.getEspecialidad());
        });
        

    }
     
 

    
     public void onEdit() {
        if (dtTable.getSelectionModel().getSelectedItem() != null) {
            selectMedico = dtTable.getSelectionModel().getSelectedItem();
            txtlicencia.setText(selectMedico.getLicencia());                  
            txtnombre.setText(selectMedico.getNombre());
            txtapellido.setText(selectMedico.getApellido());
            txtidentificacion.setText(selectMedico.getIdentificacion());
            cmbespecialidad.setValue(nombreE(selectMedico.getEspecialidad()));
            btnactualizar.setDisable(false);
        }
    }
     
     public String nombreE(int valor){
     
     return especialidadcontroller.nEspecialidad(valor);
     }
     
     public void actualizarMedico()
    {
         nuevo = new Medico ();
         nuevo.setNombre(txtnombre.getText());
         nuevo.setApellido(txtapellido.getText());
         nuevo.setIdentificacion(txtidentificacion.getText());
         nuevo.setEspecialidad(codigoE());
         nuevo.setLicencia(selectMedico.getLicencia());
         if (medicocontroller.actualizarMedico(nuevo)) {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setContentText("Datos del Medico se actualizo Correctamente");
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
     
     private void limpiarText(){
        txtnombre.setText("");
        txtapellido.setText("");
        txtidentificacion.setText("");
        txtlicencia.setText(""); 
    }
}
