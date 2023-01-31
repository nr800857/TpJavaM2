package com.example.myfinder.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
}
