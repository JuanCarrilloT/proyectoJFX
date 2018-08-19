/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.jfx.controller;

import com.uisrael.modelo.Dao.MedicoDao;
import com.uisrael.modelo.Entidades.Medico;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class MedicoController {
    
    public MedicoDao medicodao;

    public MedicoController() {
        medicodao = new MedicoDao();
    }
     public boolean insertarMedico(Medico nuevo) {
        try {
                      
           return medicodao.registrar(nuevo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean actualizarMedico(Medico actualizar){
        try {
           return medicodao.actualizar(actualizar);
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    public void eliminarMedico(Medico eliminar)
    {
        try {
            if(!"".equals(eliminar.getLicencia()))
            {
                medicodao.eliminar(eliminar);
            }
            else
            {
               JOptionPane.showMessageDialog(null, "No Existe registro seleccionado"); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage()); 
        }
           
    }
    public List<Medico> getListMedico()
    {
        return medicodao.obtener();
    }
    
}
