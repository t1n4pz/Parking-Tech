package co.edu.talentotech.parkingtech.entites;

import jakarta.persistence.Entity;

@Entity
@Table(name = "reservas")
public class Reserva {
    
    @id
    //@NotNull
    @Column(name = "idVehiculo", nullable = false)
    private Integer idVehiculo;

    @Column(name = "inicio", nullable = false)
    private date fechaInicio;

    @Column(name = "final", nullable = false)
    private date fechaFinal;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idVehiculo")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "idCelda")
    private Celda celda;
}
