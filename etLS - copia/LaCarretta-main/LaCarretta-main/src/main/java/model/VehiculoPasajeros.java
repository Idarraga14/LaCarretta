package model;

public class VehiculoPasajeros extends Vehiculo {

    private int maxPasajeros;


    public VehiculoPasajeros(String placa, int modelo, String marca, String color, int maxPasajeros) {
        super(placa, modelo, marca, color);
        this.maxPasajeros = maxPasajeros;
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public void setMaxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
    }
}
