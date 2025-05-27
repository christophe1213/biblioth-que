package Controllers;


import Models.Databases;
import Models.Livre;
import Models.LivreDao;
import Models.Preter;
import Models.PreterDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import Models.Rendre;
import Models.RendreDao;
import java.util.ArrayList;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thierry Christophe
 */
public class RendreController {
    public static void get(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
              List<Rendre>rendus = new ArrayList<Rendre>();
             try{
                 Databases.getConnecion();
                 rendus = new RendreDao().getAll();
                 
             }catch(Exception e){
                   System.out.println(e.getMessage());
                   e.printStackTrace();
             }finally{
                   request.setAttribute("rendus", rendus);
                    request.getRequestDispatcher("/WEB-INF/View/Emprunt.jsp").forward(request, response);
                    Databases.closeConnection();
             }
    }
    
     public static void postRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{   
                Databases.getConnecion();
                String idpers=request.getParameter("idpers");
                String idlivre=request.getParameter("idlivre");
                LocalDateTime datrendu=LocalDateTime.parse(request.getParameter("dateRendu"));
                Livre l = new LivreDao().getById(Integer.parseInt(idlivre));
                if(l.getIdLivre()==0){
                    out.print("livre n'existe pas");
                    return;
                }
                l.setExemplaire(l.getExemplaire()+1);
                new LivreDao().update(l);
                
                  RendreDao  rendreService= new RendreDao();
                String idrendu=rendreService.idGenerate();

                rendreService.add(new Rendre(idrendu,idpers,idlivre,datrendu));
                out.print("success");
            }catch(Exception e){
                out.println("errorm: "+e.getMessage());
            }finally{
                Databases.closeConnection();
            }
    }
     
     public static void putRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idrendu=request.getParameter("idrendu");
                String idpers=request.getParameter("idpers");
                String idlivre=request.getParameter("idlivre");
                LocalDateTime datrendu=LocalDateTime.parse(request.getParameter("dateRendu"));
                RendreDao  rendreService= new RendreDao();
                rendreService.update(new Rendre(idrendu,idpers,idlivre,datrendu));
                out.print("success");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
    }
    
     
    public static void deleteRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idrendu=request.getParameter("idrendu");
                LocalDateTime datrendu=LocalDateTime.parse(request.getParameter("dateRendu"));
                RendreDao  rendreService= new RendreDao();
                rendreService.delete(idrendu);
                out.print("success");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
    }
}
