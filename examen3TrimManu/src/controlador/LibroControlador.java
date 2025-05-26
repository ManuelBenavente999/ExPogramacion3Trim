package controlador;

import modelo.Libro;
import modelo.LibroDAO;
import java.util.Scanner;

public class LibroControlador {
    Scanner sc = new Scanner(System.in);
    LibroDAO dao = new LibroDAO();

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Libros ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Listar Libros");
            System.out.println("3. Editar Libro");
            System.out.println("4. Eliminar Libro");
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
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Anio Publicacion: ");
        int anio = Integer.parseInt(sc.nextLine());
        dao.agregarLibro(new Libro(0, titulo, autor, anio));
    }

    private void listar() {
        dao.listarLibros().forEach(libro ->
            System.out.println(libro.getId() + " | " + libro.getTitulo() + " | " + libro.getAutor() + " | " + libro.getAnioPublicacion())
        );
    }

    private void editar() {
        System.out.print("ID del libro: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo título: ");
        String titulo = sc.nextLine();
        System.out.print("Nuevo autor: ");
        String autor = sc.nextLine();
        System.out.print("Nuevo anio de publicacion: ");
        int anio = Integer.parseInt(sc.nextLine());
        dao.editarLibro(id, new Libro(id, titulo, autor, anio));
    }

    private void eliminar() {
        System.out.print("ID del libro: ");
        int id = Integer.parseInt(sc.nextLine());
        dao.eliminarLibro(id);
    }
}
