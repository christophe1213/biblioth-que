/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PreterDao {

    public  void add(Preter p)throws Exception{
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("INSERT INTO  preter VALUES(?,?,?,?,?)");          
            ps.setString(1, p.getIdPret());
            ps.setString(2, p.getIdpers());
            ps.setString(3, p.getIdlivre() );
            ps.setObject(4, p.getDatePres());
            ps.setObject(5, p.getDateRetour());
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }
    }
    
    
    public void update(Preter p) throws Exception{
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("UPDATE  preter set datepret=?,dateretour=? WHERE idpret=? and idpers=? and idlivre=?");          
            ps.setString(3, p.getIdPret());
            ps.setString(4, p.getIdpers());
            ps.setString(5, p.getIdlivre() );
            ps.setObject(1, p.getDatePres());
            ps.setObject(2, p.getDateRetour());
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }
    }
    
    public void delete(String p) throws Exception{
         Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("DELETE FROM Preter WHERE idpret=?");          
            ps.setString(1, p);
            ps.executeUpdate();
        }finally{
            Databases.closeConnection();
        }
    } 
}
