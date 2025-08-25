package implement;

import model.VehiculoCarga;
import service.IVehiculoCargaService;

import java.util.ArrayList;
import java.util.List;

public class VehiculoCargaService implements IVehiculoCargaService {

    private List<VehiculoCarga> listarVehiculosCarga = new ArrayList<>();
    @Override
    public void registrarVehiculoCarga(String placa, int modelo, String marca, String color, int capacidadCarga, int numeroEjes) {
        VehiculoCarga vehiculoCarga = new VehiculoCarga(placa, modelo, marca, color, capacidadCarga, numeroEjes);
        listarVehiculosCarga.add(vehiculoCarga);
    }

    @Override
    public void listarVehiculosCarga() {
        for (VehiculoCarga vehiculo : listarVehiculosCarga) {
            System.out.println(vehiculo.getPlaca());
        }
    }

    @Override
    public void eliminarVehiculoCarga(String placa) {
        for (VehiculoCarga vehiculo : listarVehiculosCarga) {
            if (vehiculo.getPlaca().equals(placa)) {
                listarVehiculosCarga.remove(vehiculo);
            }
        }
    }

    @Override
    public void ActualizarVehiculoCarga(String placa, String marca, String color, int modelo, int capacidadCarga, int numeroEjes) {
        for (VehiculoCarga vehiculo : listarVehiculosCarga) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculo.setMarca(marca);
                vehiculo.setColor(color);
                vehiculo.setModelo(modelo);
                vehiculo.setCapacidadCarga(capacidadCarga);
                vehiculo.setNumeroEjes(numeroEjes);
                break;
            }
        }
    }

    @Override
    public void buscarVehiculoCarga(String placa) {
        for (VehiculoCarga vehiculo : listarVehiculosCarga) {
            if (vehiculo.getPlaca().equals(placa)) {
                System.out.println(vehiculo.getMarca());
            }
        }
    }
}
