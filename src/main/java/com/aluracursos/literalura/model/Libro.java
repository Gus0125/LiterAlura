package com.aluracursos.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Integer apiId;
    @Column(unique = true)
    private String titulo;
    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;
    @ManyToOne(cascade = CascadeType.ALL)
    private Idioma idioma;
    private Long descargas;

    public Libro() {}

    public Libro(LibroJson libroJson) {
        this.apiId = libroJson.id();
        this.titulo = libroJson.titulo();

        if (libroJson.autor() != null && !libroJson.autor().isEmpty()) {
            DatosAutor datosAutor = libroJson.autor().get(0);
            this.autor = new Autor(datosAutor);
        } else {
            this.autor = null;
        }

        if (libroJson.idioma() != null && !libroJson.idioma().isEmpty()) {
            this.idioma = new Idioma(new DatosIdioma(libroJson.idioma()));
        } else {
            this.idioma = null;
        }

        this.descargas = libroJson.descargas();
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Long getDescargas() {
        return descargas;
    }

    public void setDescargas(Long descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "********Libro********" +
                "\nID: " + (apiId != null ? apiId : "N/A") +
                "\nTítulo: " + (titulo != null ? titulo : "N/A") +
                "\nAutor: " + (autor != null ? autor.getNombre() : "N/A") +
                "\nIdioma: " + (idioma != null ? idioma.getSiglas() : "N/A") +
                "\nNúmero de descargas: " + (descargas != null ? descargas : "N/A");
    }
}
