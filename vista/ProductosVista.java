/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Libro;

/**
 *
 * @author manuel.benavente
 */
public class ProductosVista extends JFrame {
    private JTextField txtId, txtNombre, txtPrecio;
    private JButton btnAgregar, btnEditar, btnEliminar;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    
    
    public ProductosVista() {
        setTitle("Gestion de Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("ID:"));
        txtId = new  JTextField();
        panel.add(txtId);
        
        panel.add(new JLabel("Nombre:"));
        txtNombre = new  JTextField();
        panel.add(txtNombre);
        
        panel.add(new JLabel("Precio:"));
        txtPrecio = new  JTextField();
        panel.add(txtPrecio);
        
        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        
        panel.add(btnAgregar);
        panel.add(btnEditar);
        panel.add(btnEliminar);
        
        add(panel, BorderLayout.NORTH);
        
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
    
    
        public JTextField getTxtId() { return txtId; }
        public JTextField getTxtNombre() { return txtNombre; }
        public JTextField getTxtPrecio() { return txtPrecio; }
        
        public JButton getBtnAgregar() { return btnAgregar; }
        public JButton getBtnEditar() { return btnEditar; }
        public JButton getBtnEliminar() { return btnEliminar; }
        
        public void mostrarProductos(List<Libro> lista) {
            modeloTabla.setRowCount(0);
            for (Libro p : lista) {
                modeloTabla.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio()});
            }
        }
        }
    