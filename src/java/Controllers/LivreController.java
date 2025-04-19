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
import java.util.ArrayList;
import  java.util.List;
/**
 *
 * @author Thierry Christophe
 */
public class LivreController {
     
    public static void getRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             List<Livre> livres = new ArrayList<Livre>(); 
            try{
                livres= new LivreDao().getAll();                
             }catch(Exception e){
                 System.out.println("error de "+e.getMessage());
                 request.setAttribute("error", e.getMessage());
             }
             request.setAttribute("livres", livres);
             request.getRequestDispatcher("/WEB-INF/View/LivreView.jsp").forward(request, response);
     
    }
}
