package com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.repository;

import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuarioGuardado;

    //Antes de cada prueba
    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();
        //Guardamos un nuevo usuario
        Usuario usuario = new Usuario(null, "Laura Soto", "laura@gmail.com", "12345678-5", "+56912345678", "Los Aromos 456", "claveabc", "Pelusa");
        usuarioGuardado = usuarioRepository.save(usuario);
    }

    //Despues de cada prueba
    @AfterEach
    void tearDown() {
        usuarioRepository.deleteAll();
    }

    //Prueba de obtener un usuario por su id
    @Test
    void testObtenerUsuarioPorId() {

        //Se obtiene el usuario por su id
        Optional<Usuario> resultado = usuarioRepository.findById(usuarioGuardado.getId());

        //Se verifica este presente
        assertTrue(resultado.isPresent());

        //Se verifica el nombre coincida con el objeto inicial
        assertEquals("Laura Soto", resultado.get().getNombre());
    }

    //Prueba para actualizar un usuario
    @Test
    void testActualizarUsuario() {

        //Se actualizan los datos del usuario inicial
        usuarioGuardado.setNombre("Laura Soto Perez");
        usuarioGuardado.setTelefono("+56987654321");

        //Se guardan
        Usuario actualizado = usuarioRepository.save(usuarioGuardado);

        //Se obtiene el usuario nuevamente por id
        Optional<Usuario> resultado = usuarioRepository.findById(actualizado.getId());

        //Se verifica si el resultado esta presente y si los datos coinciden con los actualizados
        assertTrue(resultado.isPresent());
        assertEquals("Laura Soto Perez", resultado.get().getNombre());
        assertEquals("+56987654321", resultado.get().getTelefono());
    }
}