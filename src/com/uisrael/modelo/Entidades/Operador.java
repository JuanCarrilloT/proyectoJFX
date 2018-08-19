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
public class Operador implements Serializable{
    
    private int idoperador;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String cargo;
    private String usuario;
    private String password;
    private boolean estado;

    public Operador(int idoperador, String identificacion, String nombre, String apellido, String cargo, String usuario, String password, boolean estado) {
        this.idoperador = idoperador;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
    }

    public Operador() {
    }

    public int getIdoperador() {
        return idoperador;
    }

    public void setIdoperador(int idoperador) {
        this.idoperador = idoperador;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Operador{" + "idoperador=" + idoperador + ", identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", cargo=" + cargo + ", usuario=" + usuario + ", password=" + password + ", estado=" + estado + '}';
    }
    
    
}
