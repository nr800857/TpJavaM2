package com.example.mymovie.beans;

public class Personne {

    private String nom;
    private String preonm;
    private String naissance;

    public Personne(String nom, String preonm, String naissance) {
        this.nom = nom;
        this.preonm = preonm;
        this.naissance = naissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPreonm() {
        return preonm;
    }

    public void setPreonm(String preonm) {
        this.preonm = preonm;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }
}
