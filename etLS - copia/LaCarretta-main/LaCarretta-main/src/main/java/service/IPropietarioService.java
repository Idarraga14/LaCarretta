package service;

import model.Propietario;
import model.Vehiculo;
import java.util.List;

public interface IPropietarioService {
    void registrarPropietario(String nombre, int edad, int peso, String identificacion, String email, String celular, Vehiculo vehiculo);
    List<Propietario> listarPropietarios();
    boolean eliminarPropietario(String identificacion);
    void ActualizarPropietario(String identificacion, String nombre, int edad, String email, String celular);
    Propietario buscarPropietario(String identificacion);
    void asociarVehiculo(String identificacion, Vehiculo vehiculo);
    List<Propietario> propietariosConPesoMayorA(int pesoBuscado);
    int contarPropietariosMayoresDe40();
}
