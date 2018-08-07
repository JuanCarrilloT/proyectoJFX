
package com.uisrael.modelo.conexion;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrperez
 */
public class Conexion {

    public static Connection getConexionMysql() {
        Connection con = null;
        try {

            //instancia del driver Base
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba1", "root","");
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }

    public static Connection getConexionPostgrest() {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/prueba2";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "juan1096carlos");
        //props.setProperty("ssl", "true");
        try {
            con = DriverManager.getConnection(url, props);
System.out.println("");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void closeConexion() {
        Connection con = null;
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexion Cerrada");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
