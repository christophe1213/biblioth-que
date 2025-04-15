/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Thierry Christophe
 */
public class LivreController {
     
    public static void getRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             request.getRequestDispatcher("/WEB-INF/View/LivreView.jsp").forward(request, response);
       
    }
}
