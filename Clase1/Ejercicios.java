package Estruc_Datos.Clase1;

public class Ejercicios {
    public static void main(String[] args) {
        // Sumar los elementos de un arreglo de enteros
        int[] arreglo = { 7, 10, 11, 15, 8 }; // arreglo: almacena los valores
        int suma = 0; // variable entera simple: almacena el resultado de la suma

        for (int i = 0; i < arreglo.length; i++) { // bucle for: recorre los elementos del arreglo 1*1
            suma += arreglo[i]; // operación asignación compuesta
        }
        System.out.println("Suma: " + suma);

        System.out.println("-----------------------------------------");

        // Obtener el promedio de un arreglo de enteros
        int[] arreglo2 = { 25, 26, 78, 41, 10 }; // arreglo
        int suma2 = 0; // variable entera simple

        for (int i = 0; i < arreglo2.length; i++) { // bucle for
            suma2 += arreglo2[i]; // operación asiganción compuesta
        }
        double promedio = suma2 / arreglo2.length; // calcula el promedio
        System.out.println("promedio: " + promedio);

        System.out.println("-------------------------------------------");

        // Obtener los numeros repetidos de un arreglo de enteros
        int[] arreglo3 = { 11, 34, 11, 22, 34 };// arreglo

        System.out.println("Los repetidos son: ");

        for (int i = 0; i < arreglo3.length; i++) { // bucle for
            for (int j = i + 1; j < arreglo3.length; j++) { // bucle for que recorre la posición siguiente a i hasta el
                                                            // fin
                if (arreglo3[i] == arreglo3[j]) { // si el valor en i = al valor en j hay numero repetido
                    System.out.println(arreglo3[i]); // muestra el numero repetido
                    break;// cuando encuentra repetido sale del segundo for
                }
            }
        }
        System.out.println("-------------------------------------------");

        // Obtener el mayor y el menor de un arreglo de enteros
        int[] arreglo4 = { 1, 4, 6, 3, 8, 9, 6, 17 }; // arreglo
        int mayor = arreglo4[0]; // incializando variable con el 1er elemento del arreglo4
        int menor = arreglo4[0];

        for (int i = 0; i < arreglo4.length; i++) { // bucle for
            if (arreglo4[i] > mayor) { // si el elemento de arreglo4[i] es mayor que el elemento de la variable mayor
                                       // se cambia el valor
                mayor = arreglo4[i];
            }
            if (arreglo4[i] < menor) { // si el elemento de arreglo4[i] es menor que el elemento de la variable menor
                                       // se cambia el valor
                menor = arreglo4[i];
            }
        }
        System.out.println("El mayor es: " + mayor);
        System.out.println("El menor es: " + menor);
    }
}
