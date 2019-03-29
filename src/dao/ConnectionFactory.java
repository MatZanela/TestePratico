/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */

//Fabrica de Conexoes
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/testepratico?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    
    public static Connection getConnection(){
        Connection c = null;
        try{
            Class.forName(DRIVER);
            c = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }
}
