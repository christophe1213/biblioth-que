/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import  java.util.List;
import Models.Preter;
import Models.PreterDao;
import Models.LivreDao;
import Models.Livre;

public class PreterController {
    
     public static void postRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idpret=request.getParameter("idPret");
                String idpers=request.getParameter("idpers");
                String idlivre=request.getParameter("idlivre");
                LocalDateTime datpres=LocalDateTime.parse(request.getParameter("datePret"));
                LocalDate dateRetour=LocalDate.parse(request.getParameter("dateRetour"));
                PreterDao  preterService= new PreterDao();
                Livre l = new LivreDao().getById(idlivre);
                if(l.getExemplaire()-1<0){
                    out.print("nombre de livre insuiffisant"+l.getDesign());
                    return;
                }
                preterService.add(new Preter(idpret,idpers,idlivre,datpres,dateRetour));
                new LivreDao().update(l);
                out.print("success");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
    }
     
     public static void putRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idpret=request.getParameter("idPret");
                String idpers=request.getParameter("idpers");
                String idlivre=request.getParameter("idlivre");
                LocalDateTime datpres=LocalDateTime.parse(request.getParameter("datePret"));
                LocalDate dateRetour=LocalDate.parse(request.getParameter("dateRetour"));
                PreterDao  preterService= new PreterDao();
              
                preterService.update(new Preter(idpret,idpers,idlivre,datpres,dateRetour));
                out.print("success");
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
    }
    
     
    public static void deleteRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idpret=request.getParameter("idPret");
                PreterDao  preterService= new PreterDao();
                preterService.delete(idpret);
                out.print("success"+idpret);
            }catch(Exception e){
                out.println("error: "+e.getMessage());
            }
    }
}
