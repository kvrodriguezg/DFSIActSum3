package com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.service;
import java.util.List;
import java.util.Optional;
import com.exp3_s8_katlheen_rodriguez.exp3_s8_katlheen_rodriguez.model.Usuario;

public interface UsuarioService {

    //Metodos a utilizar
    List<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioById(Long id);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(Long id,Usuario usuario);
    void deleteUsuario(Long id);
}
