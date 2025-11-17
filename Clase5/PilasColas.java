package Estruc_Datos.Clase5;

import java.util.Stack;

public class PilasColas {
    public static void main(String[] args) {
        //pilas en java (stack)
        //Crea objeto pila de tipo Stack
        Stack<Integer> pila = new Stack<>();

        //verifica si la pila esta vacia
        System.out.println("La pila esta vacia?" + pila.empty());

        //insertan 5 numeros enteros a la pila
        pila.push(10);
        pila.push(20);
        pila.push(5);
        pila.push(9);
        pila.push(35);

        //verifica si la pila esta vacia
        System.out.println("La pila esta vacia?" + pila.empty());

        //se imprime la pila
        System.out.println(pila);

        //se obtiene el elemento en la cima de la pila sin removerlo
        System.out.println(pila.peek());

        //se remueve el ultimo elemento de la pila
        pila.pop();

        //se obtiene el elemento en la cima de la pila sin removerlo
         System.out.println(pila.peek());

         //se imprime la pila 
         System.out.println(pila);

         //se obtiene la posicion de cada elemento dento de la pila
         System.out.println(pila.search(9));
         System.out.println(pila.search(5));
         System.out.println(pila.search(20));
         System.out.println(pila.search(10));
         
         //buscamos un elemento que no esta dentro de la pila 
         System.out.println(pila.search(50));
    }
     
    
}
