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
public class Canton implements  Serializable{
    
    private int idcanton;
    private String canton;
    private int provincia;
    private boolean estado;

    public Canton(int idcanton, String canton, int provincia, boolean estado) {
        this.idcanton = idcanton;
        this.canton = canton;
        this.provincia = provincia;
        this.estado = estado;
    }

    public Canton() {
    }

    public int getIdcanton() {
        return idcanton;
    }

    public void setIdcanton(int idcanton) {
        this.idcanton = idcanton;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
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
        return "Canton{" + "idcanton=" + idcanton + ", canton=" + canton + ", provincia=" + provincia + ", estado=" + estado + '}';
    }
    
    
    
    
}
