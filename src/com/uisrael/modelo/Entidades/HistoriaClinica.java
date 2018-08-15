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
public class HistoriaClinica implements Serializable{
    
    private int idhcl;
    private Date fecha;
    private int paciente;
    private String tiposangre;
    private String alergias;  
    private String antecedentesfm;
    private String discapacidades;
    private boolean estado;

    public HistoriaClinica(int idhcl, Date fecha, int paciente, String tiposangre, String alergias, String antecedentesfm, String discapacidades, boolean estado) {
        this.idhcl = idhcl;
        this.fecha = fecha;
        this.paciente = paciente;
        this.tiposangre = tiposangre;
        this.alergias = alergias;
        this.antecedentesfm = antecedentesfm;
        this.discapacidades = discapacidades;
        this.estado = estado;
    }

    public HistoriaClinica() {
    }

    public int getIdhcl() {
        return idhcl;
    }

    public void setIdhcl(int idhcl) {
        this.idhcl = idhcl;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public String getTiposangre() {
        return tiposangre;
    }

    public void setTiposangre(String tiposangre) {
        this.tiposangre = tiposangre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getAntecedentesfm() {
        return antecedentesfm;
    }

    public void setAntecedentesfm(String antecedentesfm) {
        this.antecedentesfm = antecedentesfm;
    }

    public String getDiscapacidades() {
        return discapacidades;
    }

    public void setDiscapacidades(String discapacidades) {
        this.discapacidades = discapacidades;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "HistoriaClinica{" + "idhcl=" + idhcl + ", fecha=" + fecha + ", paciente=" + paciente + ", tiposangre=" + tiposangre + ", alergias=" + alergias + ", antecedentesfm=" + antecedentesfm + ", discapacidades=" + discapacidades + ", estado=" + estado + '}';
    }
    
    
    
          
    
}
