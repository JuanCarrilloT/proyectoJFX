/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Auditoria implements  Serializable{
    
    private int idaud; 
    private String nombreTabla;
    private String operacion;
    private String valanterior;
    private String valnuevo;
    private Date fmodificacion;
    private String username;

    public Auditoria() {
    }

    public Auditoria(int idaud, String nombreTabla, String operacion, String valanterior, String valnuevo, Date fmodificacion, String username) {
        this.idaud = idaud;
        this.nombreTabla = nombreTabla;
        this.operacion = operacion;
        this.valanterior = valanterior;
        this.valnuevo = valnuevo;
        this.fmodificacion = fmodificacion;
        this.username = username;
    }

    public int getIdaud() {
        return idaud;
    }

    public void setIdaud(int idaud) {
        this.idaud = idaud;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getValanterior() {
        return valanterior;
    }

    public void setValanterior(String valanterior) {
        this.valanterior = valanterior;
    }

    public String getValnuevo() {
        return valnuevo;
    }

    public void setValnuevo(String valnuevo) {
        this.valnuevo = valnuevo;
    }

    public Date getFmodificacion() {
        return fmodificacion;
    }

    public void setFmodificacion(Date fmodificacion) {
        this.fmodificacion = fmodificacion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Auditoria{" + "idaud=" + idaud + ", nombreTabla=" + nombreTabla + ", operacion=" + operacion + ", valanterior=" + valanterior + ", valnuevo=" + valnuevo + ", fmodificacion=" + fmodificacion + ", username=" + username + '}';
    }
    
    
    
    
}
