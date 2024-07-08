package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.DatosLibro;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.model.LibroJson;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.ConsumoApi;
import com.aluracursos.literalura.service.ConvierteDatos;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.*;

//Nuestra clase principal que muestra el menu y sus métodos para manejo de nuestros libros
public class Principal {



    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos conversor = new ConvierteDatos();
    private final LibroRepository repositorio;
    private final AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.repositorio = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void muestraMenu(){
        var opcion = -1;
        while (opcion!= 0){
            var menu = """
                    ***************************
                    **           Menú        **
                    ***************************
                    1.- Buscar libro por titulo
                    2.- Listar libros registrados
                    3.- Buscar por Autores registrados
                    4.- Buscar Autores vivos en un determinado año
                    5.- Buscar libros por idioma
                    0.- Salir
                    ****************************
                    """;
            System.out.println(menu);
            try {
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){

                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    buscarPorAutor();
                    break;
                case 4:
                    listarAutoresPorAno();
                    break;
                case 5:
                    menuIdiomas menuI = new menuIdiomas();
                    menuI.mostrarMenuIdiomas();
                    break;
                case 0:
                    System.out.println("Cerrando aplicación");
                    break;
                default:
                    System.out.println("Opción Invalida");
            }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                teclado.nextLine();
            }

        }

    }



    private DatosLibro  getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var titulo = teclado.nextLine().toLowerCase();
        var json = consumoApi.obtenerDatos(URL_BASE + titulo.replace(" ", "%20") );
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
       return datos;
    }

    private void buscarLibroWeb() {
        DatosLibro datos = getDatosLibro();
        if (datos.results().isEmpty()) {
            System.out.println("No se encontraron libros.");
            return;
        }
        LibroJson libroJson = datos.results().get(0);
        Libro libro = new Libro(libroJson);

        // Verificar si el libro ya existe en la base de datos
        if (repositorio.existsByTitulo(libro.getTitulo())) {
            System.out.println("El libro ya está registrado en la base de datos:");
            Libro libroExistente = repositorio.findByTituloContainsIgnoreCase(libro.getTitulo());
            System.out.println(libroExistente.toString());
        } else {
            // Guardar el libro en la base de datos
            repositorio.save(libro);
            System.out.println("El libro se ha guardado exitosamente:");
            System.out.println(libro.toString());
        }

    }

    private void listarLibros() {
        var libros = repositorio.findAll();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            int contador = 1; // Inicializamos un contador
            for (Libro libro : libros) {
                System.out.println("Coincidencia " + contador + "\n" + libro.toString());
                contador++;
            }
        }
    }

    private void buscarPorAutor() {
        System.out.println("Escribe el nombre del autor que deseas buscar");
        var nombreAutor = teclado.nextLine().toLowerCase();
        List<Libro> libros = repositorio.findByAutorNombre(nombreAutor);

        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros para el autor especificado.");
        } else {
            Autor autor = libros.get(0).getAutor(); // Todos los libros deberían tener el mismo autor
            System.out.println("*****Autor*****");
            System.out.println("Nombre: " + autor.getNombre());
            System.out.println("Fecha de Nacimiento: " + autor.getFechaDeNacimiento());
            System.out.println("Fecha de Fallecimiento: " + autor.getFechaDeFallecimiento());
            System.out.println("Libros:");
            libros.forEach(libro -> System.out.println(libro.toString()));
        }

    }

    private void listarAutoresPorAno() {
        System.out.println("Escribe el año que deseas buscar");
        int ano = teclado.nextInt();
        teclado.nextLine();

        List<Autor> autores = autorRepository.findAuthorsByYear(ano);

        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores vivos en el año especificado.");
        } else {
            System.out.println("Autores vivos en el año " + ano + ":");
            autores.forEach(autor -> {
                System.out.println("Nombre: " + autor.getNombre());
                System.out.println("Fecha de Nacimiento: " + autor.getFechaDeNacimiento());
                System.out.println("Fecha de Fallecimiento: " + autor.getFechaDeFallecimiento());
                System.out.println("------------------------------");
            });
        }
    }




}
