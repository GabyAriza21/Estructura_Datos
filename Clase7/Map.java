package Estruc_Datos.Clase7;

import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        
        //objeto 
        //claves -> nombres de los empelados (String)
        //valor -> num del empleado (Integer)
        HashMap<String, Integer> numEmpleados = new HashMap<>(); //mapa de String a Integer

        //Map solito es la interfaz, HashMap es una implementacion de Map

        //agregar elementos al HashMap (.put)
        numEmpleados.put("Gabriela",2006);
        numEmpleados.put("Claudia",2007);
        numEmpleados.put("Walter",2008);
        numEmpleados.put("Ivonne",2009);
        numEmpleados.put("Kathe",2010);

        System.out.println("Empleados Identificdos: " + numEmpleados);
        //no muestra los elementos en orden 

        //obtener un valor especifico (.get)
        System.out.println("Num Claudia: " + numEmpleados.get("Claudia"));

        //verificar si una clave existe (.containsKey)
        System.out.println("Claudia en el HashMap?: " + numEmpleados.containsKey("Claudia")); //verdadero porque claudia esta en el mapa
        System.out.println("Manuela en el HashMap?: " + numEmpleados.containsKey("Manuela")); //falso porque manuela no esta en el mapa 

        //verificar si hay un valor especifico (.containsValue)
        System.out.println("Esta el valor 2010?: " + numEmpleados.containsValue(2010));//verdadero
        System.out.println("Esta el valor 2012?: " + numEmpleados.containsValue(2012));//falso 

        //actualizar valor en clave existente (.put)
        numEmpleados.put("Kathe", 2011);
        System.out.println("Valor Kathe actualizado: " + numEmpleados); 

        //forma de actualizar valor existente, si no existe la clave en el mapa no hace nada
        numEmpleados.replace("Dalila", 2022); 

        //agregar un par clave-valor que especifique, actualiza el HasMap si no esta ya en el mapa (.puIfAbsent)
        numEmpleados.putIfAbsent("Natali", 2025); 
        System.out.println("Intento de agregar Natali: " + numEmpleados);

        //eliminar un par clave-valor (.remove)
        numEmpleados.remove("Kathe"); 
        System.out.println("Elimina Kathe: " + numEmpleados);

        //un mapa es una coleccion de pares clave-valor, como una tabla de busqueda





    }
    
}
