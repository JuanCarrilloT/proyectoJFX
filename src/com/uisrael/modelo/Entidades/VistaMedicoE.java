/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Entidades;

/**
 *
 * @author PC
 */
public class VistaMedicoE {
    
    private int identificacion;
    private String licencia;
    private String nombre;
    private String especialidad;
    private int idesp;

    public VistaMedicoE() {
    }

    public VistaMedicoE(int identificacion, String licencia, String nombre, String especialidad, int idesp) {
        this.identificacion = identificacion;
        this.licencia = licencia;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.idesp = idesp;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public String getLicencia() {
        return licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getIdesp() {
        return idesp;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setIdesp(int idesp) {
        this.idesp = idesp;
    }

    @Override
    public String toString() {
        return "VistaMedicoE{" + "identificacion=" + identificacion + ", licencia=" + licencia + ", nombre=" + nombre + ", especialidad=" + especialidad + ", idesp=" + idesp + '}';
    }
    
    
    
    
}
