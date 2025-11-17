package Estruc_Datos.Clase6;

import java.util.ArrayDeque;
import java.util.Queue;

public class Colas {
    public static void main(String[] args) {
        Queue<Integer> cola = new ArrayDeque<>();

        System.out.println(cola.peek());

        cola.add(5);
        cola.add(10);
        cola.add(3);
        cola.add(20);

        System.out.println("Cola original: " + cola);
        System.out.println(cola.element());

        boolean agregar = cola.offer(15);
        System.out.println(agregar);
        System.out.println("Cola agregada: " + cola);

        System.out.println(cola.peek());
        System.out.println("Cola elemento 1: " + cola);

        System.out.println(cola.poll());
        System.out.println("Cola eliminada: " + cola);

        System.out.println("Tamaño de la cola: " + cola.size());

        System.out.println(cola.remove());

        cola.clear();

        System.out.println(cola.poll());

    }

}

/* Queue-> interfaz que representa una cola 
cola-> coleccion de elementos (FIFO)

SINTAXIS-> public interface Queue<E> extends Collecttion<E>
E-> el tipo de dato que va  aguardar la cola
- Queue<String> colaTexto = new LinkedList<>();
- Queue<Interger> colaTexto = new ArrayDeque<>();

*/

