package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

public record DatosIdioma(
        @JsonAlias("languages") List<String> idiomas) {
}
