/**
 * Profesor.java
 * 
 * Autor: Fernando Hernandez
 * 
 * Descripción: Representa un profesor con sus propiedades y métodos asociados.
 * 
 * Créditos: Este código fue desarrollado por Fernando Hernandez.
 *           Inspirado en el modelo educativo y sus necesidades.
 */

public class Profesor {
    // Atributos de la clase Profesor
    private String nombreCompleto;  // Nombre completo del profesor
    private String carne;           // Identificador único (carné) del profesor
    private String correo;         // Dirección de correo electrónico del profesor
    private String telefono;       // Número de teléfono del profesor

    /**
     * Constructor de la clase Profesor.
     * 
     * @param nombreCompleto - Nombre completo del profesor.
     * @param carne          - Identificador único (carné) del profesor.
     * @param correo         - Dirección de correo electrónico del profesor.
     * @param telefono       - Número de teléfono del profesor.
     */
    public Profesor(String nombreCompleto, String carne, String correo, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.carne = carne;
        this.correo = correo;
        this.telefono = telefono;
    }

    // A continuación, se definen los métodos getters y setters para cada uno de los atributos de la clase Profesor.
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
