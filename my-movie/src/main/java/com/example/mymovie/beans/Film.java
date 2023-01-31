package com.example.mymovie.beans;

public class Film {

    String titre;
    Personne realisateur;
    Acteur principal;
    String sortie;

    public Film(String titre, Personne realisateur, Acteur principal, String sortie) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.principal = principal;
        this.sortie = sortie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Personne getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Personne realisateur) {
        this.realisateur = realisateur;
    }

    public Acteur getPrincipal() {
        return principal;
    }

    public void setPrincipal(Acteur principal) {
        this.principal = principal;
    }

    public String getSortie() {
        return sortie;
    }

    public void setSortie(String sortie) {
        this.sortie = sortie;
    }
}
