/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Router;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Controllers.LivreController;
/**
 *
 * @author Thierry Christophe
 */
@WebServlet(name = "LivreRouter", urlPatterns = {"/Livre/*"})
public class LivreRouter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url=request.getRequestURI();
       if(url.equals("/Bibliotheque/Livre/get"))
            //MembreController.postRequest(request, response);
           LivreController.getDataRequest(request, response);
       else {
            LivreController.get(request, response);       
       }     
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url=request.getRequestURI();
       if(url.equals("/Bibliotheque/Livre/add"))
          LivreController.postRequest(request, response);
       else if(url.equals("/Bibliotheque/Livre/update")) {
            //LivreController.get(request, response);  
            LivreController.putRequest(request, response);
       }else if(url.equals("/Bibliotheque/Livre/delete")) {
           
           LivreController.deleteRequest(request, response);
       }    
       else {
            PrintWriter out = response.getWriter();
            out.println("error request ");
       } 
       
    }
    @Override
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        LivreController.putRequest(request, response);
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         LivreController.deleteRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
