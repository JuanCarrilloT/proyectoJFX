/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.jfx.controller;

import com.uisrael.modelo.Dao.DiagnosticoDao;
import com.uisrael.modelo.Entidades.Diagnostico;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DiagnosticoController {
    
     public DiagnosticoDao diagnosticodao;

    public DiagnosticoController() {
        diagnosticodao= new DiagnosticoDao();
    }
    
       
        public boolean insertarDiagnostico (Diagnostico nuevo) {
        try {
                   
           return diagnosticodao.registrar(nuevo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean actualizarDiagnostico(Diagnostico actualizar){
        try {
           return diagnosticodao.actualizar(actualizar);
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public void eliminarDiagnostico(Diagnostico eliminar)
    {
        try {
            if(!"".equals(eliminar.getCie()))
            {
                diagnosticodao.eliminar(eliminar);
            }
            else
            {
               JOptionPane.showMessageDialog(null, "No Existe registro seleccionado"); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage()); 
        }
           
    }
    public List<Diagnostico> getListDiagnostico()
    {
        return diagnosticodao.obtener();
    }
    
  
    
   
    
}
