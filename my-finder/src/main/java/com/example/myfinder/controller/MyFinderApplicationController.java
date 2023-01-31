package com.example.myfinder.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyFinderApplicationController {

    @Autowired
    RestTemplate restTemplate;

    public String callMyMovie_Fallback() {
        return "Le service ne marche pas";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @ApiOperation(value = "Avoir la liste des films du ms my-movie ", response = Object.class, tags = "getFilms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succes"),
            @ApiResponse(code = 401, message = "Non autorisé"),
            @ApiResponse(code = 403, message = "Interdit"),
            @ApiResponse(code = 404, message = "Introuvable") })
    @HystrixCommand(fallbackMethod = "callMyMovie_Fallback")
    @RequestMapping(value = "/getFilms")
    public String getFilms() {
        String response = restTemplate
                .exchange("http://localhost:8010/getFilms"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }).getBody();

        return response;
    }

    @ApiOperation(value = "Avoir un film présent dans le système ", response = Object.class, tags = "getFilm")
    @HystrixCommand(fallbackMethod = "callMyMovie_Fallback")
    @RequestMapping(value = "/getFilm/{name}")
    public String getFilms(@PathVariable(value = "name") String name) {
        String response = restTemplate
                .exchange("http://localhost:8010/getFilms/{name}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, name).getBody();

        return response;
    }

    @ApiOperation(value = "Avoir les film présent dans le système selon la date ", response = Iterable.class, tags = "getFilmByDate")
    @HystrixCommand(fallbackMethod = "callMyMovie_Fallback")
    @RequestMapping(value = "/getFilmByDate/{date}")
    public String getFilmByDate(@PathVariable(value = "date") String date) {
        String response = restTemplate
                .exchange("http://localhost:8010/getFilmByDate/{date}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, date).getBody();

        return response;
    }

    @ApiOperation(value = "Avoir la liste des films du ms my-movie ", response = Object.class, tags = "getActeurs")
    @HystrixCommand(fallbackMethod = "callMyMovie_Fallback")
    @RequestMapping(value = "/getActeurs")
    public String getActeurs() {
        String response = restTemplate
                .exchange("http://localhost:8010/getActeurs"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }).getBody();

        return response;
    }

    @ApiOperation(value = "Avoir un acteur présent dans le système ", response = Acteur.class, tags = "getActeur")
    @HystrixCommand(fallbackMethod = "callMyMovie_Fallback")
    @RequestMapping(value = "/getActeur/{name}")
    public String getActeur(@PathVariable(value = "name") String name) {
        String response = restTemplate
                .exchange("http://localhost:8010/getActeur/{name}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, name).getBody();

        return response;
    }

    @ApiOperation(value = "Avoir un acteur présent dans le système selon un film", response = Acteur.class, tags = "getActeurByFilm")
    @HystrixCommand(fallbackMethod = "callMyMovie_Fallback")
    @RequestMapping(value = "/getActeurByFilm/{name}")
    public String getActeurByFilm(@PathVariable(value = "name") String name) {
        String response = restTemplate
                .exchange("http://localhost:8010/getActeurByFilm/{name}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, name).getBody();

        return response;
    }


}
