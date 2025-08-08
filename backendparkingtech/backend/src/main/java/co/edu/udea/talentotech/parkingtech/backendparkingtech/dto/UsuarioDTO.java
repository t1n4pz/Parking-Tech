package main.co.edu.udea.talentotech.parkingtech.backendparkingtech.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import main.co.edu.udea.talentotech.parkingtech.backendparkingtech.entities.Usuario;

public class UsuarioDTO {
    
    private Integer idUsuario;

    @NotBlank(message = "El usuario es obligatorio")
    @Size(max = 10, message = "El usuario no puede tener más de 10 caracteres")
    private String usuario;

    @NotBlank(message = "La clave es obligatoria")
    @Size(max = 10, message = "La clave no puede tener más de 10 caracteres")
    private String clave;

    public UsuarioDTO(){}

    public UsuarioDTO(String usuario, String clave){
        this.usuario = usuario;
        this.clave = clave;
    }

    public UsuarioDTO(Usuario usuario){
        this.idUsuario = usuario.getIdUsuario();
        this.usuario = usuario.getUsuario();
        this.clave = usuario.getClave();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "UsuarioDTO [idUsuario=" + idUsuario + ", usuario=" + usuario + ", clave=" + clave + "]";
    }
}
