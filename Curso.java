/**
 * Curso.java
 * 
 * Autor: Fernando Hernandez
 * 
 * Descripción: Representa un curso con sus respectivas propiedades y métodos asociados.
 * 
 * Créditos: Este código fue desarrollado por Fernando Hernandez.
 *           Inspirado en el modelo educativo y sus necesidades.
 */

import java.util.List;

public class Curso {
    // Atributos de la clase Curso
    private String codigo;   // Identificador único del curso
    private String nombre;   // Nombre del curso
    private int periodos;    // Número de periodos que dura el curso
    private List<String> dias; // Lista que almacena los días en que se imparte el curso
    private String horario;  // Horario en que se imparte el curso
    private int cantidadEstudiantes; // Número total de estudiantes inscritos en el curso
    private Profesor profesor; // Profesor que imparte el curso

    /**
     * Constructor de la clase Curso.
     * 
     * @param codigo             - Identificador único del curso.
     * @param nombre             - Nombre del curso.
     * @param periodos           - Número de periodos que dura el curso.
     * @param dias               - Días en que se imparte el curso.
     * @param horario            - Horario en que se imparte el curso.
     * @param cantidadEstudiantes- Número total de estudiantes inscritos.
     * @param profesor           - Profesor que imparte el curso.
     */
    public Curso(String codigo, String nombre, int periodos, List<String> dias, String horario, int cantidadEstudiantes, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.periodos = periodos;
        this.dias = dias;
        this.horario = horario;
        this.cantidadEstudiantes = cantidadEstudiantes;
        this.profesor = profesor;
    }

    // A continuación, se definen los métodos getters y setters para cada uno de los atributos de la clase Curso.
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeriodos() {
        return periodos;
    }

    public void setPeriodos(int periodos) {
        this.periodos = periodos;
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
