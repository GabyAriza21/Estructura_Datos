package Estruc_Datos.Clase3.DESAFIO3;

public class Estudiante {

    // atributos
    private String nombre;
    private boolean matricula;
    private double promedio;

    // metodo constructor
    public Estudiante(String nombre, boolean matricula, double promedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.promedio = promedio;
    }

    // metodos
    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return "Estudiante { Nombre: " + nombre +
                " Matricula: " + matricula +
                " Promedio: " + promedio + "}";
    }
}
