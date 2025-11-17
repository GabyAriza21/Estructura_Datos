package Estruc_Datos.Clase3;

public class EjecutarLibro {
    public static void main(String[] args) {
        Libro[] L = new Libro[5];

        L[0] = new Libro("100 años de soledad", "Gabriel Garcia Marquez", 55000);
        L[1] = new Libro("El amor en los tiempos del colera", "Gabriel Garcia Marquez", 60000);
        L[2] = new Libro("Cien años de perdon", "Isabel Allende", 40000);
        L[3] = new Libro("La casa de los espiritus", "Isabel Allende", 45000);
        L[4] = new Libro("El principito", "Antoine de Saint", 30000);

        // muestra todos los libros del arreglo
        System.out.println("Lista libros:");
        for (Libro libro : L) { // recorre todo el arreglo
            System.out.println(libro); // llama al metodo toString()
        }

        // muestra el precio total de los libros
        int total = calcularPrecioTotal(L); // llama al metodo
        System.out.println("El precio total de los libros es: " + total);

        // filtra los libros por precio mayor a 45000
        System.out.println("Libros con precio mayor a 45000:");
        Libro[] resultado = filtrarPorPrecio(L, 45000);// llama al metodo y tiene en cuenta el valor de referencia
        for (Libro libro : resultado) { // recorre el arreglo
            System.out.println(libro);// muestra el libro filtado
        }

        // ordena los libros por precio (menor a mayor)
        ordenarPorPrecio(L); // se llama al metodo ordenarPorPrecio
        System.out.println("Libros ordenados por precio (menor a mayor):");
        for (Libro libro : L) { // recorre
            System.out.println(libro);// muestra el libro
        }

        // Actualiza el precio de un libro dado su título
        actualizarPrecio(L, "El principito", 35000);// se hace el cambio
        System.out.println("Nuevo precio:");// muestra el nuevo precio
        for (Libro libro : L) { // recorre el arreglo
            System.out.println(libro);// muestra el libro
        }

        // busqueda de libro por titulo
        Libro libroEncontrado = buscarPorTitulo(L, "Cien años de perdon");// se busca el libro
        if (libroEncontrado != null) { // si lo encuentra
            System.out.println("Libro encontrado: " + libroEncontrado);
        } else {
            System.out.println("Libro no encontrado");// si no lo encuentra

        }
    }

    // metodo que calcula el precio total de los libros
    public static int calcularPrecioTotal(Libro[] libros) { // metodo que devuelve numero entero y recibe un arreglo de
                                                            // libros
        int suma = 0; // donde se acumula el total de los precios
        for (int i = 0; i < libros.length; i++) { // recorre la posicion del arreglo de libros
            suma += libros[i].getPrecio(); // accede al libro en la pocision i, agarra el precio del libro y acumula
        }
        return suma;
    }

    // metodo que filtra los libros por precio mayor a un valor dado
    public static Libro[] filtrarPorPrecio(Libro[] libros, int valor) { // devuelve un arreglo de libros
        int contador = 0;
        for (Libro libro : libros) { // recorre todo el arreglo
            if (libro.getPrecio() > valor) { // si el libre tiene un precio mayor al valor
                contador++; // incrementa el contador
            }
        }

        Libro[] filtrados = new Libro[contador];// nuevo arreglo, con el tamaño de contador
        int i = 0;
        for (Libro libro : libros) { // recorre todo el arreglo
            if (libro.getPrecio() > valor) { // si cumple la condicion
                filtrados[i] = libro; // agrega el libro al nuevo arreglo
                i++;// se incrementa para pasar a la siguiente posicion
            }
        }

        return filtrados; // devuelve el resultado
    }

    // metodo que ordena los libros por precio (menor a mayor) ordenamiento de
    // burbuja
    public static void ordenarPorPrecio(Libro[] libros) { // recibe arreglo de objetos tipo libro
        int n = libros.length; // cuantos elementos hay en el arreglo a ordenar
        for (int i = 0; i < n - 1; i++) { // cuantas veces recorre el algoritmo por el arreglo, pone el mas alto al
                                          // final
            for (int j = 0; j < n - i - 1; j++) { // recorre desde el principio hasta el ultimo no ordenado
                if (libros[j].getPrecio() > libros[j + 1].getPrecio()) { // hace comparacion con el de al lado para
                                                                         // ordenar o deja ahi
                    // Intercambiar
                    Libro temp = libros[j]; // guarda el libro actual en temp
                    libros[j] = libros[j + 1]; // mueve el libro siguiente a la posicion actual
                    libros[j + 1] = temp; // pone el libro guardado en temp en la posicion siguiente
                }
            }
        }
    }

    public static void actualizarPrecio(Libro[] libros, String titulo, int nuevoPrecio) {
        for (Libro libro : libros) {// recorre el arreglo
            if (libro.getTitulo().equalsIgnoreCase(titulo)) { // busca el libro
                libro.setPrecio(nuevoPrecio);// actualiza el precio
                return;
            }
        }
    }

    public static Libro buscarPorTitulo(Libro[] libros, String titulo) {
        for (Libro libro : libros) { // recorre el arreglo
            if (libro.getTitulo().equalsIgnoreCase(titulo)) { // compara el titulo
                return libro; // devuelve el libro encontrado
            }
        }
        return null; // si no encuentra el libro
    }
}
