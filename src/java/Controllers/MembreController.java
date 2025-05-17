package Controllers;

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
   
             request.getRequestDispatcher("/WEB-INF/View/Membre.jsp").forward(request, response);
        

    }
    
     public static void getDataRequest(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
          List<Membre> membres = new ArrayList<Membre>(); 
            try{
                membres= new MembreDao().getAll();                
             }catch(Exception e){
                 System.out.println("error de "+e.getMessage());
                 request.setAttribute("error", e.getMessage());
             }
             request.setAttribute("membres", membres);
             request.getRequestDispatcher("/WEB-INF/components/PageMembre/MembreView.jsp").forward(request, response);
     }
    
    public static void postRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idpers=request.getParameter("idpers");
                String nom=request.getParameter("nom");
                String sexe=request.getParameter("sexe");
                String contact=request.getParameter("contact");
                int age=Integer.parseInt(request.getParameter("age"));
                MembreDao membreService= new MembreDao();
                membreService.add(new Membre(idpers,nom,sexe,age,contact));
                out.print("success add");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
    }
    
    public static void putRequest(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idpers=request.getParameter("idpers");
                String nom=request.getParameter("nom");
                String sexe=request.getParameter("sexe");
                String contact=request.getParameter("contact");
                int age=Integer.parseInt(request.getParameter("age"));
                MembreDao membreService= new MembreDao();
                membreService.update(new Membre(idpers,nom,sexe,age,contact));
                out.print("success pupdate");
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
                out.print("success delete"+idpers);
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
            
    }
}
