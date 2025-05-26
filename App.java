/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author manuel.benavente
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al programa calculador de calorias quemadas por Manuel Benavente");
        System.out.println("Indique su tiempo haciendo ejercicio en minutos");
        double minutos = scanner.nextDouble();
        boolean salir = false;
        while (!salir) {
            if (minutos <= 0) {
                System.out.println("Minutos negativos o 0, por favor arranque el programa de nuevo e introduzca minutos positivos");
                return;
            }
            System.out.println("\n+++++++ Calculadora de calorias calorias +++++++");
            System.out.println("0. Para salir de la calculadora de calorias");
            System.out.println("1. Calorias quemadas Corriendo");
            System.out.println("2. Calorias quemadas Caminando");
            System.out.println("3. Calorias quemadas haciendo Ciclismo");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 0:
                    salir = confirmarSalida(scanner);
                    break;
                case 1:
                    System.out.println("Usted ha elegido 'Corriendo'");
                    System.out.println("Sus minutos corriendo han sido: " + minutos);
                    double conversionCorrer = (minutos * 11.4);

                    System.out.println("Calorias totales quemadas: " + Math.round(conversionCorrer * 10) / 10);
                    break;
                case 2:
                    System.out.println("Usted ha elegido 'Caminando'");
                    System.out.println("Sus minutos corriendo han sido: " + minutos);
                    double conversionCaminar = (minutos * 5.4);
                    System.out.println("Calorias totales quemadas: " + Math.round(conversionCaminar * 10) / 10);
                    break;
                case 3:
                    System.out.println("Usted ha elegido 'Ciclismo'");
                    System.out.println("Sus minutos corriendo han sido: " + minutos);
                    double conversionCiclismo = (minutos * 8.5);
                    System.out.println("Calorias totales quemadas: " + Math.ceil(conversionCiclismo * 10) / 10);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        System.out.println("Gracias por usar la calculadora de calorias");
        scanner.close();
    }

    private static boolean confirmarSalida(Scanner scanner) {
        System.out.print("¿Está seguro de que quiere salir de la calculadora de calorias?? (s/n): ");
        char salirRespuesta = scanner.next().toLowerCase().charAt(0);
        return salirRespuesta == 's';

    }
}
