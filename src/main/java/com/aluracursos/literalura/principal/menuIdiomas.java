package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.Idioma;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.IdiomaRepository;
import com.aluracursos.literalura.repository.LibroRepository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class menuIdiomas {

    private final IdiomaRepository idiomaRepository;
    private final LibroRepository libroRepository;
    private static Scanner teclado = new Scanner(System.in);

    public menuIdiomas(IdiomaRepository idiomaRepository, LibroRepository libroRepository) {
        this.idiomaRepository = idiomaRepository;
        this.libroRepository = libroRepository;
    }

    public void mostrarMenuIdiomas() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = new StringBuilder("""
                    ***************************
                    **       Menú Idiomas    **
                    ***************************
                    """);

            // Utilizar un Set para evitar duplicados
            Set<String> idiomas = idiomaRepository.findAll().stream()
                    .map(Idioma::getSiglas)
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            int index = 1;
            for (String sigla : idiomas) {
                menu.append(String.format("%d.- %s\n", index++, sigla));
            }
            menu.append("0.- Regresar Menú Principal\n");
            menu.append("***********************\n");
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 0) {
                return;
            } else if (opcion > 0 && opcion <= idiomas.size()) {
                String idiomaSeleccionado = idiomas.stream().skip(opcion - 1).findFirst().orElse(null);
                if (idiomaSeleccionado != null) {
                    mostrarLibrosPorIdioma(idiomaSeleccionado);
                }
            } else {
                System.out.println("Opción Inválida");
            }
        }
    }

    private void mostrarLibrosPorIdioma(String siglas) {
        List<Libro> libros = libroRepository.findByIdiomaSiglas(siglas);
        if (libros.isEmpty()) {
            System.out.printf("No hay libros disponibles en %s\n", siglas);
        } else {
            System.out.printf("Libros disponibles en %s:\n", siglas);
            libros.forEach(libro -> System.out.println(libro.toString()));
        }
    }
}
