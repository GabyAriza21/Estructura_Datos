package Estruc_Datos.Clase7;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        // Crear algunas tareas
        Tarea tarea1 = new Tarea("1", "Organizar archivos", 2, System.currentTimeMillis());
        Tarea tarea2 = new Tarea("2", "Responder correos", 3, System.currentTimeMillis());
        Tarea tarea3 = new Tarea("3", "Revisar hojas de cálculo", 1, System.currentTimeMillis());
        Tarea tarea4 = new Tarea("4", "Preparar presentación", 3, System.currentTimeMillis());

        // Agregar tareas al gestor
        gestor.agregarTarea(tarea1); 
        gestor.agregarTarea(tarea2);
        gestor.agregarTarea(tarea3);
        gestor.agregarTarea(tarea4);
        

        gestor.mostrarResumen();

        // Procesar tareas
        gestor.procesarSiguienteTarea();
        gestor.procesarSiguienteTarea();
        gestor.procesarSiguienteTarea();
        gestor.procesarSiguienteTarea();
        gestor.procesarSiguienteTarea(); 

        gestor.mostrarResumen();

        System.out.println("Tarea 1 → " + gestor.consultarEstadoTarea("1"));
        System.out.println("Tarea 2 → " + gestor.consultarEstadoTarea("2"));
        System.out.println("Tarea 3 → " + gestor.consultarEstadoTarea("3"));
        System.out.println("Tarea 4 → " + gestor.consultarEstadoTarea("4"));
        System.out.println("Tarea 5 → " + gestor.consultarEstadoTarea("5"));
    }
}
