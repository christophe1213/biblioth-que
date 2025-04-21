/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class Membre {

    /**
     * @return the idpers
     */
    private String idpers="";
    private String nom="";
    private String sexe="";
    private int age=0;
    private String contact="";
    
    public Membre(){
        
    }
    public Membre(String id,String n,String s,int a,String c){
        idpers=id;
        nom=n;
        sexe=s;
        age=a;
        contact=c;
    }
    
    
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    
}
