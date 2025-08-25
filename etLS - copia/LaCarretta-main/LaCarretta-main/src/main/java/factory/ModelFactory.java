package factory;
import implement.PropietarioService;
import implement.VehiculoCargaService;
import implement.VehiculoPasajeroService;
import model.VehiculoCarga;
import model.VehiculoPasajeros;
import service.IPropietarioService;
import service.IVehiculoCargaService;
import service.IVehiculoPasajerosService;

public class ModelFactory {

    private static ModelFactory instance;

    private IPropietarioService propietarioService;
    private IVehiculoCargaService vehiculoCargaService;
    private IVehiculoPasajerosService vehiculoPasajerosService;

    private ModelFactory(){
        propietarioService = new PropietarioService();
        vehiculoCargaService = new VehiculoCargaService();
        vehiculoPasajerosService = new VehiculoPasajeroService();

        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

     public IPropietarioService getPropietarioService() {
        return propietarioService;
     }

     public IVehiculoCargaService getVehiculoCargaService() {
        return vehiculoCargaService;
     }

     public IVehiculoPasajerosService getVehiculoPasajerosService() {
        return vehiculoPasajerosService;
     }

    public void inicializarDatos() {

        vehiculoCargaService.registrarVehiculoCarga("AAA111", 2020,"Chevrolet", "Azul", 100, 4);
        vehiculoCargaService.registrarVehiculoCarga("AAA101", 2010,"Toyota", "Blanco", 120, 4);


        vehiculoPasajerosService.registrarVehiculoPasajeros("A2A111", 2011,"Mercedes Benz", "Verde", 10);
        vehiculoPasajerosService.registrarVehiculoPasajeros("A3A101", 2015,"Ford", "Rojo", 12);


        VehiculoCarga camion = new VehiculoCarga("AAA111", 2020,"Chevrolet", "Azul", 100, 4);
        VehiculoCarga camion2 = new VehiculoCarga("AAA101", 2010,"Toyota", "Blanco", 120, 4);

        propietarioService.registrarPropietario("Juan Pérez", 40,78, "12345", "juan@gmail.com", "3001234567", camion);
        propietarioService.registrarPropietario("María Gómez", 35, 74,"67890", "maria@gmail.com", "3019876543", camion2);
    }


}
