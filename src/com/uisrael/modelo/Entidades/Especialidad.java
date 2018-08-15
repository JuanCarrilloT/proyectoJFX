/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Entidades;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Especialidad implements  Serializable{
    private int idesp;
    private String especialidad;
    private boolean estado;

    public Especialidad(int idesp, String especialidad, boolean estado) {
        this.idesp = idesp;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Especialidad() {
    }

    public int getIdesp() {
        return idesp;
    }

    public void setIdesp(int idesp) {
        this.idesp = idesp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "idesp=" + idesp + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }
    
    
    
    
}
