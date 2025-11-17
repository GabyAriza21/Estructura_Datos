package Estruc_Datos.Clase2;

import java.util.Arrays;

public class EjecutarEstudiante {
    public static void main(String[] args) {

        // creacion de los objetos
        Estudiante objEst1 = new Estudiante(909876, "juanito", "perez", "ingenieiria", "matematicas");
        Estudiante objEst2 = new Estudiante(909877, "juanita", "perea", "ingenieiria", "fisica");
        Estudiante objEst3 = new Estudiante(909878, "sarita", "prado", "ingenieiria", "quimica");

        System.out.println(objEst1);
        System.out.println(objEst2);
        System.out.println(objEst3);

        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");

        // crear arreglo de objetos
        // int[] a = new int[5]
        Estudiante est[] = new Estudiante[5]; // arreglo de objetos

        est[0] = objEst1;
        est[1] = objEst2;
        est[2] = objEst3;

        // forma2

        est[3] = new Estudiante(789654, "juli", "torres", "derecho", "Constitucional");
        est[4] = new Estudiante(789655, "toño", "zuluaga", "Contaduria", "Financiero");

        System.out.println(Arrays.toString(est));

        System.out.println("--------------------------------------------");

        for (Estudiante estudiante : est) {
            System.out.println(estudiante);
        }

        System.out.println("--------------------------------------------");

        for (int i = 0; i < est.length; i++) {
            System.out.println(est[i]);

        }

        System.out.println(" --------------------------------------------");

        contarEstudiantesPorFacultad(est);
    }

    public static void contarEstudiantesPorFacultad(Estudiante[] estudiantes) {
        String[] Facultades = new String[estudiantes.length];
        int[] conteo = new int[estudiantes.length];
        int cantidadFacultades = 0;

        for (int i = 0; i < estudiantes.length; i++) {
            String Facultad = estudiantes[i].getFacultad();
            int indice = -1;

            // Ver si la facultad ya está registrada
            for (int j = 0; j < cantidadFacultades; j++) {
                if (Facultades[j].equalsIgnoreCase(Facultad)) {
                    indice = j;
                    break;
                }
            }

            // Si no está, agregarla
            if (indice == -1) {
                Facultades[cantidadFacultades] = Facultad;
                conteo[cantidadFacultades] = 1;
                cantidadFacultades++;
            } else {
                conteo[indice]++;
            }
        }

        // Mostrar resultados
        System.out.println("Cantidad de estudiantes por facultad:");
        for (int i = 0; i < cantidadFacultades; i++) {
            System.out.println(Facultades[i] + ": " + conteo[i]);
        }

        contarEstudiantesPorCurso(estudiantes);
        
    }

        public static void contarEstudiantesPorCurso(Estudiante[] estudiantes){
            String[] Cursos = new String[estudiantes.length];
            int[] conteoCursos = new int[estudiantes.length];
            int cantidadCursos = 0;

            for(int i = 0; i < estudiantes.length; i++){
                String Curso = estudiantes[i].getCurso();
                int indiceCurso = -1;

            for(int j = 0; j < cantidadCursos; j++){
                if(Cursos[j].equalsIgnoreCase(Curso)){
                    indiceCurso = j;
                    break;
                }
            }

            if(indiceCurso == -1){
                Cursos[cantidadCursos] = Curso;
                conteoCursos[cantidadCursos] = 1;
                cantidadCursos++;
            } else {
                conteoCursos[indiceCurso]++;
            }
        }

        System.out.println("Cantidad de estudiantes por curso:");
        for(int i = 0; i < cantidadCursos; i++){
            System.out.println(Cursos[i] + ": " + conteoCursos[i]);
        }
    }
}
