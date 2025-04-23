
package Models;
import java.time.LocalDateTime;
public class Rendre {

    private String idRendu;
    private String idpers;
    private String idlivre;
    private LocalDateTime dateRendu;
    
    public Rendre(){
        
    }
    public Rendre(String id, String idp,String idL,LocalDateTime d){
        idRendu=id;
        idpers=idp;
        idlivre=idL;
        dateRendu=d;
    }
    
    /**
     * @return the idRendu
     */
    public String getIdRendu() {
        return idRendu;
    }

    /**
     * @param idRendu the idRendu to set
     */
    public void setIdRendu(String idRendu) {
        this.idRendu = idRendu;
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

    /**
     * @return the dateRendu
     */
    public LocalDateTime getDateRendu() {
        return dateRendu;
    }

    /**
     * @param dateRendu the dateRendu to set
     */
    public void setDateRendu(LocalDateTime dateRendu) {
        this.dateRendu = dateRendu;
    }
    
  
}
