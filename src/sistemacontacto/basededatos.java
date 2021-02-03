package sistemacontacto;

import java.sql.*;

public class basededatos {

    private String connString = "jdbc:mysql://localhost:3306/contactos";
    private String dbUser = "root";
    private String dbPass = "";

    private Connection conn;

    public Connection getConnection() {
        return this.conn;
    }

    public basededatos() {
        try {
            this.conn = DriverManager.getConnection(this.connString, this.dbUser, this.dbPass);
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
    }

}
