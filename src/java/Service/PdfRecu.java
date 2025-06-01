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
import Models.Membre;
import Models.MembreDao;
import Models.PreterDao;
import Models.Preter;
import Models.Databases;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
/**
 *
 * @author Thierry Christophe
 */
public class PdfRecu {
    private Membre membre =null;
    private List<Preter> preters;
    private OutputStream out;
    private Document document;
    private LocalDateTime datpres=null;
    private LocalDate dateRetour=null;
    public PdfRecu(OutputStream o){
        out=o;
        document = new Document();
    }
    
    public void setMembre(String idMembre){
        Databases.getConnecion();
        membre= new MembreDao().getMembreByid(idMembre);
        System.out.println("idpers ::"+idMembre);
        Databases.closeConnection();
    }
    public void setPreter(String idPreter) throws Exception{
        Databases.getConnecion();
        preters= new PreterDao().select("select  * from preter where idpret='"+idPreter+"'");
        datpres=preters.getFirst().getDatePres();
        dateRetour=preters.getFirst().getDateRetour();
        membre=preters.getFirst().membre;
        Databases.closeConnection();
    }
    public  void generateRecu() {
          if(preters==null){
              System.out.println("list de livres prêtetr est null");
              return;
          }
        
         try  {
           PdfWriter.getInstance(document, out);
            document.open();
           
            document.add(addParagraph("Info membre:"));
            document.add(addParagraph("Nom: "+membre.getNom()));
            document.add(addParagraph("Age : "+membre.getAge()+" ans"));
            document.add(addParagraph("sexe : "+membre.getSexe()));
            document.add(addParagraph("contact : "+membre.getContact()+"\n \n"));
        
            
            PdfPTable table = new PdfPTable(3);
            table.addCell(new PdfPCell(new Paragraph("Code Livre")));
            table.addCell(new PdfPCell(new Paragraph("Intitulé ")));
            table.addCell(new PdfPCell(new Paragraph("nombre preter")));
            
         
              
            for(Preter pret:preters){
                table.addCell(addCell(pret.livre.getCodeLivre()));
                table.addCell(addCell(pret.livre.getDesign()));
                table.addCell(addCell(pret.getNb()));
            }
            document.add(table);
             
            document.add(addParagraph("Prêté le : "+FormatDate.formatDMMMyyy(datpres)+"\n"));
           document.add(addParagraph("Doit être rendu le :  "+FormatDate.formatDMMMyyy(dateRetour)+"\n"));
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
    
    private Paragraph addParagraph(String t){
        return new Paragraph(t);
    }
    private PdfPCell addCell(String texte){
        return new PdfPCell(new Paragraph(texte));
    }
    private PdfPCell addCell(int texte){
        return new PdfPCell(new Paragraph(Integer.toString(texte)));
    }
    
}
