/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.PreparedStatement;

/**
 *
 * @author Thierry Christophe
 */
public class RendreDao {
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
}
