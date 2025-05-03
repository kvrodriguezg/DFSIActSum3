package com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.service.EnvioService;

import jakarta.validation.Valid;

import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.model.Envio;

@RestController
@RequestMapping("/envios")
@CrossOrigin(origins = "*")
public class EnvioController {

    //Se llama servicio
    @Autowired
    private EnvioService envioService;

    //Obtener todos los envios
    @GetMapping
    public List<Envio> getAllEnvios() {
        return envioService.getAllEnvios();
    }

    //Obtener un envio mediante su id
    @GetMapping("/{id}")
    public Optional<Envio> getEnvioById(@PathVariable Long id) {
        return envioService.getEnvioById(id);
    }

    //Crear un nuevo envio
    @PostMapping
    public Envio createEnvio(@RequestBody @Valid Envio envio) {
        return envioService.createEnvio(envio);
    }

    //Actualizar un envio
    @PutMapping("/{id}")
    public Envio updateEnvio(@PathVariable Long id, @RequestBody @Valid Envio envio) {
        return envioService.updateEnvio(id, envio);
    }

    //Eliminar un envio
    @DeleteMapping("/{id}")
    public void deleteEnvio(@PathVariable Long id) {
        envioService.deleteEnvio(id);
    }
}
