package Controllers;

import Models.Databases;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import  java.util.List;
import Models.Membre;
import Models.MembreDao;
public class MembreController {
    
      public static void get(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
             List<Membre> membres = new ArrayList<Membre>(); 
            try{
                  String itemSearch=request.getParameter("search");
                Databases.getConnecion();
                if(request.getParameter("search")==null)
                      membres= new MembreDao().getAll();
                else{
                 
                     membres=new MembreDao().getSearch(itemSearch);
                }
                
             }catch(Exception e){
                 System.out.println("error de "+e.getMessage());
                 e.printStackTrace();
                 request.setAttribute("error", e.getMessage());
             }finally{
                 Databases.closeConnection();
            }
             request.setAttribute("membres", membres);
          
            request.getRequestDispatcher("/WEB-INF/View/Membre.jsp").forward(request, response);
             

    }
    
     public static void getDataRequest(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
          List<Membre> membres = new ArrayList<Membre>(); 
            try{
                  String itemSearch=request.getParameter("search");
                Databases.getConnecion();
                if(request.getParameter("search")==null)
                      membres= new MembreDao().getAll();
                else{
                 
                     membres=new MembreDao().getSearch(itemSearch);
                }
                
             }catch(Exception e){
                 System.out.println("error de "+e.getMessage());
                 e.printStackTrace();
                 request.setAttribute("error", e.getMessage());
             }finally{
                 Databases.closeConnection();
            }
             request.setAttribute("membres", membres);
             request.getRequestDispatcher("/WEB-INF/components/PageMembre/MembreView.jsp").forward(request, response);
     }
    
    public static void postRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                
                String nom=request.getParameter("nom");
                String sexe=request.getParameter("sexe");
                String contact=request.getParameter("contact");
                int age=Integer.parseInt(request.getParameter("age"));
                String email=request.getParameter("email");
                MembreDao membreService= new MembreDao();
                membreService.add(new Membre(nom,sexe,age,contact,email));
                out.print("success");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
    }
    
    public static void putRequest(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{
                int id=Integer.parseInt(request.getParameter("id"));
                String num=request.getParameter("numMembre");
                String nom=request.getParameter("nom");
                String sexe=request.getParameter("sexe");
                String contact=request.getParameter("contact");
                int age=Integer.parseInt(request.getParameter("age"));
                String email=request.getParameter("email");
                MembreDao membreService= new MembreDao();
                membreService.update(new Membre(id,nom,sexe,age,contact,email));
                out.print("success");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
    }
    
    public static void deleteRequet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idpers=request.getParameter("idpers");
                MembreDao membreService= new MembreDao();
                membreService.delete(idpers);
                out.print("success");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
            
    }
}
