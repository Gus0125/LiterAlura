package com.aluracursos.literalura.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

//Record de nuestro libro que liga los datos de la API con nuestras variables
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id") Long id,
        @JsonAlias("title") String titulo,
        @JsonAlias("name") List<Autor> autor,
        @JsonAlias("lenguages") List<String> idioma,
        @JsonAlias("download_count") Long descargas) {
}
