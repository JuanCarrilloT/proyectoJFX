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
public class Medico implements Serializable{
    
    private String licencia;
    private String identificacion;
    private String nombre;
    private String apellido;
    private int especialidad;
    private boolean estado;

    public Medico() {
    }

    public Medico(String licencia, String identificacion, String nombre, String apellido, int especialidad, boolean estado) {
        this.licencia = licencia;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
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
        return "Medico{" + "licencia=" + licencia + ", identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }
    
    
}
