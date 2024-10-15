public final class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private static Persona instanciaUnica;

    private Persona() {
    }

    public static Persona getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Persona();
        }
        return instanciaUnica;
    }

    public void configurar(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad;
    }
}
