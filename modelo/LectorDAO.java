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
public class LectorDAO {

    private Connection conn;

    public LectorDAO() throws SQLException {
        conn = Conexion.getConnection();
    }

    // Crear producto
    public void agregar(Lector u) throws SQLException {
        String sql = "INSERT INTO usuario(nombre, email) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getEmail());
        ps.executeUpdate();
    }

    //Actualizar producto
    public void actualizar(Lector u) throws SQLException {
        String sql = "UPDATE usuario SET nombre=?, email=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getEmail());
        ps.setInt(3, u.getId());
        ps.executeUpdate();
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    // Obtener todos los productos
    public List<Lector> listar() throws SQLException {
        List<Lector> lista = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM usuario");
        while (rs.next()) {
            Lector u = new Lector();
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setEmail(rs.getString("email"));
        }
        return lista;
    }
}
