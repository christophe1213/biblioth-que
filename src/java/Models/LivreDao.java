/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class LivreDao {
    
    public LivreDao(){
        
    }
    
    public List<Livre> getAll () throws Exception{
        return select("SELECT * FROM livre");
    }
    
    
    public List<Livre> getSearch (String item) throws Exception{
        return select("SELECT * FROM livre WHERE designation LIKE '%"+item+"%'  or codelivre LIKE '%"+item+"%'");
    }
    
        
    public List<Livre> select (String q) throws Exception{
        
        List<Livre> livres = new ArrayList<>();
        Databases.getConnecion();
        ResultSet rs = null;
        
        int i=0;
        try{
            rs= Databases.querry(q);
            while (rs.next()) {
  
                int id=rs.getInt(1);
                String code=rs.getString(2);
                String design=rs.getString(3);
                int e=rs.getInt(4);
                Livre l = new Livre(id,code,design,e);
                livres.add(l);
            
            
            }
            
        } finally {
           return livres;  
    }

      
        
     
    }
    
    public  Livre getById(int id) throws Exception{
        Livre l = new Livre();
        ResultSet rs = null;

        try{
           
            PreparedStatement ps = Databases.preparedQuerry("SELECT * FROM livre WHERE idlivre=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
              while (rs.next()) {
  
               l.setIdLivre(rs.getInt(1));
               l.setCodeLivre(rs.getString("codelivre"));
               l.setDesign(rs.getString(3));
               l.setExemplaire(rs.getInt(4));
            
            }
        }finally{
            return l;
        }
    }
    public void add(Livre l)throws Exception {
         try{
              ;
                PreparedStatement ps = Databases.preparedQuerry("INSERT into livre (designation, exemplaire) values(?,?)");
                ps.setString(1, l.getDesign());
                ps.setInt(2, l.getExemplaire());
                ps.executeUpdate();
                
         }finally{
             
         }
    }
    
    public void update(Livre l) throws Exception{
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("UPDATE  livre set  designation=?,exemplaire=? WHERE idlivre=?");
            ps.setInt(3, l.getIdLivre());
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
