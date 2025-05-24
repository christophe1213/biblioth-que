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
        
        int i=0;
        try{
            rs= Databases.querry("SELECT *  from livre");
            while (rs.next()) {
  
                int id=rs.getInt(1);
                String code=rs.getString(2);
                String design=rs.getString(3);
                int e=rs.getInt(4);
                Livre l = new Livre(id,code,design,e);
                livres.add(l);
                i++;
            
            }
            
        } finally {
        Databases.closeConnection();
    }

      
        
        return livres;  
    }
    public  Livre getById(int id) throws Exception{
        Livre l = new Livre();
        ResultSet rs = null;

        try{
            Databases.getConnecion();
            PreparedStatement ps = Databases.preparedQuerry("SELECT * FROM livre WHERE idlivre=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
              while (rs.next()) {
  
               l.setIdlivre(rs.getInt(1));
               l.setDesign(rs.getString(3));
               l.setExemplaire(rs.getInt(4));
            
            }
        }finally{
            return l;
        }
    }
    public void add(Livre l)throws Exception {
         try{
                Databases.getConnecion();
                PreparedStatement ps = Databases.preparedQuerry("INSERT into livre (designation, exemplaire) values(?,?)");
                ps.setString(1, l.getDesign());
                ps.setInt(2, l.getExemplaire());
                ps.executeUpdate();
                
         }finally{
             Databases.closeConnection(); 
         }
    }
    
    public void update(Livre l) throws Exception{
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("UPDATE  livre set  designation=?,exemplaire=? WHERE idlivre=?");
            ps.setInt(3, l.getIdlivre());
            ps.setString(1, l.getDesign());
            ps.setInt(2, l.getExemplaire());
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }
    }
    
    public void delete(int id) throws Exception{ 
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("DELETE FROM livre where idlivre=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }
    }
}
