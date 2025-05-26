/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import Models.LivreDao;
import Models.Livre;
import Models.Membre;
import Models.MembreDao;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.time.format.DateTimeFormatter;
/**
 *
 * @author Thierry Christophe
 */
@WebServlet(name = "RecuPret", urlPatterns = {"/RecuPret"})
public class RecuPret extends HttpServlet {

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
   //     response.setContentType("text/html;charset=UTF-8");
         response.setContentType("application/pdf");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RecuPret</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RecuPret at " + request.getContextPath() + "</h1>");
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
        Document document = new Document();
         try  {
                String idpret=request.getParameter("idPret");
                String idpers=request.getParameter("idpers");
                String idlivre=request.getParameter("idlivre");
          
                String nb=request.getParameter("nb");
                
                LocalDateTime datpres=LocalDateTime.parse(request.getParameter("datePret"));
                LocalDate dateRetour=LocalDate.parse(request.getParameter("dateRetour"));
             
                String[] tab = idlivre.split(",");
                String [] Tabnb=nb.split(",");
                Membre m= new MembreDao().getMembreByid(idpers);
                
                OutputStream out = response.getOutputStream();
                System.out.println("PDF generate ...");
                PdfWriter.getInstance(document, out);
                document.open();
                document.add(new Paragraph("Info membre:"));
                document.add(new Paragraph("Nom: "+m.getNom()));
                document.add(new Paragraph("Age : "+m.getAge()+" ans"));
                document.add(new Paragraph("sexe : "+m.getSexe()));
                document.add(new Paragraph("contact"+m.getContact()+"\n \n"));
                PdfPTable table = new PdfPTable(3);
                table.addCell(new PdfPCell(new Paragraph("Code Livre")));
                table.addCell(new PdfPCell(new Paragraph("Intitulé ")));
                table.addCell(new PdfPCell(new Paragraph("nombre preter")));
                for(int i =0;i<tab.length;i++){
                    
                    Livre l = new LivreDao().getById(Integer.parseInt(tab[i])) ;
                    table.addCell(addCell("L"));
                    table.addCell(addCell(l.getDesign()));
                    table.addCell(addCell(Tabnb[i]));
                    
                }
            
                document.add(table);
                
                document.add(new Paragraph("Prêté le : "+FormatDate.formatDMMMyyy(datpres)+"\n"));
                document.add(new Paragraph("Doit être rendu le :  "+FormatDate.formatDMMMyyy(dateRetour)+"\n"));
//document.add(new Paragraph("Relevet de note \n."));
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println("echec generate pdf ..");
        } catch (Exception ex) {
            Logger.getLogger(RecuPret.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(document.isOpen()){
                document.close();
                System.out.println("success generate");
            } 
               
            else System.out.println("error generate");
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
          response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"generated.pdf\""); 
        Document document = new Document();
         try  {
                
                String idpret=request.getParameter("idPret");
                String idpers=request.getParameter("idpers");
                String idlivre=request.getParameter("idlivre");
          
                String nb=request.getParameter("nb");
                
                LocalDateTime datpres=LocalDateTime.parse(request.getParameter("datePret"));
                LocalDate dateRetour=LocalDate.parse(request.getParameter("dateRetour"));
             
                String[] tab = idlivre.split(",");
                String [] Tabnb=nb.split(",");
                Membre m= new MembreDao().getMembreByid(idpers);
                
                OutputStream out = response.getOutputStream();
                System.out.println("PDF generate ...");
                PdfWriter.getInstance(document, out);
                document.open();
                document.add(new Paragraph("Info membre:"));
                document.add(new Paragraph("Nom: "+m.getNom()));
                document.add(new Paragraph("Age : "+m.getAge()+" ans"));
                document.add(new Paragraph("sexe : "+m.getSexe()));
                document.add(new Paragraph("contact"+m.getContact()+"\n \n"));
                PdfPTable table = new PdfPTable(3);
                table.addCell(new PdfPCell(new Paragraph("Code Livre")));
                table.addCell(new PdfPCell(new Paragraph("Intitulé ")));
                table.addCell(new PdfPCell(new Paragraph("nombre preter")));
                for(int i =0;i<tab.length;i++){
                    
                    Livre l = new LivreDao().getById(Integer.parseInt(tab[i])) ;
                    table.addCell(addCell("L"));
                    table.addCell(addCell(l.getDesign()));
                    table.addCell(addCell(Tabnb[i]));
                    
                }
            
                document.add(table);
                
                document.add(new Paragraph("Prêté le : "+FormatDate.formatDMMMyyy(datpres)+"\n"));
                document.add(new Paragraph("Doit être rendu le :  "+FormatDate.formatDMMMyyy(dateRetour)+"\n"));
//document.add(new Paragraph("Relevet de note \n."));
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println("echec generate pdf ..");
        } catch (Exception ex) {
            Logger.getLogger(RecuPret.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(document.isOpen()){
                document.close();
                System.out.println("success generate");
            } 
               
            else System.out.println("error generate");
        }
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
    
    private PdfPCell addCell(String texte){
        return new PdfPCell(new Paragraph(texte));
    }
    

}
