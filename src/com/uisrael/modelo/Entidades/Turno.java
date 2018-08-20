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
public class Turno implements Serializable{
   private int idturno;
   private int historiacl;
   private String medico;
   private Date fecha;
   private boolean estado;

    public Turno() {
    }

    public Turno(int idturno, int historiacl, String medico, Date fecha, boolean estado) {
        this.idturno = idturno;
        this.historiacl = historiacl;
        this.medico = medico;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public int getHistoriacl() {
        return historiacl;
    }

    public void setHistoriacl(int historiacl) {
        this.historiacl = historiacl;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Turno{" + "idturno=" + idturno + ", historiacl=" + historiacl + ", medico=" + medico + ", fecha=" + fecha + ", estado=" + estado + '}';
    }
    
 





   
}
