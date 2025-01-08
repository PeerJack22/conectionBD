import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class form1 {
    private JTextField textLogin;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    public JPanel loginPanel;

    public form1() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = "root";
                String password = "12345";
                String usert = textLogin.getText();
                String passwordt = new String(passwordField1.getPassword());


                if (usert.equals(user) && passwordt.equals(password)) {
                    form2 nuevaVentana = new form2();
                    nuevaVentana.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Acceso denegado. Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
