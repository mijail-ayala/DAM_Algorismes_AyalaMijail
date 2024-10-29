import java.util.ArrayList;

public class ObjEina {
    private int id;
    private String nom;
    private int any;
    private ArrayList<Integer> llenguatges;

    public ObjEina(int id, String nom, int any, ArrayList<Integer> llenguatges) {
        this.id = id;
        this.nom = nom;
        this.any = any;
        this.llenguatges = llenguatges;
    }

    @Override
    public String toString() {
        return "Eina: " + id + " " + nom + ", " + any + " - " + llenguatges;
    }
}
