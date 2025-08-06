package co.edu.talentotech.parkingtech.parkingtech.entities;

import jakarta.persistence.Entity;

@Entity
@Table(name = "celda")
public class Celda {
    
    @id
    //@NotNull
    @Column(name = "idCelda", nullable = false)
    private Integer idCelda;

    @Size(max = 10)
    @Column(name = "zona", nullable = false, length = 10)
    private String zona;

    @Column(name = "disponibilidad", nullable = false)
    private boolean disponibilidad;

    @OneToMany(mappedBy = "celda")
    private List<Reserva> reservas;

    Celda(){}

    Celda(Integer idCelda, String zona, boolean disponibilidad){
        this.idCelda = idCelda;
        this.zona = zona;
        this.disponibilidad = disponibilidad;
    }

    public Integer getIdCelda() {
        return idCelda;
    }

    public void setIdCelda(Integer idCelda) {
        this.idCelda = idCelda;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Celda [idCelda=" + idCelda + ", zona=" + zona + ", disponibilidad=" + disponibilidad + "]";
    }
}
