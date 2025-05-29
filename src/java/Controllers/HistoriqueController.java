/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Databases;
import Models.Preter;
import Models.PreterDao;
import Models.Membre;
import Models.MembreDao;
import Models.Rendre;
import Models.RendreDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Thierry Christophe
 */
public class HistoriqueController {
     public static void getHistoriquePres(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
            List<Preter>prets = new ArrayList<Preter>();
            Membre membre =new Membre();
             try{
                 PrintWriter out = response.getWriter();
                 String id = request.getParameter("id");
                 if(id==null){
                     out.println("id not define");
                     return;
                 }
                 Databases.getConnecion();
                 membre= new MembreDao().getMembreByid(id);
                 prets = membre.getHistoriquePres();
                 
             }catch(Exception e){
                   System.out.println(e.getMessage());
                   e.printStackTrace();
             }finally{
                    request.setAttribute("prets", prets);
                    request.setAttribute("membre", membre);
                    request.getRequestDispatcher("/WEB-INF/View/HistoriquePret.jsp").forward(request, response);
                    Databases.closeConnection(); 
             }
        
    }
     
    public static void getHistoriqueRecu(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
              List<Rendre>rendus = new ArrayList<Rendre>();
             try{
                 PrintWriter out = response.getWriter();
                 String id = request.getParameter("id");
                 if(id==null){
                     out.println("id not define");
                     return;
                 }
                 Databases.getConnecion();
                 rendus = new MembreDao().getMembreByid(id).getHistoriqueRecu();
                 
             }catch(Exception e){
                   System.out.println(e.getMessage());
                   e.printStackTrace();
             }finally{
                    request.setAttribute("rendus", rendus);
                    request.getRequestDispatcher("/WEB-INF/components/Rendre/RendreView.jsp").forward(request, response);
                    Databases.closeConnection();
             }
    }
    
}
