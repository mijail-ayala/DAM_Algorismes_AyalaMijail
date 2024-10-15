public final class Objecte {
    private String nombre;
    private String apellido;
    private int edad;
    private static Objecte instanciaUnica;

    private Objecte() {
    }

    public static Objecte getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Objecte();
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
