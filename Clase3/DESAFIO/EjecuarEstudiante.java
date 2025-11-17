package Estruc_Datos.Clase3.DESAFIO3;

public class EjecuarEstudiante {
    public static void main(String[] args) {
        Estudiante[] E = new Estudiante[3];

        E[0] = new Estudiante("Gaby", true, 4.5);
        E[1] = new Estudiante("Linda", true, 3.8);
        E[2] = new Estudiante("paul", true, 2.9);

        // muestra la lista de estudiantes
        System.out.println("Lista estudiantes:");
        for (Estudiante estudiante : E) { //recorre cada estudiante del arreglo E
            System.out.println(estudiante); //llama al toString
        }

        // agregar estudiantes
        E = agregarEstudiante(E, new Estudiante("samuel", true, 4.3));
        E = agregarEstudiante(E, new Estudiante("Zambrano", true, 2.0));
        System.out.println("\nLista estudiantes actualizada: ");
        for (Estudiante estudiante : E) { //recorre el aaarreglo actualizado
            System.out.println(estudiante);
        }

        // eliminar estudiante
        E = eliminarEstudiante(E, E[2]);//crea un nuevo arreglo sin el estudiante en la posicion 2
        System.out.println("\nLista estudiantes actualizada: ");
        for (Estudiante estudiante : E) { //recorre el arreglo actualizado
            System.out.println(estudiante); //muestra la lista 
        }

        // busqueda estudiante por nombre
        Estudiante estudianteBuscado = buscarEstudiante(E, "Linda");
        if (estudianteBuscado != null) { //si lo encuentra
            System.out.println("Estudiante Buscado: " + estudianteBuscado); //lo imprime
        } else {
            System.out.println("Estudiante no encontrado");// si no lo encuentra
        }
    }

    // agregar estudiante
    public static Estudiante[] agregarEstudiante(Estudiante[] estudiantes, Estudiante nuevo) {
        Estudiante[] nuevoArreglo = new Estudiante[estudiantes.length + 1]; //crea un arreglo mas
        for (int i = 0; i < estudiantes.length; i++) { //recorre el arreglo original y 
            nuevoArreglo[i] = estudiantes[i]; //copia al estudiante de la posicion i al nuevo arreglo
        }
        nuevoArreglo[estudiantes.length] = nuevo; //del tamaño anterior asigna al nuevo estudiante
        return nuevoArreglo;//devuelve el nuevo arreglo
    }

    // eliminar estudiante
    public static Estudiante[] eliminarEstudiante(Estudiante[] estudiantes, Estudiante eliminado) {
        Estudiante[] nuevoArreglo = new Estudiante[estudiantes.length - 1]; //quita un arreglo 
        int j = 0; //nuevo arreglo 
        for (int i = 0; i < estudiantes.length; i++) { // recorre los estudiantes del arreglo original con indice i
            if (!estudiantes[i].equals(eliminado)) {//cpmpara si el estudiante en i no es igual al que se quiere eliminar
                nuevoArreglo[j] = estudiantes[i];//toma al estudiante actual en el nuevo arreglo en j, que es el indice del arreglo mas pequeño
                j++; //incrementa j para que el proxiomo que tome se ponga en la siguiente posicion
            }
        }
        return nuevoArreglo;//devuelve el resultado
    }

    // busca estudiante
    public static Estudiante buscarEstudiante(Estudiante[] estudiantes, String nombre) {
        for (Estudiante est : estudiantes) {
            if (est.getNombre().equalsIgnoreCase(nombre)) {
                return est;
            }
        }
        return null;
    }
}
