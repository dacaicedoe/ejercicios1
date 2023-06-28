import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ActualizarFrame extends JFrame {
    private JComboBox<String> cmbRegistros;
    private JComboBox<String> cmbCampo;
    private JTextField txtNuevoValor;
    private JButton btnActualizarGuardar;

    private String[] campos = { "Nombre", "Apellido", "Edad" };

    public ActualizarFrame() {
        setTitle("Actualizar Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        JLabel lblRegistro = new JLabel("Registro:");
        cmbRegistros = new JComboBox<>(obtenerRegistros());

        JLabel lblCampo = new JLabel("Campo:");
        cmbCampo = new JComboBox<>(campos);

        JLabel lblNuevoValor = new JLabel("Nuevo valor:");
        txtNuevoValor = new JTextField();

        btnActualizarGuardar = new JButton("Actualizar");
        btnActualizarGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarRegistroSeleccionado();
                dispose();
            }
        });

        add(lblRegistro);
        add(cmbRegistros);
        add(lblCampo);
        add(cmbCampo);
        add(lblNuevoValor);
        add(txtNuevoValor);
        add(btnActualizarGuardar);

        setVisible(true);
    }

    private String[] obtenerRegistros() {
        try {
            FileReader reader = new FileReader("registros.csv");
            BufferedReader br = new BufferedReader(reader);

            String line;
            String[] registros = new String[getLineCount("registros.csv")];
            int i = 0;
            while ((line = br.readLine()) != null) {
                registros[i] = line;
                i++;
            }

            br.close();
            return registros;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer los registros.", "Error", JOptionPane.ERROR_MESSAGE);
            return new String[0];
        }
    }

    private int getLineCount(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        LineNumberReader lineNumberReader = new LineNumberReader(reader);

        int count = 0;
        while (lineNumberReader.readLine() != null) {
            count++;
        }

        lineNumberReader.close();
        reader.close();
        return count;
    }

    private void actualizarRegistroSeleccionado() {
        int indiceRegistro = cmbRegistros.getSelectedIndex();
        String campo = (String) cmbCampo.getSelectedItem();
        String nuevoValor = txtNuevoValor.getText();

        try {
            String[] registros = obtenerRegistros();
            if (indiceRegistro >= 0 && indiceRegistro < registros.length) {
                String registroActualizado = actualizarCampo(registros[indiceRegistro], campo, nuevoValor);
                registros[indiceRegistro] = registroActualizado;

                FileWriter writer = new FileWriter("registros.csv");
                for (String registro : registros) {
                    writer.append(registro + "\n");
                }
                writer.close();

                JOptionPane.showMessageDialog(this, "Registro actualizado exitosamente.", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un registro válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String actualizarCampo(String registro, String campo, String nuevoValor) {
        String[] campos = registro.split(",");
        if (campo.equals("Nombre")) {
            campos[0] = nuevoValor;
        } else if (campo.equals("Apellido")) {
            campos[1] = nuevoValor;
        } else if (campo.equals("Edad")) {
            campos[2] = nuevoValor;
        }
        return String.join(",", campos);
    }
}
