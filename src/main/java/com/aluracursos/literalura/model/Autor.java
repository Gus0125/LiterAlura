package com.aluracursos.literalura.model;

import jakarta.persistence.*;

import java.util.List;

//Tabla Autor
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaDeNacimieto;
    private Integer fechaDeFallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(Autor autor) {}

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaDeNacimieto = datosAutor.nacimiento();
        this.fechaDeFallecimiento = datosAutor.fallecimiento();
    }

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

    public Integer getFechaDeNacimieto() {
        return fechaDeNacimieto;
    }

    public void setFechaDeNacimieto(Integer fechaDeNacimieto) {
        this.fechaDeNacimieto = fechaDeNacimieto;
    }

    public Integer getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(Integer fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(l ->l.setAutor(this));
        this.libros = libros;
    }

    @Override
    public String toString() {
        return
                "*****Autor*****" +
                "\n Nombre: " + nombre +
                "\n Fecha de Nacimiento: " + fechaDeNacimieto +
                "\n Fecha de Fallecimiento: " + fechaDeFallecimiento;
    }
}
