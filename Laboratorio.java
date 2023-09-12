/**
 * Laboratorio.java
 * 
 * Autor: Fernando Hernandez
 * 
 * Descripción: Representa un laboratorio con una matriz de horarios para cursos y
 *              métodos asociados para gestionar estos cursos.
 * 
 * Créditos: Este código fue desarrollado por Fernando Hernandez.
 *           Inspirado en las necesidades de gestión de un laboratorio educativo.
 */

import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private Curso[][] horarios; // Matriz que representa los días y horarios.
    private int capacidad; // Capacidad máxima del laboratorio.

    // Constructor
    public Laboratorio(int capacidad) {
        this.capacidad = capacidad;
        this.horarios = new Curso[7][14]; // 7 días a la semana y 14 horas de operación por día (7 a.m. a 9 p.m.).
    }

    public boolean asignarCurso(Curso curso) {
        int diaIndex = convertirDia(curso.getDias().get(0)); // Asume que el curso solo tiene un día. Si hay múltiples días, este método necesita ajuste.
        int horaIndex = convertirHora(curso.getHorario());

        if (horarios[diaIndex][horaIndex] == null) {
            horarios[diaIndex][horaIndex] = curso;
            return true;
        }
        return false;
    }

    public Curso visualizarCurso(String dia, String hora) {
        int diaIndex = convertirDia(dia);
        int horaIndex = convertirHora(hora);
        return horarios[diaIndex][horaIndex];
    }

    public void eliminarCurso(String dia, String hora) {
        int diaIndex = convertirDia(dia);
        int horaIndex = convertirHora(hora);
        horarios[diaIndex][horaIndex] = null;
    }

    public boolean cambiarHorarioCurso(Curso curso, String nuevoDia, String nuevaHora) {
        int diaAntiguo = convertirDia(curso.getDias().get(0)); 
        int horaAntiguo = convertirHora(curso.getHorario());
        int diaNuevo = convertirDia(nuevoDia);
        int horaNuevo = convertirHora(nuevaHora);

        if (horarios[diaNuevo][horaNuevo] == null) {
            horarios[diaAntiguo][horaAntiguo] = null; // Desasigna del horario antiguo
            horarios[diaNuevo][horaNuevo] = curso; // Asigna al nuevo horario
            return true;
        }
        return false;
    }

    public Profesor mostrarProfesor(String dia, String hora) {
        Curso curso = visualizarCurso(dia, hora);
        if (curso != null) {
            return curso.getProfesor();
        }
        return null;
    }

    public List<String> diasProfesor(Profesor profesor) {
        List<String> dias = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                if (horarios[i][j] != null && horarios[i][j].getProfesor().equals(profesor)) {
                    dias.add(convertirIndiceDia(i));
                }
            }
        }
        return dias;
    }

    public double responsabilidadProfesor(Profesor profesor) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                if (horarios[i][j] != null && horarios[i][j].getProfesor().equals(profesor)) {
                    count++;
                }
            }
        }
        return (double) count / (7 * 14) * 100; // Devuelve el porcentaje de responsabilidad
    }

    public void limpiarHorarios() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                horarios[i][j] = null;
            }
        }
    }

    // Métodos añadidos:
    public int getCapacidad() {
        return this.capacidad;
    }

    public Curso getCursoEnHorario(int diaIndex, int horaIndex) {
        return horarios[diaIndex][horaIndex];
    }

    // Métodos de utilidad para convertir día/hora a índices 
    private int convertirDia(String dia) {
        return 0;
    }

    private int convertirHora(String hora) {
        return 0;
    }

    private String convertirIndiceDia(int indice) {
        return "lunes";
    }
}
