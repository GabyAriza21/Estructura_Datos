package Estruc_Datos.Clase4;

public class MatrizCasillero {
    private Casillero[][] casilleros; //matriz de casilleros columna*fila

    // Constructor: crea la matriz de casilleros con filas y columnas 
    public MatrizCasillero(int filas, int columnas){ 
        casilleros = new Casillero[filas][columnas]; //crea la matiz
        int contador = 1; //contador para asignar numero a cada casillero
        for (int i = 0; i < filas; i++) { //recorre filas
            for (int j = 0; j < columnas; j++) { //recorre columnas
                casilleros[i][j] = new Casillero(contador++); //crea el casillero y le asigna un numero
            }
        }
    }

    //consulta un casillero por su numero e imprime su estado 
    public void consultarCasillero(int numCasillero) {
    for (int i = 0; i < casilleros.length; i++) {
        for (int j = 0; j < casilleros[i].length; j++) {
            if (casilleros[i][j].getnumCasillero() == numCasillero) {
                System.out.println(casilleros[i][j]);
                return;
            }
        }
    }
    System.out.println("Casillero " + numCasillero + " no encontrado.");
}

    //muestra el estado de todos los casilleros (I = libre, O = ocupado) 
    public String mostrarCasilleros() {
        String cad = "";
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                if (casilleros[i][j].isDisponible()){
                    cad += "[I] "; // I de libre
                } else {
                    cad += "[O] "; // O de ocupado
                }
            }
            cad += "\n";
        }
        return cad;
    }

    //registra un paquete en el primer casillero libre
    public void registrarPaquete(Paquete p) {
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                if (casilleros[i][j].isDisponible()) {
                    casilleros[i][j].asignarPaquete(p);
                    System.out.println("Paquete asignado al casillero " + casilleros[i][j].getnumCasillero());
                    return;
                }
            }
        }
        System.out.println("No hay casilleros disponibles.");
    }

    //libera un casillero por su numero
    public void liberarCasillero(int numCasillero) {
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                if (casilleros[i][j].getnumCasillero() == numCasillero) {
                    casilleros[i][j].liberarCasillero();
                    System.out.println("Casillero " + numCasillero + " liberado.");
                    return;
                }
            }
        }
        System.out.println("Casillero " + numCasillero + " no encontrado.");
    }
}
