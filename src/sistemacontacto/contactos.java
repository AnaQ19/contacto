package sistemacontacto;


public class contactos {
    private int id_contacto;
    private String nombre_contacto;
    private String apellido_contacto;
    private String telefono;
    private String direccion;

    public contactos(int id_contacto, String nombre_contacto, String apellido_contacto, String telefono, String direccion) {
        this.id_contacto = id_contacto;
        this.nombre_contacto = nombre_contacto;
        this.apellido_contacto = apellido_contacto;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId_contacto() {
        return id_contacto;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public String getApellido_contacto() {
        return apellido_contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
    
    
    
    
    
}
