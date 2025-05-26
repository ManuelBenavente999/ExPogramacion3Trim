/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import modelo.*;
import vista.*;
import java.util.List;
import java.sql.*;

/**
 *
 * @author manuel.benavente
 */
public class ProductoControlador {
        private LibroDAO dao;
        private ProductosVista vista;

        public ProductoControlador(ProductosVista vista) throws SQLException {
            this.vista = vista;
            this.dao = new LibroDAO();
            init();
        }
    
        private void init() {
            vista.getBtnAgregar().addActionListener(e -> agregar());
            vista.getBtnEditar().addActionListener(e -> editar());
            vista.getBtnEliminar().addActionListener(e -> eliminar());
            listar();
        }
        
        private void agregar() {
        try {
            String nombre = vista.getTxtNombre().getText();
            double precio = Double.parseDouble(vista.getTxtPrecio().getText());
            Libro p = new Libro(0, nombre, precio);
            dao.agregar(p);
            listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
        
        private void editar() {
            try {
                int id = Integer.parseInt(vista.getTxtId().getText());
                String nombre = vista.getTxtNombre().getText();
                double precio = Double.parseDouble(vista.getTxtPrecio().getText());
                Libro p = new Libro(id, nombre, precio);
                dao.actualizar(p);
                listar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    private void eliminar() {
        try {
            int id = Integer.parseInt(vista.getTxtId().getText());
            dao.eliminar(id);
            listar();   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listar() {
        try {
            List<Libro> lista = dao.listar();
            vista.mostrarProductos(lista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

