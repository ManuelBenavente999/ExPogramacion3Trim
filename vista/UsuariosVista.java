package vista;

import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Lector;

public class UsuariosVista extends JFrame {
    private JTextField txtId, txtNombre, txtEmail;
    private JButton btnAgregar, btnEditar, btnEliminar;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public UsuariosVista() {
        setTitle("Gestión de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");

        panel.add(btnAgregar);
        panel.add(btnEditar);
        panel.add(btnEliminar);

        add(panel, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Email"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    public JTextField getTxtId() { return txtId; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtEmail() { return txtEmail; }

    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEliminar() { return btnEliminar; }

    public void mostrarUsuarios(List<Lector> lista) {
        modeloTabla.setRowCount(0);
        for (Lector u : lista) {
            modeloTabla.addRow(new Object[]{u.getId(), u.getNombre(), u.getEmail()});
        }
    }
}
