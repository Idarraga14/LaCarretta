import factory.ModelFactory;
import model.Propietario;
import model.VehiculoCarga;
import model.VehiculoPasajeros;
import utils.Constantes;
import javax.swing.JOptionPane;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        modelFactory.inicializarDatos();

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "=== MENÚ PRINCIPAL ===\n" +
                            "1. Registrar Propietario con vehiculo carga\n" +
                            "2. Registrar propietario con vehiculo pasajeros\n" +
                            "3. Lista de propietarios\n" +
                            "4. Actualizar propietario por N. identificacion\n" +
                            "5. Eliminar propietario por identificacion\n" +
                            "6. Numero de pasajeros buscando por placa\n" +
                            "7. Buscar por peso \n" +
                            "8. Propietarios mayores a 40\n" +
                            "0. Salir\n"
            ));

            switch (opcion) {
                case 1:
                    // === Datos del propietario ===
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del propietario:"));
                    int peso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el peso del propietario:"));
                    String identificacion = JOptionPane.showInputDialog("Ingrese la identificación:");
                    String email = JOptionPane.showInputDialog("Ingrese el email:");
                    String celular = JOptionPane.showInputDialog("Ingrese el celular:");

                    // === Datos del vehículo de carga ===
                    String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
                    int modelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el modelo del vehículo:"));
                    String marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
                    String color = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
                    int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de carga:"));
                    int ejes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ejes:"));

                    // Crear el objeto vehículo de carga
                    VehiculoCarga vehiculo = new VehiculoCarga(placa, modelo, marca, color, capacidad, ejes);

                    // Registrar el vehículo en el service
                    modelFactory.getVehiculoCargaService()
                            .registrarVehiculoCarga(placa, modelo, marca, color, capacidad, ejes);

                    // Registrar el propietario junto con su vehículo
                    modelFactory.getPropietarioService()
                            .registrarPropietario(nombre, edad, peso, identificacion, email, celular, vehiculo);

                    showMessageDialog(null, " Propietario y vehículo registrados exitosamente.");
                    break;

                case 2:
                    // === Datos del propietario ===
                    String nombreP = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
                    int edadP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del propietario:"));
                    int pesoP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el peso del propietario:"));
                    String identificacionP = JOptionPane.showInputDialog("Ingrese la identificación:");
                    String emailP = JOptionPane.showInputDialog("Ingrese el email:");
                    String celularP = JOptionPane.showInputDialog("Ingrese el celular:");

                    // === Datos del vehículo de pasajeros ===
                    String placaP = JOptionPane.showInputDialog("Ingrese la placa del vehículo de pasajeros:");
                    int modeloP = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el modelo del vehículo:"));
                    String marcaP = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
                    String colorP = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
                    int maxPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el máximo de pasajeros:"));

                    // Crear el objeto vehículo de pasajeros
                    VehiculoPasajeros vehiculoP = new VehiculoPasajeros(placaP, modeloP, marcaP, colorP, maxPasajeros);

                    // Registrar el vehículo en el service de pasajeros
                    modelFactory.getVehiculoPasajerosService()
                            .registrarVehiculoPasajeros(placaP, modeloP, marcaP, colorP, maxPasajeros);

                    // Registrar el propietario junto con su vehículo de pasajeros
                    modelFactory.getPropietarioService()
                            .registrarPropietario(nombreP, edadP, pesoP, identificacionP, emailP, celularP, vehiculoP);

                    showMessageDialog(null, " Propietario y vehículo de pasajeros registrados exitosamente.");
                    break;

                case 3: // Listar propietarios
                    List<Propietario> propietarios = modelFactory.getPropietarioService().listarPropietarios();
                    StringBuilder lista = new StringBuilder("=== LISTA DE PROPIETARIOS ===\n");
                    for (Propietario p : propietarios) {
                        lista.append("Nombre: ").append(p.getNombre())
                                .append(", ID: ").append(p.getIdentificacion())
                                .append(", Edad: ").append(p.getEdad())
                                .append(", Vehículo: ").append(p.getVehiculo().getPlaca())
                                .append("\n");
                    }
                    showMessageDialog(null, lista.toString());
                    break;

                case 4: // Actualizar propietario
                    String idActualizar = JOptionPane.showInputDialog("Ingrese la identificación del propietario a actualizar:");
                    Propietario propietarioAct = modelFactory.getPropietarioService().buscarPropietario(idActualizar);

                    if (propietarioAct != null) {
                        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", propietarioAct.getNombre());
                        int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:", propietarioAct.getEdad()));
                        int nuevoPeso = Integer.parseInt(JOptionPane.showInputDialog("Nuevo peso:", propietarioAct.getPeso()));
                        String nuevoEmail = JOptionPane.showInputDialog("Nuevo email:", propietarioAct.getEmail());
                        String nuevoCel = JOptionPane.showInputDialog("Nuevo celular:", propietarioAct.getCelular());

                        propietarioAct.setNombre(nuevoNombre);
                        propietarioAct.setEdad(nuevaEdad);
                        propietarioAct.setPeso(nuevoPeso);
                        propietarioAct.setEmail(nuevoEmail);
                        propietarioAct.setCelular(nuevoCel);

                        showMessageDialog(null, "Propietario actualizado correctamente.");
                    } else {
                        showMessageDialog(null, "No se encontró propietario con esa identificación.");
                    }
                    break;

                case 5: // Eliminar propietario
                    String idEliminar = JOptionPane.showInputDialog("Ingrese la identificación del propietario a eliminar:");
                    boolean eliminado = modelFactory.getPropietarioService().eliminarPropietario(idEliminar);

                    if (eliminado) {
                        showMessageDialog(null, "Propietario eliminado correctamente.");
                    } else {
                        showMessageDialog(null, "No se encontró propietario con esa identificación.");
                    }
                    break;

                case 6:
                    String placaBuscar = JOptionPane.showInputDialog("Ingrese la placa del vehículo de pasajeros:");
                    int viajes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de viajes realizados hoy:"));

                    int totalPasajeros = modelFactory.getVehiculoPasajerosService().totalPasajerosPorPlaca(placaBuscar, viajes);

                    if (totalPasajeros > 0) {
                        showMessageDialog(null, "El total de pasajeros transportados hoy es: " + totalPasajeros);
                    } else {
                        showMessageDialog(null, "No se encontró un vehículo de pasajeros con esa placa.");
                    }
                    break;

                case 7:
                    int pesoBuscado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el peso mínimo:"));

                    List<Propietario> propietariosPesados = modelFactory.getPropietarioService()
                            .propietariosConPesoMayorA(pesoBuscado);

                    if (propietariosPesados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay propietarios con peso mayor a " + pesoBuscado);
                    } else {
                        StringBuilder mensaje = new StringBuilder("=== PROPIETARIOS CON PESO MAYOR A " + pesoBuscado + " ===\n");
                        for (Propietario p : propietariosPesados) {
                            mensaje.append("Nombre: ").append(p.getNombre())
                                    .append(", Identificación: ").append(p.getIdentificacion())
                                    .append(", Peso: ").append(p.getPeso())
                                    .append(", Vehículo: ").append(p.getVehiculo().getPlaca())
                                    .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, mensaje.toString());
                    }
                    break;

                case 8:
                    int totalMayores40 = modelFactory.getPropietarioService().contarPropietariosMayoresDe40();

                    if (totalMayores40 == 0) {
                        JOptionPane.showMessageDialog(null, "No hay propietarios mayores de 40 años.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de propietarios mayores de 40 años: " + totalMayores40);
                    }
                    break;

                case 0:
                    showMessageDialog(null, " Saliendo del sistema...");
                    break;

                default:
                    showMessageDialog(null, " Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}

