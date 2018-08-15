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
public class Diagnostico implements  Serializable{
    private String cie ;
    private String descripcion;
    private boolean estado;

    public Diagnostico() {
    }

    public Diagnostico(String cie, String descripcion, boolean estado) {
        this.cie = cie;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getCie() {
        return cie;
    }

    public void setCie(String cie) {
        this.cie = cie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Diagnostico{" + "cie=" + cie + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }
    
    
    
    
}
