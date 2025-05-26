package modelo;

import util.Conexion;
import java.sql.*;
import java.util.*;

public class LibroDAO {
    public void agregarLibro(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, anio_publicacion) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAnioPublicacion());
            stmt.executeUpdate();
            System.out.println(" Libro agregado.");
        } catch (SQLException e) {
            System.out.println(" Error al agregar libro: " + e.getMessage());
        }
    }

    public List<Libro> listarLibros() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("anio_publicacion")
                ));
            }
        } catch (SQLException e) {
            System.out.println(" Error al listar libros: " + e.getMessage());
        }
        return lista;
    }

    public void editarLibro(int id, Libro libro) {
        String sql = "UPDATE libros SET titulo=?, autor=?, anio_publicacion=? WHERE id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAnioPublicacion());
            stmt.setInt(4, id);
            int filas = stmt.executeUpdate();
            System.out.println(filas > 0 ? "✅ Libro actualizado." : "⚠️ Libro no encontrado.");
        } catch (SQLException e) {
            System.out.println("❌ Error al editar libro: " + e.getMessage());
        }
    }

    public void eliminarLibro(int id) {
        String sql = "DELETE FROM libros WHERE id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            System.out.println(filas > 0 ? "✅ Libro eliminado." : "⚠️ Libro no encontrado.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar libro: " + e.getMessage());
        }
    }
}
