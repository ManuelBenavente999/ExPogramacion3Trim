/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.sql.*;

/**
 *
 * @author manuel.benavente
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/biblio";
    private static final String USER = "root";
    private static final String PASS = ""; //Tu contraseña aquí
    
    //Constructor privado para evitar instancias
    private Conexion() {}
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
        }
    }
