/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class LivreDao {
    
    public LivreDao(){
        
    }
    
    public List<Livre> getAll(){
        
        List<Livre> livres = new ArrayList<>();
        Databases.getConnecion();
        ResultSet rs = null;
        try{
            rs= Databases.querry("SELECT * from livre");
            while (rs.next()) {
  
                String id=rs.getString(1);
                String design=rs.getString(2);
                int e=rs.getInt(3);
                Livre l = new Livre(id,design,e);
                livres.add(l);
            
            }
            
        }catch(Exception e){
            System.out.println("error de "+e.getMessage());
        }
        Databases.closeConnection();
        
        return livres;  
    }
}
