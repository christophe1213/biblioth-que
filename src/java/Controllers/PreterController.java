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
import Models.Membre;
import Models.MembreDao;


public class PreterController {
    
    public static void getAdd(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
          
        List<Livre> livres = new ArrayList<Livre>(); 
        List<Membre> membres = new ArrayList<Membre>();    
        try{
            livres= new LivreDao().getAll();
            membres= new MembreDao().getAll();                                
         }catch(Exception e){
            System.out.println("error de "+e.getMessage());
            request.setAttribute("error", e.getMessage());
         }
        request.setAttribute("livres", livres);
        request.setAttribute("membres", membres);
        request.getRequestDispatcher("/WEB-INF/View/AjoutEmprunt.jsp").forward(request, response);
         
    } 
    public static void postRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter out = response.getWriter();
            try{              
                String idpret=request.getParameter("idPret");
                String idpers=request.getParameter("idpers");
                String idlivre=request.getParameter("idlivre");
                String nb=request.getParameter("nb");
                LocalDateTime datpres=LocalDateTime.parse(request.getParameter("datePret"));
                LocalDate dateRetour=LocalDate.parse(request.getParameter("dateRetour"));
                PreterDao  preterService= new PreterDao();
                String[] tab = idlivre.split(",");
                String [] Tabnb=nb.split(",");
                for(int i =0;tab.length>i;i++)
                {
                        Livre l = new LivreDao().getById(Integer.parseInt(tab[i]));
                
                        if(l.getExemplaire()-Integer.parseInt(Tabnb[i])<0){
                            out.print("nombre de livre insuiffisant"+l.getDesign());
                           return;
                        }
                    
                      //  out.print("success");

                }
                  for(int i =0;tab.length>i;i++)
                {
                        Livre l = new LivreDao().getById(Integer.parseInt(tab[i]));
                         
                          l.setExemplaire(l.getExemplaire()-Integer.parseInt(Tabnb[i]));
                          preterService.add(new Preter(idpret,idpers,tab[i],datpres,dateRetour,Integer.parseInt(Tabnb[i])));
                          new LivreDao().update(l);
                        

                        }
                        out.println("success");
                    

               
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
