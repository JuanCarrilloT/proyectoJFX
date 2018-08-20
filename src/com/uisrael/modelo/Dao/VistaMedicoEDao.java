/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Dao;


import com.uisrael.modelo.Entidades.VistaMedicoE;
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
public class VistaMedicoEDao {
    
    public List<VistaMedicoE> buscar(String valor) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  vista_medico_esp WHERE nombre = '"+valor+"'";
      List<VistaMedicoE> listavm = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                VistaMedicoE c = new VistaMedicoE();
                c.setIdentificacion(rs.getInt(1));
                c.setLicencia(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setEspecialidad(rs.getString(4));
                c.setIdesp(rs.getInt(5));
                 
                listavm.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase VistaMedicoDao, método buscar");
            e.printStackTrace();
        }

        return listavm;
    }
    
}
