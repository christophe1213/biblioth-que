/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Preter {

    /**
     * @return the nb
     */
    public int getNb() {
        return nb;
    }

    /**
     * @param nb the nb to set
     */
    public void setNb(int nb) {
        this.nb = nb;
    }


    private String idPret;
    private String idpers;
    private String idlivre;
    private LocalDateTime datePres;
    private LocalDate dateRetour;
    private int nb;
    public Preter(){
        
    }
    public Preter(String idP, String idPers,String idLivre, LocalDateTime dp,LocalDate dr,int n ){
        idPret=idP;
        idpers=idPers;
        idlivre=idLivre;
        datePres=dp;
        dateRetour=dr;
        nb=n;
        
    }
    /**
     * @return the idPret
     */
    public String getIdPret() {
        return idPret;
    }

    /**
     * @param idPret the idPret to set
     */
    public void setIdPret(String idPret) {
        this.idPret = idPret;
    }

    /**
     * @return the idpers
     */
    public String getIdpers() {
        return idpers;
    }

    /**
     * @param idpers the idpers to set
     */
    public void setIdpers(String idpers) {
        this.idpers = idpers;
    }

    /**
     * @return the datePres
     */
        /**
     * @return the idlivre
     */
    public String getIdlivre() {
        return idlivre;
    }

    /**
     * @param idlivre the idlivre to set
     */
    public void setIdlivre(String idlivre) {
        this.idlivre = idlivre;
    }
    public LocalDateTime getDatePres() {
        return datePres;
    }

    /**
     * @param datePres the datePres to set
     */
    public void setDatePres(LocalDateTime datePres) {
        this.datePres = datePres;
    }

    /**
     * @return the dateRetour
     */
    public LocalDate getDateRetour() {
        return dateRetour;
    }

    /**
     * @param dateRetour the dateRetour to set
     */
    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    
    
}
