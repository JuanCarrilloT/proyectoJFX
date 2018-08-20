/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Entidades;

import java.util.Date;

/**
 *
 * @author PC
 */
public class VistaMedicoHcl {
    
    private String nombre;
    private String licencia;
    private String especialidad;
    private int idturno;    
    private int idhcl;
    private String paciente;
    private int idpaciente;
    private Date fecha;

    public VistaMedicoHcl() {
    }

    public VistaMedicoHcl(String nombre, String licencia, String especialidad, int idturno, int idhcl, String paciente, int idpaciente, Date fecha) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.especialidad = especialidad;
        this.idturno = idturno;
        this.idhcl = idhcl;
        this.paciente = paciente;
        this.idpaciente = idpaciente;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public int getIdhcl() {
        return idhcl;
    }

    public void setIdhcl(int idhcl) {
        this.idhcl = idhcl;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "VistaMedicoHcl{" + "nombre=" + nombre + ", licencia=" + licencia + ", especialidad=" + especialidad + ", idturno=" + idturno + ", idhcl=" + idhcl + ", paciente=" + paciente + ", idpaciente=" + idpaciente + ", fecha=" + fecha + '}';
    }

   




}
