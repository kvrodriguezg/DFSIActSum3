package com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.controller;

import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.model.Usuario;
import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.service.UsuarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioControllerTest {

    @Mock //Se crea un objeto falso (mock)
    private UsuarioService usuarioService;

    @InjectMocks //Se crea una instancia de UsuarioController y se inyecta el mock de UsuarioService;
    private UsuarioController usuarioController;

    //Se ejecuta antes de cada prueba
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //Prueba para crear un usuario
    @Test
    void testCrearUsuario() {
        //Crear usuario de prueba
        Usuario usuario = new Usuario();
        usuario.setNombre("Ana Pérez");
        usuario.setRut("12345678-9");
        usuario.setEmail("ana@gmail.com");
        usuario.setTelefono("+56912345678");
        usuario.setDireccion("Los Olmos 123");
        usuario.setClave("clavesecreta123");
        usuario.setMascota("Fido");

        //Simular que el servicio retorna el mismo usuario al guardarlo
        when(usuarioService.createUsuario(any(Usuario.class))).thenReturn(usuario);

        //Llamar al método del controller para crear un usuario
        Usuario result = usuarioController.createUsuario(usuario);

        //Verificar que el resultado este presente y coincidan los datos
        assertNotNull(result);
        assertEquals("Ana Pérez", result.getNombre());
        assertEquals("ana@gmail.com", result.getEmail());

        //Verificar que el servicio fue invocado una sola vez
        verify(usuarioService, times(1)).createUsuario(usuario);
    }
}
