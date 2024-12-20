import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    private JTextField textLogin;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    public JPanel loginPanel;

    public form1() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/test";
                String user = "root";
                String password = "123456";


                try{
                    String parametro = textLogin.getText();
                    Connection con = DriverManager.getConnection(url,user,password);
                    System.out.println("Se ha conectado con la base de datos");
                    Statement stmt = con.createStatement();
                    String query = "SELECT * FROM  estudiantes where cedula =?";

                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1,parametro);

                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                        System.out.println(rs.getString("cedula"));
                        System.out.println(rs.getString("nombre"));
                        System.out.println(rs.getString("b1"));
                        System.out.println(rs.getString("b2"));
                    }
                    con.close();

                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });
    }
}
