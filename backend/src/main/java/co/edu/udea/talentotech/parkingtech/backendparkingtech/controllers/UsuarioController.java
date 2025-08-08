package co.edu.udea.talentotech.parkingtech.backendparkingtech.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import co.edu.udea.talentotech.parkingtech.backendparkingtech.dto.UsuarioDTO;
import co.edu.udea.talentotech.parkingtech.backendparkingtech.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    // @GetMapping("/{usuario}/{clave}")
    // public ResponseEntity<Boolean> login(
    //         @PathVariable String usuario, 
    //         @PathVariable String clave) {
    //     try {
    //         return usuarioService.login(usuario, clave);
    //     } catch(Exception e) {
    //         return false;
    //     }
    // }

    @PostMapping("/login")
    public boolean login(@RequestBody UsuarioDTO usuarioDto) {
        return usuarioService.login(usuarioDto.getUsuario(), usuarioDto.getClave());
    }
}
