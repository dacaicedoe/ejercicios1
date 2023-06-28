import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BorrarFrame extends JFrame {
    private JComboBox<String> cmbRegistros;

    public BorrarFrame() {
        setTitle("Borrar Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLayout(new GridLayout(2, 2));

        JLabel lblRegistro = new JLabel("Registro:");
        cmbRegistros = new JComboBox<>(obtenerRegistros());

        JButton btnBorrarRegistro = new JButton("Borrar");
        btnBorrarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarRegistroSeleccionado();
                dispose();
            }
        });

        add(lblRegistro);
        add(cmbRegistros);
        add(btnBorrarRegistro);

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

    private void borrarRegistroSeleccionado() {
        int indiceRegistro = cmbRegistros.getSelectedIndex();

        try {
            String[] registros = obtenerRegistros();
            if (indiceRegistro >= 0 && indiceRegistro < registros.length) {
                registros[indiceRegistro] = null;

                FileWriter writer = new FileWriter("registros.csv");
                for (String registro : registros) {
                    if (registro != null) {
                        writer.append(registro + "\n");
                    }
                }
                writer.close();

                JOptionPane.showMessageDialog(this, "Registro borrado exitosamente.", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un registro válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al borrar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
