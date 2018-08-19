/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Dao;

import com.uisrael.modelo.Entidades.Canton;
import com.uisrael.modelo.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Jccarrillot
 */
public class CantonDao {
    
    public boolean registrar(Canton canton) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO canton (idcanton, canton,provincia) values ("+ canton.getIdcanton() + ",'" + canton.getCanton()+"'," + canton.getProvincia() + ")";
        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase CantonDao, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    public List<Canton> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM canton ORDER BY idcanton";
        List<Canton> listaCanton = new ArrayList<Canton>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Canton c = new Canton();
                c.setIdcanton(rs.getInt(1));
                c.setCanton(rs.getString(2));
                c.setProvincia(rs.getInt(3));
                c.setEstado(rs.getBoolean(4));
                 
                listaCanton.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase CantonDao, método obtener");
            e.printStackTrace();
        }

        return listaCanton;
    }

    
    public List<Canton> buscar(String valor) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  canton  WHERE canton like '%"+valor+"%' or estado like'%"+valor+"%'  ORDER BY idcanton";
       List<Canton> listaCanton = new ArrayList<Canton>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Canton c = new Canton();
                c.setIdcanton(rs.getInt(1));
                c.setCanton(rs.getString(2));
                c.setProvincia(rs.getInt(3));
                c.setEstado(rs.getBoolean(4));
                 
                listaCanton.add(c);            
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase Epdosb, método buscar");
            e.printStackTrace();
        }

        return listaCanton;
    }
    
    
    public boolean actualizar(Canton canton) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE canton SET canton='" + canton.getCanton()+ "', provincia=" + canton.getProvincia() +" WHERE idcanton=" + canton.getIdcanton();
    try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase CantonDAO, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminar(Canton canton) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM canton WHERE idcanton=" + canton.getIdcanton();
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase CantonDAO, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    public int getMaxID() {
        Connection connect = null;
        Statement stm = null;
        ResultSet rs = null;
        int maximo = 1;
        String sql = "SELECT max(idcanton) FROM canton";
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                maximo = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase CantonDAO, método getMaxID");
            e.printStackTrace();
        }
        return maximo;
    }
    
}
