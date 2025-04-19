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

         /*  super.getConnecion();
        PreparedStatement ps = null;
        String v; 
        try{
            ps=con.prepareStatement("INSERT into tasks values(?,?);");
            ps.setInt(1, t.getId());
            ps.setString(2, t.getTask());
            ps.executeUpdate();
            con=null;
            v="success";
        }catch(Exception e){
            v="error"+e.getMessage();
        }
        return v;*/
         try{
                Databases.getConnecion();
                PreparedStatement ps = null;
      
                
         }finally{
             Databases.closeConnection(); 
         }
     
      
     
    
        
    }
    
}
