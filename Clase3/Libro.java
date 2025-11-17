package Estruc_Datos.Clase3;

public class Libro {
    private String titulo;
    private String autor;
    private int precio;

    public Libro(String titulo, String autor, int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }
    public int getPrecio(){
        return precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public String toString() {
        return "Libro { Titulo: " + titulo +
                " Autor: " + autor +
                " Precio: " + precio + "}";
    }
}
