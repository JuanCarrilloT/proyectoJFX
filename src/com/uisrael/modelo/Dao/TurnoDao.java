/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Dao;

import com.uisrael.modelo.Entidades.Especialidad;
import com.uisrael.modelo.Entidades.Turno;
import com.uisrael.modelo.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author PC
 */
public class TurnoDao {
    
       
    public boolean registrarTurno (Turno turno ){
     Connection connect = null;
     Statement stm = null;
     ResultSet rs = null;
      boolean registrar = false;
     
     String sql="select * from fn_turno("+turno.getIdturno()+","+turno.getHistoriacl()+",'"+turno.getMedico()+"')";
    
		try {			
			connect= Conexion.getConexionPostgrest();
			stm=connect.createStatement();
			rs=stm.executeQuery(sql);
			            registrar = true;             
			stm.close();
			rs.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("Error Clase TurnoDao, metodo registrarTurno");
			e.printStackTrace();
		}
     
         return registrar;
     
     
     }
    
    
    
    public List<Turno> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM turno ORDER BY idturno";
        List<Turno> listaEspecialidad = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Turno c = new Turno();
                c.setIdturno(rs.getInt(1));
                c.setHistoriacl(rs.getInt(2));
                c.setMedico(rs.getString(3));
                c.setFecha(rs.getDate(4));
                c.setEstado(rs.getBoolean(5));
                 
                listaEspecialidad.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase TurnoDao, método obtener");
        }

        return listaEspecialidad;
    }

    
    public List<Turno> buscar(int valor) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  turno WHERE idturno = "+valor+"";
      List<Turno> listaEspecialidad = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Turno c = new Turno();
                c.setIdturno(rs.getInt(1));
                c.setHistoriacl(rs.getInt(2));
                c.setMedico(rs.getString(3));
                c.setFecha(rs.getDate(4));
                c.setEstado(rs.getBoolean(5));
                 
                listaEspecialidad.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase TurnoDao, método buscar");
            e.printStackTrace();
        }

        return listaEspecialidad;
    }
    
     
    
    
     public int codigoesp (String valor) {
         Connection connect = null;
        Statement stm = null;
        ResultSet rs = null;
        int id = 0;
        String sql = "SELECT idesp FROM especialidad where especialidad='"+valor+"'";
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error: Clase EspecialidadDAO, método codigoesp");
            e.printStackTrace();
        }
        return id;
    }
    
     
         public String nEspe (int valor) {
         Connection connect = null;
        Statement stm = null;
        ResultSet rs = null;
        String nombre = "";
        String sql = "SELECT especialidad FROM especialidad where idesp='"+valor+"'";
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                nombre = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error: Clase EspecialidadDAO, método codigoesp");
            e.printStackTrace();
        }
        return nombre;
    }
     
     
    
    
      public ObservableList<Especialidad> getListEspecialidad() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  especialidad  WHERE especialidad  ORDER BY idesp";
      ObservableList<Especialidad> listaEspecialidad = (ObservableList<Especialidad>) new ArrayList<Especialidad>();
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
    
    
    
    public boolean actualizar(Turno turno) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE turno SET historiacl=" + turno.getHistoriacl()+ ", medico='"+turno.getMedico()+"' WHERE idesp=" + turno.getIdturno();
    try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase TurnoDAO, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminar(Turno turno) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM turno WHERE idturno=" + turno.getIdturno();
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
        String sql = "SELECT max(idturno) FROM turno";
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                maximo = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase TurnoDAO, método getMaxID");
            e.printStackTrace();
        }
        return maximo;
    }
    
    
}
