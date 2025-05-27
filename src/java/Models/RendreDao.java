/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Thierry Christophe
 */
public class RendreDao {
    
    public List<Rendre>getAll(){
        
        List<Rendre> rendus = new ArrayList<>();
        ResultSet rs = null;
        try{
            rs= Databases.querry("SELECT *  from  rendre order by daterendu DESC;");
            while (rs.next()) {
               String id=rs.getString(1);
               String idlivre=rs.getString(2);
               String idpers=rs.getString(3);
               Timestamp ts = rs.getTimestamp(4); // colonne de date de prêt
               LocalDateTime dateRendu = (ts != null) ? ts.toLocalDateTime() : null;
               Rendre r = new Rendre(id,idlivre,idpers,dateRendu);
               rendus.add(r);
             }    
        }finally {
        return rendus;

    }
        
        
        
    }
    
    public  void add(Rendre r)throws Exception{
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("INSERT INTO  Rendre VALUES(?,?,?,?)");          
            ps.setString(1, r.getIdRendu());
            ps.setString(2, r.getIdpers() );
            ps.setString(3, r.getIdlivre());
            ps.setObject(4, r.getDateRendu());
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }

    }
    
    
    public void update(Rendre r) throws Exception{
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("UPDATE  rendre set daterendu=? WHERE idrendu=? and idpers=? and idlivre=?");          
            ps.setObject(1, r.getDateRendu());
            ps.setString(2, r.getIdRendu());
            ps.setString(3, r.getIdpers() );
            ps.setString(4, r.getIdlivre());
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }
    }
    
    public void delete(String id) throws Exception{
         Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("DELETE FROM Rendre WHERE idrendu=?");          
            ps.setString(1, id);
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }

    } 
       public String idGenerate(){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int longueur = 10;
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < longueur; i++) {
            int index = rand.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
         String chaineAleatoire = sb.toString();
         return chaineAleatoire;
    }
}
