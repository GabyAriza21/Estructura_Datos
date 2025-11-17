package Estruc_Datos.Clase6;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicios {

    public static boolean verificarPan (Queue<String>s1, Queue<String>s2){
        String inicio1 = null;
        String fin1 = null; 
        
        String inicio2 = null; 
        String fin2 = null;

        int n1 = s1.size(); 

        for(int i = 0; i < n1; i++){
            String x = s1.poll();
            if(i == 0){
                inicio1 = x; 
            } 
            if (i == n1 - 1){
                fin1 = x; 
            }
            s1.offer(x);
        }

        int n2 = s2.size();

        for(int j = 0; j < n2; j++){
            String y = s2.poll();
            if (j == 0){
                inicio2 = y;
            } 
            if (j == n2 - 1){
                fin2 = y; 
            }
            s2.offer(y);
        }

        boolean iguales = inicio1.equals(inicio2) && fin1.equals(fin2);
        return iguales;  


    }
    public static void main(String[] args) {

        Queue<String> s1 = new LinkedList<>();

        s1.offer("an blanco");
        s1.offer("lechuga");
        s1.offer("pan blanco");

        Queue<String> s2 = new LinkedList<>();

        s2.offer("pan blanco");
        s2.offer("tomate");
        s2.offer("pan blanco");

        System.out.println("Son iguales?:" + verificarPan(s1, s2));


    }
}

