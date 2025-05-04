package com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnvioNotFoundException extends RuntimeException {

    public EnvioNotFoundException(String mensaje){
        super(mensaje);
    }
    
}
