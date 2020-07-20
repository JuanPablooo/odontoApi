package com.toth.repository;

import com.toth.model.Usuario;
import com.toth.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<Dentista, Long> {

    Boolean existsByUsuario(Dentista professor);

    Dentista findByUsuario(Usuario usuario);
}
