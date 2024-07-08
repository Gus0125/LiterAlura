Proyecto LiterAlura
Descripción
El proyecto LiterAlura es una aplicación Java que permite gestionar una colección de libros utilizando una base de datos. La aplicación permite buscar libros por título a través de la API de Gutendex, listar libros registrados, buscar libros por autor, listar autores vivos en un determinado año y listar libros por idioma. La aplicación utiliza Spring Boot para la gestión de dependencias y la configuración de la aplicación, JPA/Hibernate para la persistencia de datos y la API de Gutendex para obtener información de libros.

Requisitos
Java 17 o superior
Maven 3.6.0 o superior
PostgreSQL 12 o superior

Funcionalidades
Menú Principal
El menú principal ofrece las siguientes opciones:

Buscar libro por título: Permite buscar libros por título utilizando la API de Gutendex.
Listar libros registrados: Lista todos los libros registrados en la base de datos.
Buscar por autor: Permite buscar libros por autor.
Listar autores vivos en un determinado año: Lista los autores que estaban vivos en un año específico.
Listar libros por idioma: Muestra un menú de idiomas y lista los libros disponibles en el idioma seleccionado.
Salir: Cierra la aplicación.

Menú Idiomas
El menú de idiomas se genera dinámicamente a partir de los datos almacenados en la base de datos y evita duplicados. Al seleccionar un idioma, se muestran todos los libros disponibles en ese idioma.

Ejemplo de Uso

Buscar Libro por Título
Seleccione la opción 1 en el menú principal.
Ingrese el título del libro que desea buscar.
La aplicación buscará el libro en la API de Gutendex y mostrará los resultados.

Listar Libros Registrados
Seleccione la opción 2 en el menú principal.
La aplicación listará todos los libros registrados en la base de datos.

Buscar por Autor
Seleccione la opción 3 en el menú principal.
Ingrese el nombre del autor que desea buscar.
La aplicación mostrará la información del autor y la lista de sus libros.

Listar Autores Vivos en un Determinado Año
Seleccione la opción 4 en el menú principal.
Ingrese el año que desea buscar.
La aplicación listará todos los autores que estaban vivos en ese año.

Listar Libros por Idioma
Seleccione la opción 5 en el menú principal.
Seleccione el idioma deseado del menú de idiomas.
La aplicación mostrará todos los libros disponibles en el idioma seleccionado.
