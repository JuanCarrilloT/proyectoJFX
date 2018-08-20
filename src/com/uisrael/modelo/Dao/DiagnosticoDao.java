/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.modelo.Dao;


import com.uisrael.modelo.Entidades.Diagnostico;
import com.uisrael.modelo.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @jccarrillot
 */
public class DiagnosticoDao {
    
     public boolean registrar(Diagnostico diagnostico) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "INSERT INTO diagnostico (cie, descripcion) values ('"+ diagnostico.getCie() + "','" + diagnostico.getDescripcion() +"')";
        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DiagnosticoDao, método registrar");
        }
        return registrar;
    }

    public List<Diagnostico> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM diagnostico ORDER BY cie";
        List<Diagnostico> listaDiagnostico = new ArrayList<Diagnostico>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Diagnostico c = new Diagnostico();
                c.setCie(rs.getString(1));
                c.setDescripcion(rs.getString(2));
                c.setEstado(rs.getBoolean(3));
                 
                listaDiagnostico.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DiagnosticoDao, método obtener");
            e.printStackTrace();
        }

        return listaDiagnostico;
    }

    
    public List<Diagnostico> buscar(String valor) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM  diagnostico  WHERE descripcion like '%"+valor+"%' or cie like'%"+valor+"%'  ORDER BY cie";
         List<Diagnostico> listaDiagnostico = new ArrayList<Diagnostico>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Diagnostico c = new Diagnostico();
                c.setCie(rs.getString(1));
                c.setDescripcion(rs.getString(2));
                c.setEstado(rs.getBoolean(3));
                 
                listaDiagnostico.add(c);            
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DiagnosticoDao, método buscar");
            e.printStackTrace();
        }

        return listaDiagnostico;
    }
    
    
    public boolean actualizar(Diagnostico diagnostico) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE diagnostico SET descripcion='" + diagnostico.getDescripcion()+"', estado = '" +diagnostico.isEstado() + "'" ;
    try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase DiagnosticoDAO, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminar(Diagnostico diagnostico) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM diagnostico WHERE cie=" + diagnostico.getCie();
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase DiagnosticoDAO, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    
}
