/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

public class Membre {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the numMembre
     */
    private int id;
    private String numMembre="";
    private String nom="";
    private String sexe="";
    private int age=4;
    private String contact="";
    private String email="";
    
    public Membre(){
        
    }
    public Membre(int i,String num,String n,String s,int a,String c,String e){
        id=i;
        numMembre=num;
        nom=n;
        sexe=s;
        age=a;
        contact=c;
        email=e;
    }
    
    public Membre(String n,String s,int a,String c,String e){
        nom=n;
        sexe=s;
        age=a;
        contact=c;
        email=e;
    }
    
    
    public List<Preter>getHistoriquePres() throws Exception {
        return new  PreterDao().select(" SELECT *  from  preter WHERE idpers='"+numMembre+"' order by datepret DESC");     
    }
    public List<Rendre>getHistoriqueRecu() throws Exception{
        return new RendreDao().select("SELECT *  from  rendre WHERE idpers='"+numMembre+"' order by daterendu DESC;");    
    }
    public String getNumMembre() {
        return numMembre;
    }

    /**
     * @param numMembre the numMembre to set
     */
    public void setNumMembre(String numMembre) {
        this.numMembre = numMembre;
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
