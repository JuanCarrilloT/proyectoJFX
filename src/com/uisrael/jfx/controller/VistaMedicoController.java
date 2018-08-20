/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.jfx.controller;

import com.uisrael.modelo.Dao.VistaMedicoEDao;
import com.uisrael.modelo.Entidades.VistaMedicoE;

import java.util.List;

/**
 *
 * @author PC
 */
public class VistaMedicoController {
    
    public VistaMedicoEDao vistamedicodao;
    

    public VistaMedicoController() {
        vistamedicodao= new VistaMedicoEDao();
    }
    
     public List<VistaMedicoE> getListVm(String valor)
    {
        return vistamedicodao.buscar(valor);
    }
    
    
}
