import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CrearFrame extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JButton btnGuardar;

    public CrearFrame() {
        setTitle("Crear Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();

        JLabel lblApellido = new JLabel("Apellido:");
        txtApellido = new JTextField();

        JLabel lblEdad = new JLabel("Edad:");
        txtEdad = new JTextField();

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarRegistro();
            }
        });

        add(lblNombre);
        add(txtNombre);
        add(lblApellido);
        add(txtApellido);
        add(lblEdad);
        add(txtEdad);
        add(btnGuardar);

        setVisible(true);
    }

    private void guardarRegistro() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String edad = txtEdad.getText();

        try {
            FileWriter writer = new FileWriter("registros.csv", true);
            writer.append(nombre + "," + apellido + "," + edad + "\n");
            writer.close();
            JOptionPane.showMessageDialog(this, "Registro creado exitosamente.", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
