/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  environnement.Env;
/**
 *
 * @author Thierry Christophe
 */
public class Databases {
      public static  Connection con ;
      protected static PreparedStatement ps ;
      protected static String url = Env.urlDb;
      protected static String user = Env.userDb;
      protected static String password = Env.passwordDb;
      
    
    public Databases(){
        
    }
    
    public  static void getConnecion() {
     
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
    
    public static ResultSet querry(String q){
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
             ps = con.prepareStatement(q);
             rs = ps.executeQuery();
        }catch(Exception e){
            System.out.println("error requete ");
            e.printStackTrace();
        }
        return rs;
        
    }
    public static PreparedStatement preparedQuerry(String q)throws Exception{
         PreparedStatement ps = null;
         ps=con.prepareStatement(q);
         return ps;
         
    }
    public static void closeConnection(){
        System.out.println("Ferméture de connection !");
        con=null;
    }
}
