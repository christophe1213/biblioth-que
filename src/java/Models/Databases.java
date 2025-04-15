/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Thierry Christophe
 */
public class Databases {
      protected static  Connection con ;
      protected static PreparedStatement ps ;
      protected static String url = "jdbc:postgresql://localhost:5432/test";;
      protected static String user = "postgres";
      protected static String password = "azerty";
      
    
    public Databases(){
        
    }
    
    public  static void getConnecion(){
     
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user,password );
            System.out.println("Connexion réussie à la base de données !");
            
        } catch (Exception e) {
            System.err.println("Erreur de connexion : " + e.getMessage());

        }
         con =conn;
   }
    
    public static void closeConnection(){
        con=null;
    }
}
