package com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.model.Envio;
import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.service.EnvioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class EnvioControllerTest {

    @Mock //Se crea un objeto falso (mock)
    private EnvioService envioService;

    @InjectMocks //Se crea una instancia de EnvioController y se inyecta el mock de EnvioService
    private EnvioController envioController;

    //Se ejecuta antes de cada prueba
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); //Inicializa los mocks
    }

    //Prueba para obtener un envio por su id
    @Test
    void testGetEnvioById() {
        //Crear un Envio de prueba
        Envio envio = new Envio(
            "Lima",
            "Bogotá",
            LocalDate.of(2025, 5, 1),
            "En camino",
            "Centro de distribución Lima",
            LocalDate.of(2025, 5, 10)
        );
        //Setear el id
        envio.setId(1L);

        //Configurar el mock para retornar ese Envio
        when(envioService.getEnvioById(1L)).thenReturn(Optional.of(envio));

        //Llamar al método del controlador
        Optional<Envio> resultado = envioController.getEnvioById(1L);

        //Verificar que el resultado esté presente y tenga datos correctos
        assertTrue(resultado.isPresent());
        assertEquals("Lima", resultado.get().getOrigen());
        assertEquals("Bogotá", resultado.get().getDestino());
        assertEquals("En camino", resultado.get().getEstado());
    }
}

