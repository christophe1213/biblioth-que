/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class LivreDao {
    
    public LivreDao(){
        
    }
    
    public List<Livre> getAll () throws Exception{
        
        List<Livre> livres = new ArrayList<>();
        Databases.getConnecion();
        ResultSet rs = null;
        
        
        try{
            rs= Databases.querry("SELECT *  from livre");
            while (rs.next()) {
  
                String id=rs.getString(1);
                String design=rs.getString(2);
                int e=rs.getInt(3);
                Livre l = new Livre(id,design,e);
                livres.add(l);
            
            }
            
        } finally {
        Databases.closeConnection();
    }

      
        
        return livres;  
    }
    
    public void add(Livre l)throws Exception {
         try{
                Databases.getConnecion();
                PreparedStatement ps = Databases.preparedQuerry("INSERT into livre values(?,?,?)");
                ps.setString(1, l.getIdlivre());
                ps.setString(2, l.getDesign());
                ps.setInt(3, l.getExemplaire());
                ps.executeUpdate();
                
         }finally{
             Databases.closeConnection(); 
         }
    }
    
    public void update(Livre l) throws Exception{
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("UPDATE  livre set  designation=?,exemplaire=? WHERE idlivre=?");
            ps.setString(3, l.getIdlivre());
            ps.setString(1, l.getDesign());
            ps.setInt(2, l.getExemplaire());
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }
    }
    
    public void delete(String id) throws Exception{ 
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("DELETE FROM livre where idlivre=?");
            ps.setString(1, id);
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }
    }
}
