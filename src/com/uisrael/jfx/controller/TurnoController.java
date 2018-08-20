/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.jfx.controller;

import com.uisrael.modelo.Dao.EspecialidadDao;
import com.uisrael.modelo.Dao.MedicoDao;
import com.uisrael.modelo.Dao.TurnoDao;
import com.uisrael.modelo.Entidades.Especialidad;
import com.uisrael.modelo.Entidades.Turno;
import java.util.List;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class TurnoController {
  
     public EspecialidadDao especialidaddao;
     public TurnoDao turnodao;
     public MedicoDao medicodao;

    public TurnoController() {
        turnodao = new TurnoDao();
        especialidaddao=new EspecialidadDao();
        medicodao = new MedicoDao();
        
    }
    
    public int codigo(){
    int idturno= turnodao.getMaxID();
    return idturno;
    }
    
    
     public String nEspecialidad(int valor){
    String idEsp= especialidaddao.nEspe(valor);
    return idEsp;
    }
     public boolean insertarTurno (Turno nuevo) {
        try {
                 int idturno= turnodao.getMaxID();
            nuevo.setIdturno(idturno);     
           return turnodao.registrarTurno(nuevo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean actualizarTurno(Turno actualizar){
        try {
           return turnodao.actualizar(actualizar);
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public void eliminarTurno(Turno eliminar)
    {
        try {
            if(eliminar.getIdturno()!=0)
            {
                turnodao.eliminar(eliminar);
            }
            else
            {
               JOptionPane.showMessageDialog(null, "No Existe registro seleccionado"); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage()); 
        }
           
    }
    public List<Turno> getListEspecialidad()
    {
        return turnodao.obtener();
    }
    
   public int codigoespe(String valor){
    int idEsp= especialidaddao.codigoesp(valor);
    return idEsp;
    }
    
      public ObservableList<Especialidad> ListaEspecialidad()
    {
        return especialidaddao.getListEspecialidad();
    }
    
}
