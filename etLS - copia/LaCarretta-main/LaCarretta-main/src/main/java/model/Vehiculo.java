package model;

public class Vehiculo {

   private String placa;
   private int modelo;
   private String marca;
   private String color;

   public Vehiculo(String placa, int modelo, String marca, String color) {
      this.placa = placa;
      this.modelo = modelo;
      this.marca = marca;
      this.color = color;
   }

   public String getPlaca() {
      return placa;
   }

   public void setPlaca(String placa) {
      this.placa = placa;
   }

   public int getModelo() {
      return modelo;
   }

   public void setModelo(int modelo) {
      this.modelo = modelo;
   }

   public String getMarca() {
      return marca;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

}
