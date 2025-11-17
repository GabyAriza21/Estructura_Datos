package Estruc_Datos.Clase2;

public class Estudiante {
    // atrubutos clase
    private int id;
    private String nombre;
    private String apellido;
    private String facultad;
    private String curso;

    // constructor clase = MISMO NOMBRE DE LA CLASE
    public Estudiante(int id, String nombre, String apellido, String facultad, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public int getId() {
        return id;
    }

    public String getFacultad() {
        return facultad;
    }

    public void matricularCursos(int id, String[] cursos) {
        String cad = "";
        for (int i = 0; i < cursos.length; i++) {
            cad += cursos[i] + " ";
        }
        System.out.println("id: " + id + "Cursos Matriculados: " + cad);
    }

    public String toString() {
        return "Estudiante { id:" + id +
                " Nombre: " + nombre +
                "Apellido: " + apellido +
                " Facultad: " + facultad +
                " Curso: " + curso + " }"; // maquetar(estetica)
    }

    // implementar el metodo +matricularCursos(id:int, cursos[]:String):void
    // implementar un metodo que permita saber cuantos estudiantes hay en cada
    // facultad
    // implementar un metodo que permita saber cuantos estudiantes hay en cad curso
}