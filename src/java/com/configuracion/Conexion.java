
package com.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    private final String host ="localhost";
    private final String port ="3306";
    private final String databaseName ="colegio";
    private final String url ="jdbc:mysql://".concat(host).concat(":").concat(port).concat("/").concat(databaseName);
    private final String userName="root";
    private final String passWord="julian19961203";
    private final String className="com.mysql.cj.jdbc.Driver";
    
    
    public Connection getConexion(){
        try{
            Class.forName(className);
            return DriverManager.getConnection(url,userName,passWord);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error al conectar al servidor de base datos" + ex);
        }
        return null;
    }
}
