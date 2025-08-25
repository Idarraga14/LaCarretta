package service;

public interface IVehiculoCargaService {
    public void registrarVehiculoCarga(String placa, int modelo, String marca, String color, int capacidadCarga, int numeroEjes);
    public void listarVehiculosCarga();
    public void eliminarVehiculoCarga(String placa);
    public void ActualizarVehiculoCarga(String placa, String marca, String color, int modelo, int capacidadCarga, int numeroEjes);
    public void buscarVehiculoCarga(String placa);
}
