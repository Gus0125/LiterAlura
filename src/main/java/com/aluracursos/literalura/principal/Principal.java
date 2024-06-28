package com.aluracursos.literalura.principal;

import java.util.Scanner;

public class Principal {


    private Scanner teclado = new Scanner(System.in);

    public void muestraMenu(){
        var opcion = -1;
        while (opcion!= 0){
            var menu = """
                    ***************************
                    **           Menú        **
                    ***************************
                    1.- Buscar libro por titulo
                    2.- Listar libros registrados
                    3.- Listar Autores registrados
                    4.- Listar Autores vivos en un determinado año
                    5.- Listar libros por idioma
                    0.- Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){

                case 1:
                    System.out.println("Caso 1");
                    break;
                case 2:
                    System.out.println("Caso 2");
                    break;
                case 3:
                    System.out.println("Caso 3");
                    break;
                case 4:
                    System.out.println("Caso 4");
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

        }

    }


}
