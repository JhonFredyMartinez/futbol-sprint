package com.futbol.app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "asociacion")
public class Asociacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String pais;

    @Column(name = "fecha_fundacion")
    private LocalDate fechaFundacion;

    // Relación @OneToMany: Una Asociación tiene muchos Clubes
    @OneToMany(mappedBy = "asociacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Club> clubes = new ArrayList<>();

    // Constructores
    public Asociacion() {
    }

    public Asociacion(Long id, String nombre, String pais, LocalDate fechaFundacion,
                     List<Club> clubes) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.fechaFundacion = fechaFundacion;
        this.clubes = clubes != null ? clubes : new ArrayList<>();
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public List<Club> getClubes() {
        return clubes;
    }

    public void setClubes(List<Club> clubes) {
        this.clubes = clubes;
    }

    // equals y hashCode basados solo en id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asociacion that = (Asociacion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString excluyendo la relación clubes
    @Override
    public String toString() {
        return "Asociacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                '}';
    }
}
