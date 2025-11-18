package com.futbol.app.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "entrenador")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(length = 100)
    private String nacionalidad;

    @Column(name = "experiencia_anios")
    private Integer experienciaAnios;

    // Relación @OneToOne: Un Entrenador puede estar en un Club
    @OneToOne(mappedBy = "entrenador", fetch = FetchType.LAZY)
    private Club club;

    // Constructores
    public Entrenador() {
    }

    public Entrenador(Long id, String nombre, String apellido, String nacionalidad,
                     Integer experienciaAnios, Club club) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.experienciaAnios = experienciaAnios;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getExperienciaAnios() {
        return experienciaAnios;
    }

    public void setExperienciaAnios(Integer experienciaAnios) {
        this.experienciaAnios = experienciaAnios;
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
        Entrenador that = (Entrenador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString excluyendo la relación club
    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", experienciaAnios=" + experienciaAnios +
                '}';
    }
}
