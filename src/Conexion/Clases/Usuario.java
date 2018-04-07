package Conexion.Clases;

public class Usuario {
    private int cedula;
    private String correo;
    private String alias;
    private String nombre;
    private String apellido;
    private String direccion;
    private String pass;

    public Usuario(int cedula, String correo, String alias, String nombre, String apellido, String direccion, String pass) {
        this.cedula = cedula;
        this.correo = correo;
        this.alias = alias;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.pass = pass;
    }

    public Usuario(int cedula, String correo, String nombre, String apellido, String direccion) {
        this.cedula = cedula;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public static String encripta(String contraseña){
        contraseña=new StringBuilder(contraseña).reverse().toString();
        String principio=contraseña.substring(0,contraseña.length()/2);
        String finals= contraseña.substring((contraseña.length()/2),contraseña.length());
        contraseña=finals+principio;
        return contraseña;
    }
}
