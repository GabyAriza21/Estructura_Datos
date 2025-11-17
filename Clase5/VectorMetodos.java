package Estruc_Datos.Clase5;

import java.util.Stack;
import java.util.Vector;

public class VectorMetodos {
    public static void main(String[] args) {
        
        //metodo add -> añade un elemento al final del vector
        Vector<String> frutas = new Vector<>(); //define el Vector de tipo texto

        //añade la frutas al vector -> primero en entrar, primero en salir  
        frutas.add("banano"); 
        frutas.add("fresa");
        frutas.add("manzana");

        //muestra el vector lleno 
        System.out.println("Vector frutas inicial: " + frutas);

        frutas.add("papaya");

        System.out.println("Vector frutas nuevo elemento: " + frutas);

        //agregar un elemento en la posicion indicada
        frutas.add(2,"maracuya");
        
        System.out.println("Vector frutas nuevo elemento en posicion 2: " + frutas);

        //agregar una nueva coleccion

        Stack<String> frutass1 = new Stack<>();

        frutass1.add("arandanos");
        frutass1.add("carambolo");
        frutass1.add("piña");

        boolean nuevaLista = frutas.addAll(frutass1);

        System.out.println("Vector con nueva lista agregada: " + frutas);

        //agregar una nueva coleccion en una posicion especifica

        frutas.addAll(3, frutass1);

        System.out.println("Vector con posicion/nueva lista agregada: " + frutas);

        //agergar elemento al final del vector

        //nuevo vector
        Vector<String> frutass2 = new Vector<>(2);
        
        //elementos del vector no vacio
        frutass2.addElement("pomelo");
        frutass2.addElement("toronja");

        System.out.println("vector original: " + frutass2);
        System.out.println("Tamaño vector: " + frutass2.size());
        System.out.println("Capacidad vector: " + frutass2.capacity());

        frutass2.addElement("guayaba");

        System.out.println("vector actualizado: " + frutass2);
        System.out.println("Tamaño vector: " + frutass2.size());
        System.out.println("Capacidad vector: " + frutass2.capacity());


        System.out.println("----------Stack----------");

        //metodo add en un stack 
        Stack<String> frutas2 = new Stack<>(); 

        //añade frutas al stack
        frutas2.push("kiwi");
        frutas2.push("mango");

        System.out.println(frutas2);

        frutas2.add("sandia");

        System.out.println(frutas2);

        frutas2.add(2,"ciruela");
        
        System.out.println(frutas2);

        Vector<String> fruta = new Vector<>();

        fruta.add("limon");
        fruta.add("Naranja");

        boolean agregar2 = frutas2.addAll(fruta);

        System.out.println("Stack con nueva lista:" + frutas2);




        





    }
    
}
