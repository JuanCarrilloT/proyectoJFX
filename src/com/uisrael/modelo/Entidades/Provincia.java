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
public class Provincia {
    private int idprovincia;
    private String provincia;
    private boolean estado;

    public Provincia() {
    }

    public Provincia(int idprovincia, String provincia, boolean estado) {
        this.idprovincia = idprovincia;
        this.provincia = provincia;
        this.estado = estado;
    }

    public int getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Provincia{" + "idprovincia=" + idprovincia + ", provincia=" + provincia + ", estado=" + estado + '}';
    }
    
    
}
