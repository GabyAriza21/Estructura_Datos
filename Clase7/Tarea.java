package Estruc_Datos.Clase7;

public class Tarea {
    private String id;
    private String descripcion;
    private int prioridad;
    private long tiempoLLegada;

    public Tarea(String id, String descripcion, int prioridad, long tiempoLLegada) {
        this.id = id;
        this.descripcion = descripcion;
        // solamente toma los valores de 1 - 3
        if (prioridad < 1 || prioridad > 3) {
            this.prioridad = 1; // prioridad por defecto
        } else {
            this.prioridad = prioridad;
        }
        this.tiempoLLegada = tiempoLLegada;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public long getTiempoLLegada() {
        return tiempoLLegada;
    }

    public String toString() {
        
        return "Tarea{" +
                "id='" + id + '\'' +
                ", desc='" + descripcion + '\'' +
                ", prioridad=" + prioridad +
                ", llegada=" + tiempoLLegada +
                '}';
    }

}
