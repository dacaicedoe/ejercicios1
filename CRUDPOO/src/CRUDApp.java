import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CRUDApp {
    private JFrame frame;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JComboBox<String> cmbRegistros;
    private JComboBox<String> cmbCampo;
    private JTextField txtNuevoValor;
    private DefaultListModel<String> listModel;

    private String[] campos = { "Nombre", "Apellido", "Edad" };
    private String[] registros;

    private static final String FILE_PATH = "registros.csv";

    public CRUDApp() {
        frame = new JFrame("CRUD App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(2, 2));

        // Botón Crear
        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CrearFrame();
            }
        });

        // Botón Leer
        JButton btnLeer = new JButton("Leer");
        btnLeer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LeerFrame();
            }
        });

        // Botón Actualizar
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ActualizarFrame()   ;
            }
        });

        // Botón Borrar
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BorrarFrame();
            }
        });

        // Agregar los botones al frame
        frame.add(btnCrear);
        frame.add(btnLeer);
        frame.add(btnActualizar);
        frame.add(btnBorrar);

        frame.setVisible(true);
    }

}
