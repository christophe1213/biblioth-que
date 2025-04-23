package Controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import Models.Rendre;
import Models.RendreDao;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thierry Christophe
 */
public class RendreController {
     public static void postRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idrendu=request.getParameter("idrendu");
                String idpers=request.getParameter("idpers");
                String idlivre=request.getParameter("idlivre");
                LocalDateTime datrendu=LocalDateTime.parse(request.getParameter("dateRendu"));
                RendreDao  rendreService= new RendreDao();
                rendreService.add(new Rendre(idrendu,idpers,idlivre,datrendu));
                out.print("success");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
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
