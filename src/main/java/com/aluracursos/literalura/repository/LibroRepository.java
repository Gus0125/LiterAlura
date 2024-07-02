package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
   Optional<Libro> findTituloByTituloContainsIgnoreCase(String nombre);
}