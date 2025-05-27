/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Router;

import Controllers.RendreController;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Router.RendreRouter;

/**
 *
 * @author Thierry Christophe
 */
@WebServlet(name = "RendreRouter", urlPatterns = {"/Rendre/*"})
public class RendreRouter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RendreRouter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RendreRouter at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
          if(url.equals("/Bibliotheque/Rendre/get"))
           RendreController.getData(request, response);
       
          else if(url.equals("/Bibliotheque/Rendre")) {
              RendreController.get(request, response);
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
          if(url.equals("/Bibliotheque/Rendre/add"))
          RendreController.postRequest(request, response);
       
          else if(url.equals("/Bibliotheque/Rendre/delete")) {
              RendreController.deleteRequest(request, response);
          }
    }

    @Override
    protected void doPut (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           RendreController.putRequest(request, response);
    }
    
    @Override
    protected void doDelete (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RendreController.deleteRequest(request, response);
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
