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
public class Detallehst implements  Serializable{
    private int  iddetalleh;
    private int historiaclinica;
    private Date fecha;
    private String diagnostico;
    private String observacion;
    private String examenes;
    private String medicamentos;
    private String tratamiento;
    private String medico;
    private boolean estado;

    public Detallehst() {
    }

    public Detallehst(int iddetalleh, int historiaclinica, Date fecha, String diagnostico, String observacion, String examenes, String medicamentos, String tratamiento, String medico, boolean estado) {
        this.iddetalleh = iddetalleh;
        this.historiaclinica = historiaclinica;
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.observacion = observacion;
        this.examenes = examenes;
        this.medicamentos = medicamentos;
        this.tratamiento = tratamiento;
        this.medico = medico;
        this.estado = estado;
    }

    public int getIddetalleh() {
        return iddetalleh;
    }

    public void setIddetalleh(int iddetalleh) {
        this.iddetalleh = iddetalleh;
    }

    public int getHistoriaclinica() {
        return historiaclinica;
    }

    public void setHistoriaclinica(int historiaclinica) {
        this.historiaclinica = historiaclinica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getExamenes() {
        return examenes;
    }

    public void setExamenes(String examenes) {
        this.examenes = examenes;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Detallehst{" + "iddetalleh=" + iddetalleh + ", historiaclinica=" + historiaclinica + ", fecha=" + fecha + ", diagnostico=" + diagnostico + ", observacion=" + observacion + ", examenes=" + examenes + ", medicamentos=" + medicamentos + ", tratamiento=" + tratamiento + ", medico=" + medico + ", estado=" + estado + '}';
    }
    
    
    
    
    
}
