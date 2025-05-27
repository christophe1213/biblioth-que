
package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class MembreDao {
    
   public MembreDao(){
       
   }
   
    public List<Membre>getAll() throws Exception {
       return select("Select * from membre");
    }
    
     public List<Membre>getSearch(String i) throws Exception {
         String item="c";
         System.out.print("search :"+item);
         return select("SELECT * from membre where idpers Like '%"+item+"%' or  nom LIKE '%"+item+"%' or sexe  Like '%"+item+"%' "
                + "or contact Like '%"+item+"%' or email Like '%"+item+"%'");
    }
   
   
   

   
      private List<Membre>select(String querry) throws Exception {
        List<Membre> membres = new ArrayList<>();
      
        ResultSet rs = null;
        try{
            rs= Databases.querry(querry);
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
      return membres; 
    }
        
   }
   
   
   public Membre getMembreByid(String id){
        Membre p=new Membre();
        ResultSet rs = null;
       
        try{
            PreparedStatement ps= Databases.preparedQuerry("SELECT  * FROM Membre where idpers=?");
            ps.setString(1, id);
            rs=ps.executeQuery();
           while(rs.next()){
               p.setIdpers(rs.getString("idpers"));
               p.setNom(rs.getString("nom"));
               p.setAge(rs.getInt("age"));
               p.setContact(rs.getString("sexe"));
               p.setEmail(rs.getString("email"));
               System.out.println("j'suis dans la methode membres");
               
           }
           System.out.println("membre"+p.getNom()+" id= "+id);
        }finally{
            System.out.println("methode membres");
            return p;
        }
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
