/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Thierry Christophe
 */
public class Livre {

   
    private int idlivre=0;
    
    private String design="l";
    private String codelivre="";
    private int exemplaire=0;
    
    /**
     * @return the idlivre
     */
    public Livre(){
        
    }
    public Livre(int id,String c, String d,int e){
        idlivre=id;
        codelivre=c;
        design=d;
        exemplaire=e;
    }
     public Livre( String d,int e){
        design=d;
        exemplaire=e;
    }
    public int getIdLivre() {
        return idlivre;
    }

    /**
     * @param idlivre the idlivre to set
     */
    public void setIdLivre(int idlivre) {
        this.idlivre = idlivre;
    }
 /**
     * @return the codelivre
     */
    public String getCodeLivre() {
        return codelivre;
    }

    /**
     * @param codelivre the codelivre to set
     */
    public void setCodeLivre(String codelivre) {
        this.codelivre = codelivre;
    }
    
    /**
     * @return the design
     */
    public String getDesign() {
        return design;
    }

    /**
     * @param design the design to set
     */
    public void setDesign(String design) {
        this.design = design;
    }

    /**
     * @return the exemplaire
     */
    public int getExemplaire() {
        return exemplaire;
    }

    /**
     * @param exemplaire the exemplaire to set
     */
    public void setExemplaire(int exemplaire) {
        this.exemplaire = exemplaire;
    }
    
    
}
