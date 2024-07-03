package com.aluracursos.literalura.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "idioma")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String siglas;
    @OneToMany(mappedBy = "idioma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Libro> libros;


    public Idioma() {}

    public Idioma(DatosIdioma idioma) {

        if (idioma.idiomas() != null && !idioma.idiomas().isEmpty()) {
            this.siglas = idioma.idiomas().get(0);
        } else {
            this.siglas = null;
        }
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(e -> e.setIdioma(this));
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "***Idioma***:" + "\n    Siglas: " + siglas +
                "\n    Libros: " + libros;
    }
}
