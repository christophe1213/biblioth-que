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

public class PreterDao {

    public List<Preter>getAll() throws Exception {
        return select("SELECT *  from  preter order by datepret DESC");     
    }
    public List<Preter>getSearchBy2Date(String start,String end) throws Exception {
        return select("SELECT * FROM preter WHERE datepret BETWEEN '"+start+"' and '"+end+"' order by datepret DESC");     
    }
    
    public List<Preter>getRetardataire() throws Exception{
        return select("SELECT * FROM preter WHERE dateRetour - CURRENT_DATE < 0;");
    }
    
    
    public List<Preter>select(String q) throws Exception {
        List<Preter> prets = new ArrayList<>();
        ResultSet rs = null;
        try{
            rs= Databases.querry(q);
            while (rs.next()) {
               String id=rs.getString(1);
               String idlivre=rs.getString(2);
               String idpers=rs.getString(3);
               
               int nb=rs.getInt(6);
               Timestamp ts = rs.getTimestamp(4); // colonne de date de prêt
               LocalDateTime datePret = (ts != null) ? ts.toLocalDateTime() : null;
               Date retour = rs.getDate(5);
               LocalDate dateRetour = (retour != null) ? retour.toLocalDate() : null;
               Preter p = new Preter(id,idlivre,idpers,datePret,dateRetour,nb);
               prets.add(p);
              
            }
        } finally {
        return prets;
    }
        
   }
    
    
    public  void add(Preter p)throws Exception{
        Databases.getConnecion();
        try{
            PreparedStatement ps= Databases.preparedQuerry("INSERT INTO  preter VALUES(?,?,?,?,?,?)");          
            ps.setString(1, p.getIdPret());
            ps.setString(2, p.getIdpers());
            ps.setString(3, p.getIdlivre() );
            ps.setObject(4, p.getDatePres());
            ps.setObject(5, p.getDateRetour());
            ps.setObject(6, p.getNb());
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
