package Estruc_Datos.Clase4;

public class Paquete {

     //el paquete tiene un destinatario y una fecha de ingreso
    private String destinatario; //para quien es el paquete
    private String fechaIngreso; //cuando llego

    //Constructor: crea el objeto con fecha y destinatario
    public Paquete(String destinatario, String fechaIngreso) {
        this.destinatario = destinatario; //atributo de la clase
        this.fechaIngreso = fechaIngreso; //se inicializa con lo que llega como parametro
    }

    public String getDestinatario() { //obtiene el valor del atributo
        return destinatario;
    }

    public String getFechaIngreso() { //obtiene el valor del atributo 
        return fechaIngreso;
    }

    //imprime un objeto paquete
    public String toString() {
        return "Paquete { Destinatario: " + destinatario +
                " Fecha de ingreso: " + fechaIngreso + "}";
    }
}
