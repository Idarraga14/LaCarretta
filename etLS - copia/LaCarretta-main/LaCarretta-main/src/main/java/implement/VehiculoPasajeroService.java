package implement;

import model.VehiculoPasajeros;
import service.IVehiculoPasajerosService;

import java.util.ArrayList;
import java.util.List;

public class VehiculoPasajeroService implements IVehiculoPasajerosService {

    List<VehiculoPasajeros> listaVehiculosPasajeros = new ArrayList<>();

    @Override
    public void registrarVehiculoPasajeros(String placa, int modelo, String marca, String color, int maxPasajeros) {
        VehiculoPasajeros vehiculoPasajeros = new VehiculoPasajeros(placa, modelo, marca, color, maxPasajeros);
        listaVehiculosPasajeros.add(vehiculoPasajeros);
    }

    @Override
    public void listarVehiculosPasajeros() {
        for (VehiculoPasajeros vehiculo : listaVehiculosPasajeros) {
            System.out.println(vehiculo.getPlaca());
        }
    }

    @Override
    public void eliminarVehiculoPasajeros(String placa) {
        for (VehiculoPasajeros vehiculo : listaVehiculosPasajeros) {
            if (vehiculo.getPlaca().equals(placa)) {
                listaVehiculosPasajeros.remove(vehiculo);
            }
        }
    }

    @Override
    public void ActualizarVehiculoPasajeros(String placa, int modelo, String marca, String color, int maxPasajeros) {
        for (VehiculoPasajeros vehiculo : listaVehiculosPasajeros) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculo.setModelo(modelo);
                vehiculo.setMarca(marca);
                vehiculo.setColor(color);
                vehiculo.setMaxPasajeros(maxPasajeros);
                break;
            }
        }
    }

    @Override
    public void buscarVehiculoPasajeros(String placa) {
        for (VehiculoPasajeros vehiculo : listaVehiculosPasajeros) {
            if (vehiculo.getPlaca().equals(placa)) {
                System.out.println(vehiculo.getMarca());
            }
        }
    }

    public int totalPasajerosPorPlaca(String placa, int viajesPorDia) {
        for (VehiculoPasajeros v : listaVehiculosPasajeros) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v.getMaxPasajeros() * viajesPorDia; // pasajeros por viaje * viajes diarios
            }
        }
        return 0; // placa no encontrada
    }

}
