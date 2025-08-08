package main.co.edu.udea.talentotech.parkingtech.backendparkingtech.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    //@NotNull
    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

    // @NotNull
    @Column(name = "cedula", nullable = false)
    private Integer cedula;
    
    @Size(max = 30)
    @Column(name = "nombre", nullable = true, length = 30)
    private String nombre;

    @Size(max = 30)
    @Column(name = "correo", nullable = true, length = 30)
    private String correo;

    // @NotNull
    @Size(max = 10)
    @Column(name = "usuario", nullable = false, length = 10)
    private String usuario;

    // @NotNull
    @Size(max = 10)
    @Column(name = "clave", nullable = false, length = 10)
    private String clave;

    @OneToMany(mappedBy="Usuario")
    private Set<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

    //Constructors
    public Usuario(){}

    public Usuario(Integer idUsuario, Integer cedula, String nombre, String correo, String usuario, String clave){
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        return "Usuario [idUsuario=" + idUsuario + ", cedula=" + cedula + ", nombre=" + nombre + ", correo=" + correo
                + ", usuario=" + usuario + ", clave=" + clave + "]";
    }
}
