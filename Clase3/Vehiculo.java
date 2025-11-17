package Estruc_Datos.Clase3;

public class Vehiculo {
    private String chasis;
    private String marca;
    private int modelo;
    private boolean matriculado;

    // constructor clase
    public Vehiculo(String chasis, String marca, int modelo, boolean matriculado) {
        this.chasis = chasis;
        this.marca = marca;
        this.modelo = modelo;
        this.matriculado = matriculado;
    }

    // mostrar lo que tiene el objeto
    public String toString() {
        return "Vehiculo { Chasis: " + chasis +
                " Marca: " + marca +
                " Modelo: " + modelo +
                " Matriculado: " + matriculado + "}";
    }

    // metodo para iterar el arreglo
    public String iterarVehiculos(Vehiculo[] vehiculos) {
        String cad = "";
        for (int i = 0; i < vehiculos.length; i++) {
            cad += vehiculos[i] + "\n";
        }
        return cad;
    }
}
