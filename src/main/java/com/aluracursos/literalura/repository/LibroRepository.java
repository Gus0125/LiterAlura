package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LibroRepository extends JpaRepository<Libro, Long> {
  boolean existsByTitulo(String nombre);
  Libro findByTituloContainsIgnoreCase(String nombre);
  @Query("SELECT l FROM Libro l WHERE LOWER(l.autor.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
  List<Libro> findByAutorNombre(@Param("nombre") String nombre);
}
