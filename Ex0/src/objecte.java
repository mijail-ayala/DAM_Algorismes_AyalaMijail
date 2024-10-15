public final class Objecte {
    private String nombre;
    private String apellido;
    private int edad;
    private static Objecte instanciaUnica;

    // Constructor privado
    private Objecte() {
    }

    // Método estático para obtener la única instancia (Singleton)
    public static Objecte getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Objecte();
        }
        return instanciaUnica;
    }

    // Método para inicializar los valores del objeto
    public void configurar(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Sobrescribir toString para mostrar la información
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad;
    }
}