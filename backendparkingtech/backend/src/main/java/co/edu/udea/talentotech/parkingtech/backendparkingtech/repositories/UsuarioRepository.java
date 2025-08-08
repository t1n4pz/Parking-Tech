package main.co.edu.udea.talentotech.parkingtech.backendparkingtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import main.co.edu.udea.talentotech.parkingtech.backendparkingtech.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    // @Query("SELECT COUNT(u) > 0 FROM Usuario u WHERE u.usuario = :usuario AND u.clave = :clave")
    // boolean existsByUsuarioAndClave(@Param("usuario") String usuario, @Param("clave") String clave);

    Optional<Usuario> findByUsuarioAndClave(String usuario, String clave);
}
