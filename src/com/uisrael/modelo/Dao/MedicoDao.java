/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Dao;


import com.uisrael.modelo.Entidades.Medico;
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
public class MedicoDao {
    
     public boolean registrar(Medico medico) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO medico (licencia, identificacion,nombre,apellido,especialidad) values ('"+ medico.getLicencia() + "','"+medico.getIdentificacion()+"','" + medico.getNombre()+"','" + medico.getApellido() + "',"+medico.getEspecialidad()+")";
        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase MedicoDao, método registrar");
        }
        return registrar;
    }

    public List<Medico> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM medico ORDER BY apellido";
        List<Medico> listaMedico = new ArrayList<Medico>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Medico c = new Medico();
                c.setLicencia(rs.getString(1));
                c.setIdentificacion(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setEspecialidad(rs.getInt(5));
                c.setEstado(rs.getBoolean(6));
                
                 
                listaMedico.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase MedicoDao, método obtener");
            e.printStackTrace();
        }

        return listaMedico;
    }
    
     public List<Object[]> obtiene() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT a.licencia ,a.nombre, a.apellido,e.especialidad,e.idesp "
                + "FROM medico a inner join especialidad e on e.idesp = a.especialidad";
       List<Object[]> listaMedico = new ArrayList<Object[]>();
        try {
             
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                listaMedico.add(new Object[]{
                rs.getString("licencia"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("especialidad"),
                rs.getInt("idesp")
              
                
                });
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase MedicoDao, método obtener");
            e.printStackTrace();
        }

        return listaMedico;
    }

    
    
    
    public List<Medico> buscar(String valor) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  medico  WHERE licencia like '%"+valor+"%' or apellido like'%"+valor+"%'  ORDER BY apellido";
       List<Medico> listaMedico = new ArrayList<Medico>();
        try {
           co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Medico c = new Medico();
                c.setLicencia(rs.getString(1));
                c.setIdentificacion(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setEstado(rs.getBoolean(5));
                
                 
                listaMedico.add(c);          
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase Epdosb, método buscar");
            e.printStackTrace();
        }

        return listaMedico;
    }
    
    
    public boolean actualizar(Medico  medico) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE medico SET identificacion='" + medico.getIdentificacion()+ "', nombre='" + medico.getNombre()+"',apellido = '"+medico.getApellido()+"'"
                + " ,especialidad ="+medico.getEspecialidad()+", estado = "+medico.isEstado()+" WHERE licencia= '"+ medico.getLicencia()+"'";
    try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase MedicoDAO, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminar(Medico medico) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM medico WHERE licencia=" + medico.getLicencia();
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase MedicoDAO, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

 
}
