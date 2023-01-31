package com.example.mymovie.beans;

import java.util.ArrayList;
import java.util.List;

public class Acteur extends Personne{

    private List<Film> filmographie;

    public Acteur(String nom, String preonm, String naissance) {
        super(nom, preonm, naissance);
        filmographie = new ArrayList<>();
    }

    public List<Film> getFilmographie() {
        return filmographie;
    }

    public void setFilmographie(List<Film> filmographie) {
        this.filmographie = filmographie;
    }

    public void addFilm(Film film){
        this.filmographie.add(film);
    }

}
