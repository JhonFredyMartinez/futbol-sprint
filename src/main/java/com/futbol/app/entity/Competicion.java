package com.futbol.app.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "competicion")
public class Competicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(length = 100)
    private String pais;

    private Integer anio;

    // Relación @ManyToMany: Muchas Competiciones tienen muchos Clubes
    @ManyToMany(mappedBy = "competiciones", fetch = FetchType.LAZY)
    private List<Club> clubes = new ArrayList<>();

    // Constructores
    public Competicion() {
    }

    public Competicion(Long id, String nombre, String tipo, String pais,
                      Integer anio, List<Club> clubes) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.pais = pais;
        this.anio = anio;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
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
        Competicion that = (Competicion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString excluyendo la relación clubes
    @Override
    public String toString() {
        return "Competicion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", pais='" + pais + '\'' +
                ", anio=" + anio +
                '}';
    }
}
