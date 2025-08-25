package implement;

import model.Propietario;
import model.Vehiculo;
import service.IPropietarioService;

import java.util.ArrayList;
import java.util.List;

public class PropietarioService implements IPropietarioService {

    private List<Propietario> propietarios = new ArrayList<>();

    @Override
    public void registrarPropietario(String nombre, int edad, int peso, String identificacion, String email, String celular, Vehiculo vehiculo){
        Propietario propietario = new Propietario(nombre, edad, peso, identificacion, email, celular, vehiculo);
        propietarios.add(propietario);
    }

    @Override
    public List<Propietario> listarPropietarios() { return propietarios; }

    @Override
    public boolean eliminarPropietario(String identificacion) {
        // removeIf devuelve true si eliminó al menos un propietario
        return propietarios.removeIf(p -> p.getIdentificacion().equals(identificacion));
    }

    @Override
    public void ActualizarPropietario(String identificacion, String nombre, int edad, String email, String celular) {
        for (Propietario p : propietarios) {
            if (p.getIdentificacion().equals(identificacion)) {
                p.setNombre(nombre);
                p.setEdad(edad);
                p.setEmail(email);
                p.setCelular(celular);
                break;
            }
        }
    }

    @Override
    public Propietario buscarPropietario(String identificacion) {
        for (Propietario p : propietarios) {
            if (p.getIdentificacion().equals(identificacion)) {
                System.out.println("Propietario encontrado: " + p.getNombre());
                return p;
            }
        }
        System.out.println("No se encontró propietario con identificación: " + identificacion);
        return null;
    }

    @Override
    public void asociarVehiculo(String identificacion, Vehiculo vehiculo) {
        for (Propietario p : propietarios) {
            if (p.getIdentificacion().equals(identificacion)) {
                p.setVehiculo(vehiculo);
                break;
            }
        }
    }

    public List<Propietario> propietariosConPesoMayorA(int pesoMinimo) {
        List<Propietario> resultado = new ArrayList<>();
        for (Propietario p : propietarios) {
            if (p.getPeso() > pesoMinimo) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public int contarPropietariosMayoresDe40() {
        int contador = 0;
        for (Propietario p : propietarios) {
            if (p.getEdad() > 40) {
                contador++;
            }
        }
        return contador;
    }

}
