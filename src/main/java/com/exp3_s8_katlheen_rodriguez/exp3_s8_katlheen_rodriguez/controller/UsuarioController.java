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

import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.service.UsuarioService;

import jakarta.validation.Valid;

import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.model.Usuario;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    //Se llama servicio
    @Autowired
    private UsuarioService usuarioService;

    //Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    //Obtener un usuario mediante su id
    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    //Crear un nuevo usuario
    @PostMapping
    public Usuario createUsuario(@RequestBody @Valid Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }

    //Actualizar un usuario
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        return usuarioService.updateUsuario(id, usuario);
    }

    //Eliminar un usuario
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

}