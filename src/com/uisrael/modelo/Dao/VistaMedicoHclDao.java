/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Dao;

import com.uisrael.modelo.Entidades.VistaMedicoE;
import com.uisrael.modelo.Entidades.VistaMedicoHcl;
import com.uisrael.modelo.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class VistaMedicoHclDao {
    
   
    
     public List<VistaMedicoHcl> buscar(String valor) {
         
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  vista_medico_hcl WHERE nombre = '"+valor+"' or especialidad = '"+valor+"'";
      List<VistaMedicoHcl> listavmh = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                VistaMedicoHcl c = new VistaMedicoHcl();
                c.setNombre(rs.getString(1));
                c.setLicencia(rs.getString(2));
                c.setEspecialidad(rs.getString(3));
                c.setIdturno(rs.getInt(4));
                c.setIdhcl(rs.getInt(5));
                c.setPaciente(rs.getString(6));
                c.setIdhcl(rs.getInt(7));
                c.setFecha(rs.getDate(8));               
                listavmh.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase VistaMedicoHclDao, método buscar");
            e.printStackTrace();
        }

        return listavmh;
     }
     
      public List<VistaMedicoHcl> ListaV() {
         
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  vista_medico_hcl WHERE order by idturno";
      List<VistaMedicoHcl> listavmh = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                VistaMedicoHcl c = new VistaMedicoHcl();
                c.setNombre(rs.getString(1));
                c.setLicencia(rs.getString(2));
                c.setEspecialidad(rs.getString(3));
                c.setIdturno(rs.getInt(4));
                c.setIdhcl(rs.getInt(5));
                c.setPaciente(rs.getString(6));
                c.setIdhcl(rs.getInt(7));
                c.setFecha(rs.getDate(8));               
                listavmh.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase VistaMedicoHclDao, método buscar");
            e.printStackTrace();
        }

        return listavmh;
     }
    
}
