package Estruc_Datos.Clase3;

public class EjecutarVehiculo {
    public static void main(String[] args) {

        Vehiculo[] vehi = new Vehiculo[5];

        vehi[0] = new Vehiculo("ABC123", "Kia", 2025, true);
        vehi[1] = new Vehiculo("ASD456", "Audi", 2021, false);
        vehi[2] = new Vehiculo("ASC147", "Jeep", 2019, true);
        vehi[3] = new Vehiculo("QWE789", "Mazda", 2020, true);
        vehi[4] = new Vehiculo("ZXC321", "Toyota", 2017, false);

        System.out.println(vehi[0].iterarVehiculos(vehi));

    }
}