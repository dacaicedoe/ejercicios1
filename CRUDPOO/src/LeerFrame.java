import javax.swing.*;
import java.io.*;

public class LeerFrame extends JFrame {
    private DefaultListModel<String> listModel;

    public LeerFrame() {
        setTitle("Leer Registros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        listModel = new DefaultListModel<String>();

        try {
            FileReader reader = new FileReader("registros.csv");
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                listModel.addElement(line);
            }

            JList<String> list = new JList<>(listModel);
            JScrollPane scrollPane = new JScrollPane(list);
            add(scrollPane);

            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer los registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        setVisible(true);
    }
}
