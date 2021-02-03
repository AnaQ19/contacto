package sistemacontacto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistemacontacto {

    public static void main(String[] args) throws SQLException {
        basededatos bd = new basededatos();
        Connection conn = bd.getConnection();
        dbcontactos contactos = new dbcontactos(conn);
        contactos c1 = contactos.getcontactos(1);
       System.out.print("Nombre: " + c1.getNombre_contacto());
       contactos.insertTest("Sara", "Herrera", "sanfernando", 12345);
        // insertTest(conn);
        // System.out.println("Datos insertados");

        PreparedStatement stat = conn.prepareStatement("SELECT * FROM contactos");
        ResultSet resultSet = stat.executeQuery();

        while (resultSet.next()) {
            int idContacto = resultSet.getInt("id_contacto");
            String NombreContactos = resultSet.getString("nombre_contacto");
            String apellidoContacto = resultSet.getString("apellido_contacto");
            String Telefono = resultSet.getString("telefono");
            String Direccion = resultSet.getString("direccion");
            contactos c = new contactos(idContacto, NombreContactos, apellidoContacto, Telefono, Direccion);

            System.out.printf("El contacto se llama %s %s y su telefono es %s y su direccion es %s\r\n", NombreContactos, apellidoContacto, Telefono, Direccion);
        }

    }

    private static void insertTest(Connection conn) throws SQLException {
        String q = "INSERT INTO contactos (nombre_contacto, apellido_contacto, telefono, direccion) VALUES(?, ? ,?, ?)";
        PreparedStatement stmt = conn.prepareStatement(q);
        stmt.setString(1, "Rosa");
        stmt.setString(2, "Lopez");
        stmt.setString(3, "+00000000");
        stmt.setString(4, "Mozonte");
        stmt.execute();
    }
 }
    


