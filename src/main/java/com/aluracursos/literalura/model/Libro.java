package com.aluracursos.literalura.model;


import jakarta.persistence.*;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

//Clase Libro hecho tabla
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
    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Idioma idioma;
    private Long descargas;

    public Libro(){}

    public Libro(DatosLibro datosLibros) {
        this.apiId = datosLibros.id();
        this.titulo = datosLibros.titulo();
        System.out.println((titulo));
        if (datosLibros.autor() != null && !datosLibros.autor().isEmpty()) {
            this.autor = datosLibros.autor().get(0);
        } else {
            this.autor = null; // Caso en que no haya autor
        }
        if (datosLibros.idioma() != null && !datosLibros.idioma().isEmpty()) {
            this.idioma = new Idioma(new DatosIdioma(datosLibros.idioma()));
        } else {
            this.idioma = null; // Caso en que no haya idioma
        }
        this.descargas = datosLibros.descargas();

    }

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
        return"********Libro********" +
                "\nID: " + (apiId != null ? apiId : "N/A") +
                "\nTítulo: " + (titulo != null ? titulo : "N/A") +
                "\nAutor: " + (autor != null ? autor.getNombre() : "N/A") +
                "\nIdioma: " + (idioma != null ? idioma.getSiglas() : "N/A") +
                "\nNúmero de descargas: " + (descargas != null ? descargas : "N/A");

    }
}
