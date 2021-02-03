package sistemacontacto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbcontactos {
    
    private Connection conn;
    
    public dbcontactos(Connection conn) {
        this.conn = conn;
        
    }
    
    public contactos getcontactos(int id) throws SQLException {
        contactos c = null;
        PreparedStatement stat = this.conn.prepareStatement("SELECT * FROM contactos WHERE id_contacto = ?");
        stat.setInt(1, id);
        ResultSet resultSet = stat.executeQuery();
        
        while (resultSet.next()) {
            int idContacto = resultSet.getInt("id_contacto");
            String NombreContactos = resultSet.getString("nombre_contacto");
            String apellidoContacto = resultSet.getString("apellido_contacto");
            String Telefono = resultSet.getString("telefono");
            String Direccion = resultSet.getString("direccion");
            c = new contactos(idContacto, NombreContactos, apellidoContacto, Telefono, Direccion);
            
        }
        return c;
    }
    public  void insertTest(String NombreContacto, String ApellidoContacto, String Direccion, int Telefono) {
        String q = "INSERT INTO contactos (nombre_contacto, apellido_contacto, telefono, direccion) VALUES(?, ? ,?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            stmt.setString(1, "nombre_contacto");
        stmt.setString(2, "apellido_contacto");
        stmt.setString(3, "telefono");
        stmt.setString(4, "direccion");
        stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(dbcontactos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
