/**
 * Main.java
 * 
 * Autor: Fernando Hernandez
 * 
 * Descripción: Programa principal para gestionar cursos, profesores y horarios en un laboratorio educativo.
 * 
 * Créditos: Este código fue desarrollado por Fernando Hernandez.
 *           Inspirado en las necesidades de gestión de un laboratorio educativo.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Laboratorio lab = new Laboratorio(30); // Suponiendo una capacidad de 30 para el laboratorio.
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarCurso();
                    break;
                case 2:
                    visualizarCurso();
                    break;
                case 3:
                    eliminarCurso();
                    break;
                case 4:
                    verificarCapacidad();
                    break;
                case 5:
                    verificarDobleCapacidad();
                    break;
                case 6:
                    cambiarHorarioCurso();
                    break;
                case 7:
                    lab.limpiarHorarios();
                    System.out.println("Horarios limpiados para el nuevo semestre.");
                    break;
                case 8:
                    mostrarProfesor();
                    break;
                case 9:
                    listarDiasProfesor();
                    break;
                case 10:
                    calcularResponsabilidad();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("Selecciona una opción:");
        System.out.println("1. Agregar curso");
        System.out.println("2. Visualizar curso");
        System.out.println("3. Eliminar curso");
        System.out.println("4. Verificar capacidad del laboratorio");
        System.out.println("5. Verificar si estudiantes superan el doble de la capacidad");
        System.out.println("6. Cambiar horario de curso");
        System.out.println("7. Limpiar horarios para el nuevo semestre");
        System.out.println("8. Mostrar profesor de un horario específico");
        System.out.println("9. Listar días y horarios de un profesor");
        System.out.println("10. Calcular responsabilidad de un profesor");
        System.out.println("0. Salir");
    }

    private static void visualizarCurso() {
        System.out.print("Introduce el día del curso que quieres visualizar: ");
        String dia = scanner.nextLine();
        System.out.print("Introduce el horario del curso que quieres visualizar (ejemplo: '7:00 am'): ");
        String hora = scanner.nextLine();
        Curso curso = lab.visualizarCurso(dia, hora);
        if (curso != null) {
            System.out.println("Detalles del Curso:");
            System.out.println("Código: " + curso.getCodigo());
            System.out.println("Nombre: " + curso.getNombre());
        } else {
            System.out.println("No hay un curso programado para ese día y hora.");
        }
    }
    
    private static void eliminarCurso() {
        System.out.print("Introduce el día del curso que quieres eliminar: ");
        String dia = scanner.nextLine();
        System.out.print("Introduce el horario del curso que quieres eliminar (ejemplo: '7:00 am'): ");
        String hora = scanner.nextLine();
        lab.eliminarCurso(dia, hora);
        System.out.println("Curso eliminado del horario.");
    }
    
    private static void verificarCapacidad() {
        System.out.print("Introduce el día y hora del curso para verificar la capacidad: ");
        String dia = scanner.nextLine();
        String hora = scanner.nextLine();
        Curso curso = lab.visualizarCurso(dia, hora);
        if (curso != null) {
            if (curso.getCantidadEstudiantes() > lab.getCapacidad()) {
                System.out.println("Hay más estudiantes inscritos que el espacio disponible en el laboratorio.");
            } else {
                System.out.println("Hay espacio suficiente en el laboratorio para este curso.");
            }
        } else {
            System.out.println("No hay un curso programado para ese día y hora.");
        }
    }
    
    private static void verificarDobleCapacidad() {
        System.out.print("Introduce el día y hora del curso para verificar la capacidad: ");
        String dia = scanner.nextLine();
        String hora = scanner.nextLine();
        Curso curso = lab.visualizarCurso(dia, hora);
        if (curso != null) {
            if (curso.getCantidadEstudiantes() > 2 * lab.getCapacidad()) {
                System.out.println("La cantidad de estudiantes inscritos es más del doble de la capacidad del laboratorio.");
            } else {
                System.out.println("La cantidad de estudiantes está dentro del rango permitido.");
            }
        } else {
            System.out.println("No hay un curso programado para ese día y hora.");
        }
    }
    
    private static void cambiarHorarioCurso() {
        System.out.print("Introduce el código del curso que quieres cambiar de horario: ");
        String codigo = scanner.nextLine();
        Curso curso = null; 
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                if (lab.getCursoEnHorario(i, j) != null && lab.getCursoEnHorario(i, j).getCodigo().equals(codigo)) {
                    curso = lab.getCursoEnHorario(i, j);
                    break;
                }
            }
            if (curso != null) break;
        }
        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }
        System.out.print("Introduce el nuevo día para el curso: ");
        String nuevoDia = scanner.nextLine();
        System.out.print("Introduce el nuevo horario para el curso (ejemplo: '7:00 am'): ");
        String nuevaHora = scanner.nextLine();
        if (lab.cambiarHorarioCurso(curso, nuevoDia, nuevaHora)) {
            System.out.println("Horario del curso actualizado exitosamente.");
        } else {
            System.out.println("No se pudo cambiar el horario. Verifica que el nuevo horario esté disponible.");
        }
    }
    
    private static void mostrarProfesor() {
        System.out.print("Introduce el día y hora para ver al profesor encargado: ");
        String dia = scanner.nextLine();
        String hora = scanner.nextLine();
        Profesor profesor = lab.mostrarProfesor(dia, hora);
        if (profesor != null) {
            System.out.println("Profesor: " + profesor.getNombreCompleto());
        } else {
            System.out.println("No hay un profesor programado para ese día y hora.");
        }
    }
    
    private static void listarDiasProfesor() {
        System.out.print("Introduce el nombre del profesor para listar sus días y horarios: ");
        String nombreProfesor = scanner.nextLine();
        Profesor profesor = new Profesor(nombreProfesor, "", "", "");
        List<String> dias = lab.diasProfesor(profesor);
        System.out.println("El profesor " + nombreProfesor + " da clases en los siguientes días:");
        for (String dia : dias) {
            System.out.println(dia);
        }
    }
    
    private static void calcularResponsabilidad() {
        System.out.print("Introduce el nombre del profesor para calcular su responsabilidad: ");
        String nombreProfesor = scanner.nextLine();
        Profesor profesor = new Profesor(nombreProfesor, "", "", "");
        double responsabilidad = lab.responsabilidadProfesor(profesor);
        System.out.println("El profesor " + nombreProfesor + " tiene una responsabilidad del " + responsabilidad + "% en el laboratorio.");
    }

    private static void agregarCurso() {
        System.out.print("Introduce el código del curso: ");
        String codigo = scanner.nextLine();
        System.out.print("Introduce el nombre del curso: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la cantidad de periodos del curso: ");
        int periodos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Introduce los días en que se imparte el curso (ejemplo: 'Lunes'): ");
        List<String> dias = new ArrayList<>();
        String dia = scanner.nextLine();
        dias.add(dia);
        // Aquí asumimos que cada curso solo tiene un día. Si un curso puede tener múltiples días, necesitarás un bucle para agregar todos.
        System.out.print("Introduce el horario del curso (ejemplo: '7:00 am'): ");
        String horario = scanner.nextLine();
        System.out.print("Introduce la cantidad de estudiantes inscritos en el curso: ");
        int cantidadEstudiantes = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Introduce el nombre completo del profesor: ");
        String nombreProfesor = scanner.nextLine();
        System.out.print("Introduce el carné del profesor: ");
        String carne = scanner.nextLine();
        System.out.print("Introduce el correo del profesor: ");
        String correo = scanner.nextLine();
        System.out.print("Introduce el teléfono del profesor: ");
        String telefono = scanner.nextLine();
        
        Profesor profesor = new Profesor(nombreProfesor, carne, correo, telefono);
        Curso curso = new Curso(codigo, nombre, periodos, dias, horario, cantidadEstudiantes, profesor);
        
        if (lab.asignarCurso(curso)) {
            System.out.println("Curso agregado exitosamente.");
        } else {
            System.out.println("No se pudo agregar el curso. Es posible que el horario ya esté ocupado.");
        }
    }
    
}
