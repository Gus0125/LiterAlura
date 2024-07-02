package com.aluracursos.literalura.model;


import jakarta.persistence.*;
//Clase Libro hecho tabla
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long apiId;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Idioma idioma;
    private Long descargas;

    public Libro(){}

    public Libro(DatosLibro datosLibros) {
        this.apiId = datosLibros.id();
        this.titulo = datosLibros.titulo();
        if (datosLibros.autor() != null && !datosLibros.autor().isEmpty()) {
            this.autor = new Autor(datosLibros.autor().get(0)); // Toma el primer autor de la lista
        } else {
            this.autor = null; // Caso en que no haya autor
        }
        this.idioma = new Idioma(new DatosIdioma(datosLibros.idioma()));
        this.descargas = datosLibros.descargas();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
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
        return
                "********Libro********" +
                "\nID: " + apiId +
                "\nTítulo: " + titulo +
                "\nAutor: " + autor.getNombre() +
                "\nIdioma: " + idioma.getSiglas() +
                "\nNúmero de descargas: " + descargas;

    }
}
