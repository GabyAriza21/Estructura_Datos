package Estruc_Datos.Clase4;

public class Casillero {

    private int numCasillero; //numero del casillero
    private boolean disponible; //true si esta libre, false si esta ocupado
    private Paquete paquete; // Atributo para almacenar el paquete (composición)

    // Constructor: crea el casillero con su numero y lo deja libre
    public Casillero(int numCasillero) {
        this.numCasillero = numCasillero; //asigna el id
        this.disponible = true; // por defecto los casilleros empiezan libre
        this.paquete = null; // inicialmente no hay paquete
    }

    //metodo getter boolean que devuelve si el casillero esta libre o no
    public boolean isDisponible() {
        return disponible;
    }

    //asigna un paquete al casillero si esta libre
    public void asignarPaquete(Paquete paquete) {
        if (disponible) { //si esta libre
            this.paquete = paquete; //gyarda el paquete
            this.disponible = false; //lo marca como ocupado
            } else {
            System.out.println("Casillero " + numCasillero + " ocupado.");
        }
    }

    //libera el casillero
    public void liberarCasillero() {
        this.paquete = null; //elimina el paquete
        this.disponible = true; //lo marca como libre
    }

    public Paquete getPaquete() { //devuelve el paquete asignado
        return paquete;
    }

    public int getnumCasillero() { //devuelve el numero del casillero
        return numCasillero;
    }

    public String toString() { //imprime el casillero
        if (disponible) {
            return "[Casillero " + numCasillero + ": Libre }";
        } else {
            return "Casillero " + numCasillero + ": Ocupado -> " + paquete + " ]";
        }
    }
}
