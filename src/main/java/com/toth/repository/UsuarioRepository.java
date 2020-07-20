package com.toth.repository;

import java.util.Optional;

import com.toth.model.Usuario;

import org.codehaus.plexus.component.annotations.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String login);

    Boolean existsByLogin(String login);

}
