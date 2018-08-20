/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.jfx.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import com.uisrael.jfx.controller.TurnoController;
import com.uisrael.jfx.controller.VistaMedicoController;
import com.uisrael.modelo.Dao.MedicoDao;
import com.uisrael.modelo.Dao.VistaMedicoEDao;
import com.uisrael.modelo.Entidades.Medico;
import com.uisrael.modelo.Entidades.Turno;
import com.uisrael.modelo.Entidades.VistaMedicoE;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class AsignarTurnoController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     * 
     */
       
    private Turno nuevo;
    private Turno selectTurno;
    private TurnoController turnocontroller;
    private MedicoDao medico;
    public VistaMedicoController vistamedicocontroller;
    
    @FXML
    private AnchorPane asignarTurno;
    
        @FXML
    private JFXTextField txthistoriacl;

    @FXML
    private JFXComboBox<String> cmbhistoriacl;

    @FXML
    private Label lblespecialidad;

    @FXML
    private Label lblfecha;
        @FXML
    private Label lbllicencia;


    @FXML
    void asignarTurno(ActionEvent event) {
        
   nuevo = new Turno();
        nuevo.setHistoriacl(Integer.parseInt(txthistoriacl.getText()));
         nuevo.setMedico(lbllicencia.getText());
         
         if (turnocontroller.insertarTurno(nuevo)) {
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Informacion");
            mensaje.setContentText("Se Asigno Turno Correctamente");
            mensaje.showAndWait();
            
        } else {
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("No se registro");
            mensaje.showAndWait();
        }
       limpiarText();
          

    }

    @FXML
    void cancelarTodo(ActionEvent event) {

    }

   
    public AsignarTurnoController() {
        
        turnocontroller = new TurnoController();
        
    }
        
     @FXML
    void llenaValor(ActionEvent event) {
         VistaMedicoEDao vm = new VistaMedicoEDao(); 
         ArrayList<VistaMedicoE> list = null;
        list = (ArrayList<VistaMedicoE>) vm.buscar(cmbhistoriacl.getValue());
        System.out.println(cmbhistoriacl.getValue());
           list.forEach((e) -> {
          lblespecialidad.setText(e.getEspecialidad());
          lbllicencia.setText(e.getLicencia());
          
        });
     
       
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        JFXDepthManager.setDepth(asignarTurno, 2);
    fecha();
    llenarCmb();
    }    
    
    public void fecha()
    {
   Date date = new Date();
          DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          System.out.println("Hora: "+dateFormat.format(date));

      lblfecha.setText( dateFormat.format(date)) ;
    
    }

    public void llenarCmb() {
        
       medico = new MedicoDao();
      List<Medico> medicodList = medico.obtener();
      medicodList.forEach((e) -> {
          cmbhistoriacl.getItems().add(e.getNombre()+" "+e.getApellido());
          
        });

   
      
      
}
    public void  limpiarText(){
        
        lblespecialidad.setText("");
        lbllicencia.setText("");
    
    
    }
}
