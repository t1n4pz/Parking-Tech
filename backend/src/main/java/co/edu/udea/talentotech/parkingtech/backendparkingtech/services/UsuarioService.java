package main.co.edu.udea.talentotech.parkingtech.backendparkingtech.services;

import main.co.edu.udea.talentotech.parkingtech.backendparkingtech.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    //Boolean findByUsuarioAndClave(String usuario, String clave);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean login(String usuario, String clave) {
        return usuarioRepository.findByUsuarioAndClave(usuario, clave).isPresent();
    }
}
