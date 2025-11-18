package com.futbol.app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(name = "fecha_fundacion")
    private LocalDate fechaFundacion;

    @Column(length = 100)
    private String estadio;

    // Relación @OneToOne: Un Club tiene un Entrenador
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    // Relación @ManyToOne: Muchos Clubes pertenecen a una Asociación
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asociacion_id", nullable = false)
    private Asociacion asociacion;

    // Relación @OneToMany: Un Club tiene muchos Jugadores
    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jugador> jugadores = new ArrayList<>();

    // Relación @ManyToMany: Un Club participa en muchas Competiciones
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "clubes_competiciones",
        joinColumns = @JoinColumn(name = "club_id"),
        inverseJoinColumns = @JoinColumn(name = "competicion_id")
    )
    private List<Competicion> competiciones = new ArrayList<>();

    // Constructores
    public Club() {
    }

    public Club(Long id, String nombre, String ciudad, LocalDate fechaFundacion,
               String estadio, Entrenador entrenador, Asociacion asociacion,
               List<Jugador> jugadores, List<Competicion> competiciones) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechaFundacion = fechaFundacion;
        this.estadio = estadio;
        this.entrenador = entrenador;
        this.asociacion = asociacion;
        this.jugadores = jugadores != null ? jugadores : new ArrayList<>();
        this.competiciones = competiciones != null ? competiciones : new ArrayList<>();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Asociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(Asociacion asociacion) {
        this.asociacion = asociacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Competicion> getCompeticiones() {
        return competiciones;
    }

    public void setCompeticiones(List<Competicion> competiciones) {
        this.competiciones = competiciones;
    }

    // equals y hashCode basados solo en id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(id, club.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString excluyendo las relaciones
    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                ", estadio='" + estadio + '\'' +
                '}';
    }
}
