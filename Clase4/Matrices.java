package Estruc_Datos.Clase4;

public class Matrices {

    // metodo llenar matriz
    public int[][] llenarMatriz(int filas, int columas) {
        int[][] m = new int[filas][columas];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) ((Math.random() * (9 - 1) + 1)) + 1;
            }
        }
        return m;
    }

    // mostrar matriz
    public String mostrarMatriz(int[][] m) { 
        String cad = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                cad += (m[i][j]) + " ";
            }
            cad += "\n";
        }
        return cad;
    }
}