package com.aluracursos.literalura.principal;

import java.util.Scanner;

public class menuIdiomas {

    private static Scanner teclado = new Scanner(System.in);

    public static void mostrarMenuIdiomas(){
        var opcion = -1;
        while (opcion!= 0){
            var menu = """
                    ***************************
                    **       Menú Idiomas    **
                    ***************************
                    1.- en - Inglés
                    2.- es - Español
                    3.- fr - Francés
                    4.- por - Portugues
                    0.- Regresar Menú Principal
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){

                case 1:
                    System.out.println("Inglés");
                    break;
                case 2:
                    System.out.println("Español");
                    break;
                case 3:
                    System.out.println("Francés");
                    break;
                case 4:
                    System.out.println("Portugués");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción Invalida");
            }

        }

    }
}
