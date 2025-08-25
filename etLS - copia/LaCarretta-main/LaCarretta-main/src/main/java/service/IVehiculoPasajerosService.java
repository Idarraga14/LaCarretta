package service;

public interface IVehiculoPasajerosService {
    public void registrarVehiculoPasajeros(String placa, int modelo, String marca, String color, int maxPasajeros);
    public void listarVehiculosPasajeros();
    public void eliminarVehiculoPasajeros(String placa);
    public void ActualizarVehiculoPasajeros(String placa, int modelo, String marca, String color, int maxPasajeros);
    public void buscarVehiculoPasajeros(String placa);
    int totalPasajerosPorPlaca(String placaBuscar, int viajes);
}
