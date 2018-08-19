/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Dao;


import com.uisrael.modelo.Entidades.Operador;
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
public class OperadorDao {
    
       public boolean registrar(Operador operador) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO operador (idoperador, identificacion,nombre,apellido,cargo,usuario,password) values ("+ operador.getIdoperador() + ",'"+operador.getIdentificacion()+"','" + operador.getNombre()+"','" + operador.getApellido() + "','"+operador.getCargo()+"',"
                + "'"+operador.getUsuario()+"','"+operador.getPassword()+"')";
        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase OperadorDao, método registrar");
        }
        return registrar;
    }

    public List<Operador> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Operador ORDER BY apellido";
        List<Operador> listaOPerador = new ArrayList<Operador>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Operador c = new Operador();
                c.setIdoperador(rs.getInt(1));
                c.setIdentificacion(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setCargo(rs.getString(5));
                c.setUsuario(rs.getString(6));
                c.setPassword(rs.getString(7));
                
                c.setEstado(rs.getBoolean(8));
                
                 
                listaOPerador.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase OperadorDao, método obtener");
            e.printStackTrace();
        }

        return listaOPerador;
    }

    
    public List<Operador> buscar(String valor) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  operador  WHERE  nombre like '%"+valor+"%' or apellido like'%"+valor+"%'  ORDER BY apellido";
       List<Operador> listaOPerador = new ArrayList<Operador>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Operador c = new Operador();
                c.setIdoperador(rs.getInt(1));
                c.setIdentificacion(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setCargo(rs.getString(5));
                c.setUsuario(rs.getString(6));
                c.setPassword(rs.getString(7));
                
                c.setEstado(rs.getBoolean(8));
                
                 
                listaOPerador.add(c);        
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase Epdosb, método buscar");
            e.printStackTrace();
        }

        return listaOPerador;
    }
    
    
    public boolean actualizar(Operador  operador) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE operador SET identificacion='" + operador.getIdentificacion()+ "', nombre='" + operador.getNombre()+"',apellido = '"+operador.getApellido()+"'"
                + " cargo ='"+operador.getCargo()+"',usuario='"+operador.getUsuario()+"',password='"+operador.getPassword()+"', estado = '"+operador.isEstado()+"' WHERE idoperador=" + operador.getIdoperador();
    try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase OperadorDAO, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminar(Operador operador) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM operador WHERE licencia=" + operador.getIdoperador();
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase OperadorDAO, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

       public int getMaxID() {
        Connection connect = null;
        Statement stm = null;
        ResultSet rs = null;
        int maximo = 1;
        String sql = "SELECT max(idcanton) FROM operador";
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                maximo = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase OperadorDAO, método getMaxID");
            e.printStackTrace();
        }
        return maximo;
    }
    
}
