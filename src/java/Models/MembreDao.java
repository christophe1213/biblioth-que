
package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class MembreDao {
    
   public MembreDao(){
       
   }
   
   public List<Membre>getAll() throws Exception {
        List<Membre> membres = new ArrayList<>();
        Databases.getConnecion();
        ResultSet rs = null;
        try{
            rs= Databases.querry("SELECT *  from membre");
            while (rs.next()) {
               String id=rs.getString(1);
               String nom=rs.getString(2);
               String sexe=rs.getString(3);
               int age=rs.getInt(4);
               String contact=rs.getString(5);
               Membre m = new Membre(id,nom,sexe,age,contact);
               membres.add(m);
            }
        } finally {
        Databases.closeConnection();
    }
        return membres; 
   }
   public void add(Membre m)throws Exception{
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("INSERT INTO  membre VALUES(?,?,?,?,?)");
            ps.setString(1, m.getIdpers());
            ps.setString(2, m.getNom());
            ps.setString(3,m.getSexe());
            ps.setInt(4,m.getAge());
            ps.setString(5, m.getContact());
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }

   }
   
   public void update(Membre m) throws Exception{
       Databases.getConnecion();
       try{
            PreparedStatement ps= Databases.preparedQuerry("UPDATE membre set nom=?,sexe=?,age=?,contact=? WHERE idpers=?");
            ps.setString(5, m.getIdpers());
            ps.setString(1, m.getNom());
            ps.setString(2,m.getSexe() );
            ps.setInt(3,m.getAge() );
            ps.setString(4, m.getContact());
            ps.executeUpdate();
       }finally{
          Databases.closeConnection(); 
       }
   }
   public void delete(String id) throws Exception{
       Databases.getConnecion();
       try{
            PreparedStatement ps= Databases.preparedQuerry("DELETE FROM membre WHERE idpers=? ");
            ps.setString(1, id);
            ps.executeUpdate();
       }finally{
          Databases.closeConnection(); 
       }
   }
}
