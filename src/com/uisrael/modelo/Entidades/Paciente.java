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
public class Paciente implements Serializable{
    
 private int idpaciente;
 private String identificacion;
 private String nombre;
 private String apellido;
 private String direccion;
 private Date fechanaciemiento;
 private int nacionalidad;
 private String lugnacimiento;
 private int lugresidencia;
 private String telefono;
 private String celular;
 private boolean estado;

    public Paciente() {
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechanaciemiento() {
        return fechanaciemiento;
    }

    public void setFechanaciemiento(Date fechanaciemiento) {
        this.fechanaciemiento = fechanaciemiento;
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getLugnacimiento() {
        return lugnacimiento;
    }

    public void setLugnacimiento(String lugnacimiento) {
        this.lugnacimiento = lugnacimiento;
    }

    public int getLugresidencia() {
        return lugresidencia;
    }

    public void setLugresidencia(int lugresidencia) {
        this.lugresidencia = lugresidencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idpaciente=" + idpaciente + ", identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", fechanaciemiento=" + fechanaciemiento + ", nacionalidad=" + nacionalidad + ", lugnacimiento=" + lugnacimiento + ", lugresidencia=" + lugresidencia + ", telefono=" + telefono + ", celular=" + celular + ", estado=" + estado + '}';
    }
 
 
 
 
    
}
