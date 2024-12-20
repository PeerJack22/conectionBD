import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        try{
            Connection con = DriverManager.getConnection(url,user,password);
            System.out.println("Se ha conectado con la base de datos");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM estudiantes";

            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("cedula"));
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("b1"));
                System.out.println(rs.getString("b2"));
            }
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}