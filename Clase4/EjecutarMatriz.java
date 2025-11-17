package Estruc_Datos.Clase4;

import java.util.Scanner;

public class EjecutarMatriz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //objeto para leer datos por teclado
        MatrizCasillero mc = new MatrizCasillero(10, 5); // crea la matriz de casilleros 3x3

        int opcion; //para controlar el menu
        do {
            //muestra el menu principal
            System.out.println("\n MENÚ PRINCIPAL ");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Mostrar mapa de casilleros (I = Libre, O = Ocupado)");
            System.out.println("3. Consultar casillero");
            System.out.println("4. Liberar casillero");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt(); //lee la opcion
            sc.nextLine();//limpia el buffer de teclado

            switch (opcion) {
                case 1: //registra paquete
                    System.out.print("Ingrese destinatario: ");
                    String destinatario = sc.nextLine();
                    System.out.print("Ingrese fecha de ingreso: ");
                    String fecha = sc.nextLine();
                    Paquete paquete = new Paquete(destinatario, fecha);
                    mc.registrarPaquete(paquete);
                    break;

                case 2://muestra mapa
                    System.out.println(mc.mostrarCasilleros());
                    break;

                case 3://consulta casillero
                    System.out.print("Ingrese num del casillero: ");
                    int id = sc.nextInt();
                    mc.consultarCasillero(id);
                    break;

                case 4://libera casillero
                    System.out.print("Ingrese num del casillero a liberar: ");
                    int liberarId = sc.nextInt();
                    mc.liberarCasillero(liberarId);
                    break;

                case 5:
                    System.out.println(" Saliendo del sistema...");
                    break;

                default:
                    System.out.println(" Opción inválida.");
            }

        } while (opcion != 5); //repite hasta que elija salir

        sc.close(); //cierra el scanner
    }
}
