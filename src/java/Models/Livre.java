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
    private String idlivre="";
    
    private String design="";
    private int exemplaire=0;

    /**
     * @return the idlivre
     */
    public Livre(){
        
    }
    public Livre(String id, String d,int e){
        idlivre=id;
        design=d;
        exemplaire=e;
    }
    public String getIdlivre() {
        return idlivre;
    }

    /**
     * @param idlivre the idlivre to set
     */
    public void setIdlivre(String idlivre) {
        this.idlivre = idlivre;
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
