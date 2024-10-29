public class ObjLlenguatge {
    private int id;
    private String nom;
    private int any;
    private String dificultat;
    private int popularitat;

    // Constructor, getters y setters
    public ObjLlenguatge(int id, String nom, int any, String dificultat, int popularitat) {
        this.id = id;
        this.nom = nom;
        this.any = any;
        this.dificultat = dificultat;
        this.popularitat = popularitat;
    }

    // Getters y setters para cada atributo
    // Implementación toString para mostrar en consola
    @Override
    public String toString() {
        return "Llenguatge: " + id + " " + nom + ", " + any + " - " + dificultat + "/" + popularitat;
    }
}