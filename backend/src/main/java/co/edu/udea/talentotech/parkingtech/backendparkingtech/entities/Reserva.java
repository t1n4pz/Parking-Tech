// package co.edu.udea.talentotech.parkingtech.backendparkingtech.entities;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Size;
// import java.util.List;
// import java.util.Set;
// import java.util.Date;

// @Entity
// @Table(name = "reservas")
// public class Reserva {
    
//     @Id
//     //@NotNull
//     @Column(name = "idVehiculo", nullable = false)
//     private Integer idVehiculo;

//     @Column(name = "inicio", nullable = false)
//     private Date fechaInicio;

//     @Column(name = "final", nullable = false)
//     private Date fechaFinal;

//     @ManyToOne
//     @JoinColumn(name = "idUsuario")
//     private Usuario usuario;

//     @ManyToOne
//     @JoinColumn(name = "idCelda")
//     private Celda celda;

//     @ManyToOne
//     @JoinColumn(name = "idVehiculo")
//     private Vehiculo vehiculo;
// }
