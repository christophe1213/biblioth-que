/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.OutputStream;

/**
 *
 * @author Thierry Christophe
 */
public class PdfRecu {
    
    public static void generateRecu() {
        Document document = new Document();
         try  {
           
             document.open();
            document.add(new Paragraph("Bonjour, ceci est un PDF généré avec iText 5."));
            document.add(new Paragraph("Relevet de note \n."));
            //document.add(new Paragraph("Relevet de note \n."));
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println("echec generate pdf ..");
        } finally {
            if(document.isOpen()){
                document.close();
                System.out.println("success generate");
            } 
               
            else System.out.println("error generate");
        }
    }
    
}
