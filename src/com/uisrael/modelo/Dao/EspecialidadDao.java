/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Dao;


import com.uisrael.modelo.Entidades.Especialidad;
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
public class EspecialidadDao {
    
     public boolean registrar(Especialidad especialidad) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO especialidad (idesp,especialidad) values ("+ especialidad.getIdesp()+ ",'" + especialidad.getEspecialidad()+"')";
        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EspecialidadDao, método registrar");
        }
        return registrar;
    }

    public List<Especialidad> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM especialidad ORDER BY idesp";
        List<Especialidad> listaEspecialidad = new ArrayList<Especialidad>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Especialidad c = new Especialidad();
                c.setIdesp(rs.getInt(1));
                c.setEspecialidad(rs.getString(2));
                c.setEstado(rs.getBoolean(3));
                 
                listaEspecialidad.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EspecialidadDao, método obtener");
            e.printStackTrace();
        }

        return listaEspecialidad;
    }

    
    public List<Especialidad> buscar(String valor) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  especialidad  WHERE especialidad like '%"+valor+"%' or idesp like'%"+valor+"%'  ORDER BY idesp";
      List<Especialidad> listaEspecialidad = new ArrayList<Especialidad>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Especialidad c = new Especialidad();
                c.setIdesp(rs.getInt(1));
                c.setEspecialidad(rs.getString(2));
                c.setEstado(rs.getBoolean(3));
                 
                listaEspecialidad.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EspecialidadDa, método buscar");
            e.printStackTrace();
        }

        return listaEspecialidad;
    }
    
    
    public boolean actualizar(Especialidad especialidad) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE especialidad SET especialidad='" + especialidad.getEspecialidad()+ "', estado='" + especialidad.isEstado() +"' WHERE idesp=" + especialidad.getIdesp();
    try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase EspecialidadDAO, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminar(Especialidad especialidad) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM especialidad WHERE idesp=" + especialidad.getIdesp();
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase EspecialidadDAO, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    public int getMaxID() {
        Connection connect = null;
        Statement stm = null;
        ResultSet rs = null;
        int maximo = 1;
        String sql = "SELECT max(idesp) FROM especialidad";
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                maximo = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase EspecialidadDAO, método getMaxID");
            e.printStackTrace();
        }
        return maximo;
    }
    
}
