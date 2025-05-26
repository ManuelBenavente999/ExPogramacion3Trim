package vista;

import controlador.LibroControlador;
import controlador.LectorControlador;
import java.util.Scanner;

public class MenuPrincipal {
    public void mostrar() {
        Scanner sc = new Scanner(System.in);
        LibroControlador libroCtrl = new LibroControlador();
        LectorControlador lectorCtrl = new LectorControlador();
        int opcion;
        do {
            System.out.println("\n=== Sistema de Biblioteca ===");
            System.out.println("1. Gestionar Libros");
            System.out.println("2. Gestionar Lectores");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> libroCtrl.menu();
                case 2 -> lectorCtrl.menu();
            }
        } while (opcion != 3);
        System.out.println("Saliendo de la biblioteca de Manuel Benavente.");
    }
}
