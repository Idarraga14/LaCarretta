package model;

public class Propietario {


    private String nombre;
    private String identificacion;
    private int edad;
    private int peso;


    private String email;
    private String celular;
    private Vehiculo vehiculo;

    public Propietario(String nombre, int edad,int peso, String identificacion, String email, String celular, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.identificacion = identificacion;
        this.email = email;
        this.celular = celular;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
