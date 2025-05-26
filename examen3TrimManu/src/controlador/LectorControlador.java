package controlador;

import modelo.Lector;
import modelo.LectorDAO;
import java.util.Scanner;

public class LectorControlador {
    Scanner sc = new Scanner(System.in);
    LectorDAO dao = new LectorDAO();

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Lectores ---");
            System.out.println("1. Agregar Lector");
            System.out.println("2. Listar Lectores");
            System.out.println("3. Editar Lector");
            System.out.println("4. Eliminar Lector");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> editar();
                case 4 -> eliminar();
            }
        } while (opcion != 5);
    }

    private void agregar() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        dao.agregarLector(new Lector(0, nombre, email));
    }

    private void listar() {
        dao.listarLectores().forEach(lector ->
            System.out.println(lector.getId() + " | " + lector.getNombre() + " | " + lector.getEmail())
        );
    }

    private void editar() {
        System.out.print("ID del lector: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo email: ");
        String email = sc.nextLine();
        dao.editarLector(id, new Lector(id, nombre, email));
    }

    private void eliminar() {
        System.out.print("ID del lector: ");
        int id = Integer.parseInt(sc.nextLine());
        dao.eliminarLector(id);
    }
}
