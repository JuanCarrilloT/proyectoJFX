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
public class Nacionalidad implements Serializable{
    private int idnacionalidad;
    private String nacionalidad;
    private String pais;
    private boolean estado;

    public Nacionalidad() {
    }

    public Nacionalidad(int idnacionalidad, String nacionalidad, String pais, boolean estado) {
        this.idnacionalidad = idnacionalidad;
        this.nacionalidad = nacionalidad;
        this.pais = pais;
        this.estado = estado;
    }

    public int getIdnacionalidad() {
        return idnacionalidad;
    }

    public void setIdnacionalidad(int idnacionalidad) {
        this.idnacionalidad = idnacionalidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nacionalidad{" + "idnacionalidad=" + idnacionalidad + ", nacionalidad=" + nacionalidad + ", pais=" + pais + ", estado=" + estado + '}';
    }
    
    
}

