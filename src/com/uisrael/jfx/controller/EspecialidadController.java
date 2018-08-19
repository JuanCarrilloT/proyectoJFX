/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.jfx.controller;

import com.uisrael.modelo.Dao.EspecialidadDao;
import com.uisrael.modelo.Entidades.Especialidad;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class EspecialidadController {
    
     public EspecialidadDao especialidaddao;

    public EspecialidadController() {
        especialidaddao = new EspecialidadDao();
    }
    
    public int codigo(){
    int idEsp= especialidaddao.getMaxID();
    return idEsp;
    }
     public boolean insertarEspecialidad (Especialidad nuevo) {
        try {
                 int idEsp= especialidaddao.getMaxID();
            nuevo.setIdesp(idEsp);     
           return especialidaddao.registrar(nuevo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean actualizarEspecialidad(Especialidad actualizar){
        try {
           return especialidaddao.actualizar(actualizar);
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public void eliminarEspecialidad(Especialidad eliminar)
    {
        try {
            if(eliminar.getIdesp()!=0)
            {
                especialidaddao.eliminar(eliminar);
            }
            else
            {
               JOptionPane.showMessageDialog(null, "No Existe registro seleccionado"); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage()); 
        }
           
    }
    public List<Especialidad> getListEspecialidad()
    {
        return especialidaddao.obtener();
    }
    
}
