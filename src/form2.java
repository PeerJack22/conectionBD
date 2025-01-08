import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form2 extends JFrame {
    private JTextField cedulaText;
    private JButton buscarButton;
    private JTable tableDatos;
    private JPanel datosPanel;
    private JLabel lbMensaje;
    private JLabel lbBienvenido;
    private JLabel cedulaLabel;

    public form2() {
        setTitle("Datos de la persona");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);

        initializeComponents();
        add(datosPanel);
    }

    private void initializeComponents() {
        // AAqui se inica los componentes para poder verlos
        datosPanel = new JPanel();
        cedulaLabel = new JLabel("Cédula:");
        cedulaText = new JTextField(20);
        buscarButton = new JButton("Buscar");
        lbMensaje = new JLabel();
        lbBienvenido = new JLabel("Bienvenido             ");

        // Hacer la tabla con lo que necesitamos
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cédula");
        model.addColumn("Nombre");
        model.addColumn("B1");
        model.addColumn("B2");

        tableDatos = new JTable(model); // Crear la tabla

        // Añadir componentes al panel
        datosPanel.add(lbBienvenido);
        datosPanel.add(cedulaLabel);
        datosPanel.add(cedulaText);
        datosPanel.add(buscarButton);
        datosPanel.add(lbMensaje);

        datosPanel.add(new JScrollPane(tableDatos));

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/test";
                    String user = "root";
                    String password = "12345";
                    String parametro = cedulaText.getText();

                    Connection con = DriverManager.getConnection(url, user, password);
                    lbMensaje.setText("Conectado a la base de datos. Aquí están sus datos.");
                    String query = "SELECT * FROM estudiantes WHERE cedula = ?";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, parametro);

                    ResultSet rs = pstmt.executeQuery();

                    //Limpiar los datos
                    model.setRowCount(0);

                    while (rs.next()) {
                        // Obtener los datos y agregar una fila al modelo
                        String cedula = rs.getString("cedula");
                        String nombre = rs.getString("nombre");
                        String b1 = rs.getString("b1");
                        String b2 = rs.getString("b2");
                        model.addRow(new Object[]{cedula, nombre, b1, b2});
                    }

                    if (model.getRowCount() == 0) {
                        lbMensaje.setText("No se encontraron resultados.");
                    }

                    con.close();
                } catch (SQLException e1) {
                    lbMensaje.setText("Error al conectar a la base de datos.");
                    e1.printStackTrace(); // Para depuración
                }
            }
        });
    }
}


