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

                String user = textLogin.getText();
                String password = new String(passwordField1.getPassword());


                if (user.equals(user) && password.equals(password)) {
                    form2 nuevaVentana = new form2();
                    nuevaVentana.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contaseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
