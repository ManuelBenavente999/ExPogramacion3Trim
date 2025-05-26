package modelo;

import util.Conexion;
import java.sql.*;
import java.util.*;

public class LectorDAO {
    public void agregarLector(Lector lector) {
        String sql = "INSERT INTO lectores (nombre, email) VALUES (?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lector.getNombre());
            stmt.setString(2, lector.getEmail());
            stmt.executeUpdate();
            System.out.println(" Lector agregado.");
        } catch (SQLException e) {
            System.out.println(" Error al agregar lector: " + e.getMessage());
        }
    }

    public List<Lector> listarLectores() {
        List<Lector> lista = new ArrayList<>();
        String sql = "SELECT * FROM lectores";
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Lector(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.out.println(" Error al listar lectores: " + e.getMessage());
        }
        return lista;
    }

    public void editarLector(int id, Lector lector) {
        String sql = "UPDATE lectores SET nombre=?, email=? WHERE id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lector.getNombre());
            stmt.setString(2, lector.getEmail());
            stmt.setInt(3, id);
            int filas = stmt.executeUpdate();
            System.out.println(filas > 0 ? " Lector actualizado." : "⚠️ No encontrado.");
        } catch (SQLException e) {
            System.out.println(" Error al editar lector: " + e.getMessage());
        }
    }

    public void eliminarLector(int id) {
        String sql = "DELETE FROM lectores WHERE id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            System.out.println(filas > 0 ? " Lector eliminado." : "⚠️ No encontrado.");
        } catch (SQLException e) {
            System.out.println(" Error al eliminar lector: " + e.getMessage());
        }
    }
}
