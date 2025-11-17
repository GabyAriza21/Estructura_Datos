package Estruc_Datos.Clase5;

import java.util.Stack;

public class ValidacionCadenasPila {
    public static void main(String[] args) {
        String[] llaves = { "{", "{", "}", "}" };

        // cree una pila de llaves y verifique si las llaves estan
        // completas, es decir, una llave que abre tiene una que cierra

        Stack<String> p = new Stack<>();

        for (int i = 0; i < llaves.length; i++) {
            p.push(llaves[i]);
        }

        System.out.println(p);

        int contador1 = 0, contador2 = 0;

        int tam = p.size();

        for (int i = 0; i < tam; i++) {
            if (p.peek().equals("{")) {
                contador1 += 1;
            } else {
                contador2 += 1;
            }
            p.pop();
        }

        //operador ternario
        System.out.println(contador1 == contador2 ? "equilibrados" : "no equilibrados");

        /*
         * if (contador1 == contador2){
         * Sistem.out.println("equilibrados");
         * } else {
         * System.out.println("no equilibrados");
         * }
         */

    }
}

/*tarea
 * revisar e implementar los metodos que se heredan de la clase vector 
 * hacer un ejercicio donde se hagan las pruebas de cada metodo 
 */
