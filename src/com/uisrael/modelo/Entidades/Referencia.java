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
public class Referencia implements Serializable{
    
   private int idreferencia;
   private String nombre;
   private String parentesco;
   private String telefono;
   private int paciente;
   private boolean estado;

    public Referencia() {
    }

    public Referencia(int idreferencia, String nombre, String parentesco, String telefono, int paciente, boolean estado) {
        this.idreferencia = idreferencia;
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.telefono = telefono;
        this.paciente = paciente;
        this.estado = estado;
    }

    public int getIdreferencia() {
        return idreferencia;
    }

    public void setIdreferencia(int idreferencia) {
        this.idreferencia = idreferencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Referencia{" + "idreferencia=" + idreferencia + ", nombre=" + nombre + ", parentesco=" + parentesco + ", telefono=" + telefono + ", paciente=" + paciente + ", estado=" + estado + '}';
    }
   
   
    
}
