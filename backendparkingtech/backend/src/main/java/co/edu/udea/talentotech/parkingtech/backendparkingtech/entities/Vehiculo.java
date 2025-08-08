package main.co.edu.udea.talentotech.parkingtech.backendparkingtech.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    
    @Id
    //@NotNull
    @Column(name = "idVehiculo", nullable = false)
    private Integer idVehiculo;

    @Size(max = 6)
    @Column(name = "placa", nullable = false, length = 6)
    private String placa;

    @Size(max = 5)
    @Column(name = "tipo", nullable = true, length = 5)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "vehiculo")
    private List<Reserva> reservas;

    public Vehiculo(){}

    public Vehiculo(Integer idVehiculo, String placa, String tipo){
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.tipo = tipo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculo [idVehiculo=" + idVehiculo + ", placa=" + placa + ", tipo=" + tipo + "]";
    }
}
