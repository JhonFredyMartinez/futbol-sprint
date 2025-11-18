package com.futbol.app.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, length = 50)
    private String posicion;

    @Column(name = "numero_camiseta")
    private Integer numeroCamiseta;

    @Column(length = 100)
    private String nacionalidad;

    private Integer edad;

    // Relación @ManyToOne: Muchos Jugadores pertenecen a un Club
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_club")
    private Club club;

    // Constructores
    public Jugador() {
    }

    public Jugador(Long id, String nombre, String apellido, String posicion,
                   Integer numeroCamiseta, String nacionalidad, Integer edad, Club club) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.numeroCamiseta = numeroCamiseta;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.club = club;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(Integer numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    // equals y hashCode basados solo en id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(id, jugador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString excluyendo la relación club
    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", posicion='" + posicion + '\'' +
                ", numeroCamiseta=" + numeroCamiseta +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", edad=" + edad +
                '}';
    }
}
