/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Models.Livre;
import Models.LivreDao;
/**
 *
 * @author Thierry Christophe
 */
public class DataLivre {
    public void main(String[] args) {
        Livre[] livres = new Livre[10];

        livres[0] = new Livre(1, "Programmation Java", 5);
        livres[1] = new Livre(2, "Bases de données", 3);
        livres[2] = new Livre(3, "Réseaux informatiques", 4);
        livres[3] = new Livre(4, "Systèmes d'exploitation", 6);
        livres[4] = new Livre(5, "Structures de données", 2);
        livres[5] = new Livre(6, "Algorithmique", 7);
        livres[6] = new Livre(7, "Programmation Web", 8);
        livres[7] = new Livre(8, "Sécurité informatique", 3);
        livres[8] = new Livre(9, "Machine Learning", 4);
        livres[9] = new Livre(10, "Intelligence Artificielle", 5);
        // Affichage des livres
        
        for (Livre livre : livres) {
            try{
                new LivreDao().update(livre);
            }catch(Exception e){
                System.out.println(e.getMessage());
                
                
            }
        }
    }
}
