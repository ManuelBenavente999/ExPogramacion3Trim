/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.*;

/**
 *
 * @author manuel.benavente
 */
public class LibroDAO {

    private Connection conn;

    public LibroDAO() throws SQLException {
        conn = Conexion.getConnection();
    }

    // Crear producto
    public void agregar(Libro p) throws SQLException {
        String sql = "INSERT INTO producto(nombre, precio) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getTitulo());
        ps.setString(2, p.getAutor());
        ps.setDouble(3, p.getAnioPublicacion());
        ps.executeUpdate();
    }

    //Actualizar producto
    public void actualizar(Libro p) throws SQLException {
        String sql = "UPDATE producto SET nombre=?, precio=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getTitulo());
        ps.setString(2, p.getAutor());
        ps.setDouble(3, p.getAnioPublicacion());
        ps.executeUpdate();
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM producto WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    // Obtener todos los productos
    public List<Libro> listar() throws SQLException {
        List<Libro> lista = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM producto");
        while (rs.next()) {
            Libro p = new Libro();
            p.setId(rs.getInt("id"));
            p.setTitulo(rs.getString("Titulo"));
            p.setAutor(rs.getString("Autor"));
            p.setAnioPublicacion(rs.getInt("AnioPublicacion"));
        }
        return lista;
    }
}
