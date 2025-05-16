/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Models.LivreDao;
import Models.Livre;
import java.io.PrintWriter;
import java.util.ArrayList;
import  java.util.List;
/**
 *
 * @author Thierry Christophe
 */
public class LivreController {
     
    public static void get(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
   
             request.getRequestDispatcher("/WEB-INF/View/Livre.jsp").forward(request, response);
        

    }
    
    
    public static void getDataRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             List<Livre> livres = new ArrayList<Livre>(); 
            try{
                livres= new LivreDao().getAll();                
             }catch(Exception e){
                 System.out.println("error de "+e.getMessage());
                 request.setAttribute("error", e.getMessage());
             }
             request.setAttribute("livres", livres);
             request.getRequestDispatcher("/WEB-INF/components/PageLivre/LivreView.jsp").forward(request, response);
             //request.getRequestDispatcher("WEB-INF/Test.jsp").forward(request,response);
     
    }
    
    public static void postRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //int id =Integer.parseInt(request.getParameter("id")) ;
          
             PrintWriter out = response.getWriter();
            try{
                  String design= request.getParameter("design");
                   String idLivre=request.getParameter("idlivre");
                   int exemplaire = Integer.parseInt(request.getParameter("exemplaire"));
                   LivreDao livreService = new LivreDao();
                   livreService.add( new Livre(idLivre,design,exemplaire));
                  out.print("success");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
    }
    
    public static void putRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        try{
            String design= request.getParameter("design");
            String idLivre=request.getParameter("idlivre");
            int exemplaire = Integer.parseInt(request.getParameter("exemplaire"));
            LivreDao livreService = new LivreDao();
            livreService.update(new Livre(idLivre,design,4));
            out.print("success");
        }catch(Exception e){
            out.println(e.getMessage());        
        }
    }
    
    public static void deleteRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        try{
            String idLivre=request.getParameter("idlivre");
            LivreDao livreService = new LivreDao();
            livreService.delete(idLivre);
            out.print("success"+idLivre);
        }catch(Exception e){
            out.println(e.getMessage());        
        }
    }
}
