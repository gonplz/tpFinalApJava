package com.tpFinalAp;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int idEquipo = 1;

        //Instancio la clase Equipo
        equipos equipo = new equipos();

        // Bucle para que el usuario elija una opción correcta.
        while (opcion != 1 && opcion != 2) {
            System.out.println("Ingrese 1 para consultar todos los equipos o 2 para consultar un equipo");
            opcion = sc.nextInt();

            //Condicional donde se le hace elegir al usuario en consola entre las opciones 1 o 2
            if (opcion == 1) {

                System.out.println(equipo.ConsultarTodosLosEquipos());

            } else if (opcion == 2) {

                //Bucle en donde se valida que el usuario coloque un número entre 1 y 14 para consultar o 15 para salir.
                while (idEquipo >= 1 && idEquipo <= 15) {

                    //Se pide al usuario que ingrese un equipo entre 1 y 14
                    System.out.println("Ingrese el ID del equipo (1-14) Ingrese 15 si desea salir:");
                    idEquipo = sc.nextInt();

                    //Condicional para romper el bucle en caso de colocar 15
                    if (idEquipo == 15) {
                        System.out.println("Gracias por consultar equipos.");
                        break;
                    } else if (idEquipo >= 1 && idEquipo < 15) {
                        String unEquipo = equipo.ConsultarUnEquipo(idEquipo);
                        System.out.println(unEquipo);
                    }
                }
            } else {
                System.out.println("Opción inválida, intente de nuevo");
            }
        }
    }
}