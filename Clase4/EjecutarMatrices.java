package Estruc_Datos.Clase4;

public class EjecutarMatrices {
    public static void main(String[] args) {
        Matrices m = new Matrices(); // creacion del objeto

        // lenar matriz y mostrar matriz
        int[][] M = m.llenarMatriz(3, 3); // pone de las variables
        System.out.println(m.mostrarMatriz(M));
    }
}
