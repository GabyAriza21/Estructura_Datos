package Estruc_Datos.Clase7;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class GestorTareas {

    private Stack<Tarea> pilaPrioritaria; // tareas urgentes (prioridad 3)
    private Queue<Tarea> colaEspera; // tareas normales (prioridad 1 o 2)
    private HashMap<String, String> registroTrazabilidad; // tareas completadas

    // constructor: tareas vacias


    public GestorTareas() {
        this.pilaPrioritaria = new Stack<>();
        this.colaEspera = new java.util.LinkedList<>();
        this.registroTrazabilidad = new HashMap<>();
    }

    public void validarTareas(){
        if (pilaPrioritaria == null || colaEspera == null){
            throw new IllegalStateException("Estructura no inicializada");
        }
        if(pilaPrioritaria.isEmpty() && colaEspera.isEmpty()){
            throw new IllegalStateException("No se puede iniciar con estructuras vacias");
        }
    }

    // tarea segun su proioridad
    public void agregarTarea(Tarea tarea) {
        if (tarea.getPrioridad() == 3) {
            pilaPrioritaria.push(tarea); // si tiene una alta prioridad se agerga a la pila
            System.out.println("Tarea prioritaria agregada: " + tarea);
        } else {
            colaEspera.add(tarea);// si no es de alta prioridad se agrega a la cola
            System.out.println("Tarea en espera agregada: " + tarea);
        }
    }

    // siguente tarea a ejecutar
    public Tarea procesarSiguienteTarea() {
        validarTareas();
        Tarea tareaProcesada = null;

        if (!pilaPrioritaria.isEmpty()) {
            tareaProcesada = pilaPrioritaria.pop();
        } else if (!colaEspera.isEmpty()) {
            tareaProcesada = colaEspera.poll();
        }else{
            System.out.println("No hay tareas para procesar.");
            return null; 
        }
        long tiempoProcesamiento = System.currentTimeMillis();
        String info = "Completada - Procesada en: " + new java.util.Date(tiempoProcesamiento)
                      + " (Llegó en: " + new java.util.Date(tareaProcesada.getTiempoLLegada()) + ")";
        registroTrazabilidad.put(tareaProcesada.getId(), info);

        System.out.println("Tarea procesada: " + tareaProcesada);
        return tareaProcesada;
    }

    // estado de la tarea 
    public String consultarEstadoTarea(String id) {
        if (registroTrazabilidad.containsKey(id)) {
            return "Completada" + registroTrazabilidad.get(id);
        }

        // busca en la pila prioritaria
        for (Tarea tarea : pilaPrioritaria) {
            if (tarea.getId().equals(id)) {
                return "En espera (Prioritaria)";
            }
        }

        // busca en la cola de espera
        for (Tarea tarea : colaEspera) {
            if (tarea.getId().equals(id)) {
                return "En espera (Normal)";
            }
        }
        return "ID no encontrada";
    }

    public void mostrarResumen(){
        System.out.println("----- ESTADO DEL GESTOR -----");
        System.out.println("Tareas Prioritarias en Pila: " + pilaPrioritaria.size());
        System.out.println("Tareas en Cola de Espera: " + colaEspera.size());
        System.out.println("Tareas Completadas: " + registroTrazabilidad.size());
        System.out.println("-----------------------------");
    }
}
