/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.jfx.controller;

import com.uisrael.modelo.Dao.VistaMedicoEDao;
import com.uisrael.modelo.Dao.VistaMedicoHclDao;
import com.uisrael.modelo.Entidades.VistaMedicoE;
import com.uisrael.modelo.Entidades.VistaMedicoHcl;
import java.util.List;

/**
 *
 * @author PC
 */
public class VistaMedicoHclcontroller {
    
     public VistaMedicoHclDao vistamedicohcldao;

    public VistaMedicoHclcontroller() {
         vistamedicohcldao = new VistaMedicoHclDao();
        
    }
    
    
     public List<VistaMedicoHcl> getListVm(String valor)
    {
        return vistamedicohcldao.buscar(valor);
    }
     
      public List<VistaMedicoHcl> getList()
    {
        return vistamedicohcldao.ListaV();
    }
    
}
