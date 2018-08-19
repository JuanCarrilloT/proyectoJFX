/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Dao;

import com.uisrael.modelo.Entidades.Canton;
import com.uisrael.modelo.Entidades.Detallehst;
import com.uisrael.modelo.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DetallehstDao {
    
     public boolean registrar(Detallehst detallehst) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO detallehst (iddetalleh,historiaclinica,fecha,diagnostico,observaciones,examenes,medicamentos,tratamiento,medico)"
                + " values ("+ detallehst.getIddetalleh() + "," + detallehst.getHistoriaclinica()+",'" + detallehst.getFecha() + "','"+detallehst.getFecha()+"'"
                + ",'"+detallehst.getDiagnostico()+"','"+detallehst.getObservacion()+"','"+detallehst.getMedicamentos()+"','"+detallehst.getTratamiento()+"',"
                + "'"+detallehst.getMedico()+"')";
        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DetallehstDao, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    public List<Detallehst> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM detallehst ORDER BY iddetalleh";
        List<Detallehst> listaDetallehst = new ArrayList<Detallehst>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Detallehst c = new Detallehst();
                c.setIddetalleh(rs.getInt(1));
                c.setHistoriaclinica(rs.getInt(2));
                c.setFecha(rs.getDate(3));
                c.setDiagnostico(rs.getString(4));
                c.setObservacion(rs.getString(5));
                c.setExamenes(rs.getString(6));
                c.setMedicamentos(rs.getString(7));
                c.setTratamiento(rs.getString(8));
                c.setMedico(rs.getString(9));
                c.setEstado(rs.getBoolean(10));
                 
                listaDetallehst.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DetallehstDao, método obtener");
            e.printStackTrace();
        }

        return listaDetallehst;
    }

    
    public List<Detallehst> buscar(String valor) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  detallehst  WHERE historiaclinica like '%"+valor+"%' or medico like'%"+valor+"%'  ORDER BY iddetalleh";
       List<Detallehst> listaDetallehst = new ArrayList<Detallehst>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Detallehst c = new Detallehst();
                c.setIddetalleh(rs.getInt(1));
                c.setHistoriaclinica(rs.getInt(2));
                c.setFecha(rs.getDate(3));
                c.setDiagnostico(rs.getString(4));
                c.setObservacion(rs.getString(5));
                c.setExamenes(rs.getString(6));
                c.setMedicamentos(rs.getString(7));
                c.setTratamiento(rs.getString(8));
                c.setMedico(rs.getString(9));
                c.setEstado(rs.getBoolean(10));
                 
                listaDetallehst.add(c);       
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DetallehstDao, método buscar");
            e.printStackTrace();
        }

        return listaDetallehst;
    }

    public int getMaxID() {
        Connection connect = null;
        Statement stm = null;
        ResultSet rs = null;
        int maximo = 1;
        String sql = "SELECT max(iddetalleh) FROM detallehst";
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                maximo = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase DetallehstDAO, método getMaxID");
            e.printStackTrace();
        }
        return maximo;
    }
    
    
}
