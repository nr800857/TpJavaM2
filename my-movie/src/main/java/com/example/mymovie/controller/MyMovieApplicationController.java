package com.example.mymovie.controller;

import com.example.mymovie.beans.Acteur;
import com.example.mymovie.beans.Film;
import com.example.mymovie.beans.Personne;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Student Entity!!!!")
@RestController
public class MyMovieApplicationController {

    List<Personne> realisateurs = new ArrayList<Personne>();
    {
        realisateurs.add(new Personne("Marie", "Jean", "19/04/1980"));
    }
    List<Acteur> acteurs = new ArrayList<Acteur>();
    {
        acteurs.add(new Acteur("Jean", "Charles", "10/04/1978"));
        acteurs.add(new Acteur("Marine", "Dupont", "20/08/1985"));
        acteurs.add(new Acteur("Fabien", "Axel", "15/02/1990"));
    }
    List<Film> films = new ArrayList<Film>();
    {
        films.add(new Film("Titanic", realisateurs.get(0), acteurs.get(0), "1990"));
        films.add(new Film("Avatar", realisateurs.get(0), acteurs.get(2), "2009"));

    }


    @ApiOperation(value = "Avoir la liste des films dans le système ", response = Iterable.class, tags = "getFilms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succes"),
            @ApiResponse(code = 401, message = "Non autorisé"),
            @ApiResponse(code = 403, message = "Interdit"),
            @ApiResponse(code = 404, message = "Introuvable") })

    @RequestMapping(value = "/getFilms")
    public List<Film> getFilms() {

        return films;
    }

    @ApiOperation(value = "Avoir un film présent dans le système ", response = Film.class, tags = "getFilm")
    @RequestMapping(value = "/getFilm/{name}")
    public Film getFilm(@PathVariable(value = "name") String name) {
        for (Film f : films){
            if(f.getTitre().equals(name)){
                return f;
            }
        }
        return null;
    }

    @ApiOperation(value = "Avoir les film présent dans le système selon la date ", response = Film.class, tags = "getFilmByDate")
    @RequestMapping(value = "/getFilmByDate/{date}")
    public List<Film> getFilmByDate(@PathVariable(value = "date") String date) {
        List<Film> resu = new ArrayList<>();
        for (Film f : films){
            if(f.getSortie().equals(date)){
                resu.add(f);
            }
        }
        return resu;
    }

    @ApiOperation(value = "Avoir la liste des acteurs dans le système ", response = Iterable.class, tags = "getActeurs")
    @RequestMapping(value = "/getActeurs")
    public List<Acteur> getActeurs() {
        return acteurs;
    }

    @ApiOperation(value = "Avoir un acteur présent dans le système ", response = Acteur.class, tags = "getActeur")
    @RequestMapping(value = "/getActeur/{name}")
    public Acteur getActeur(@PathVariable(value = "name") String name) {
        for (Acteur a : acteurs){
            if(a.getNom().equals(name)){
                return a;
            }
        }
        return null;
    }

    @ApiOperation(value = "Avoir un acteur présent dans le système selon un film", response = Acteur.class, tags = "getActeurByFilm")
    @RequestMapping(value = "/getActeurByFilm/{name}")
    public List<Acteur> getActeurByFilm(@PathVariable(value = "name") String name) {
        List<Acteur> resu = new ArrayList<>();
        for (Acteur a : acteurs){
            for(Film f : a.getFilmographie()){
                if(f.getTitre().equals(name))
                    resu.add(a);
            }
        }
        return resu;
    }

}
