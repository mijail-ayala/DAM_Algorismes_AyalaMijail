import java.util.ArrayList;
import java.util.List;

// Classe principal
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        List<Electrodomestic> electrodomestics = new ArrayList<>();


        electrodomestics.add(new Rentadora("Rentadora X1", "Blanc", 400.0, "Samsung", 'A', 1200, 50));
        electrodomestics.add(new Rentadora("Rentadora Y2", "Negre", 500.0, "LG", 'B', 1400, 55));

       
        electrodomestics.add(new Nevera("Nevera Z1", "Gris", 700.0, "Bosch", 'A', 350, 40));
        electrodomestics.add(new Nevera("Nevera W2", "Blanc", 800.0, "Siemens", 'A', 400, 45));

        electrodomestics.add(new Forn("Forn V1", "Negre", 300.0, "Whirlpool", 'B', 250, true));
        electrodomestics.add(new Forn("Forn U2", "Inoxidable", 450.0, "Balay", 'A', 300, false));


        List<Electrodomestic> electrodomesticsClons = new ArrayList<>();
        for (Electrodomestic e : electrodomestics) {
            electrodomesticsClons.add(e.clone());
        }


        System.out.println("Comparació de la llista original amb ella mateixa:");
        for (int i = 0; i < electrodomestics.size(); i++) {
            Electrodomestic original = electrodomestics.get(i);
            System.out.println("Objecte " + (i + 1) + ": " + (original == original) + ", Mateixa classe: " + original.getClass().equals(original.getClass()) + ", Mateixes dades: " + original.equalsData(original));
        }


        System.out.println("\nComparació de la llista original amb els clons:");
        for (int i = 0; i < electrodomestics.size(); i++) {
            Electrodomestic original = electrodomestics.get(i);
            Electrodomestic clon = electrodomesticsClons.get(i);
            System.out.println("Objecte " + (i + 1) + ": Diferents objectes: " + (original != clon) + ", Mateixa classe: " + original.getClass().equals(clon.getClass()) + ", Mateixes dades: " + original.equalsData(clon));
        }
    }
}



abstract class Electrodomestic implements Cloneable {
    String nom;
    String color;
    double preu;
    String marca;
    char eficiencia;

    public Electrodomestic(String nom, String color, double preu, String marca, char eficiencia) {
        this.nom = nom;
        this.color = color;
        this.preu = preu;
        this.marca = marca;
        this.eficiencia = eficiencia;
    }
// CLONAR OBJECTES
    @Override
    public Electrodomestic clone() throws CloneNotSupportedException {
        return (Electrodomestic) super.clone();
    }
// COMPRAR OBJECTES
    public boolean equalsData(Electrodomestic other) {
        return this.nom.equals(other.nom) &&
                this.color.equals(other.color) &&
                this.preu == other.preu &&
                this.marca.equals(other.marca) &&
                this.eficiencia == other.eficiencia;
    }

    // Mètode abstracte que serà implementat en subclasses
    public abstract void imprimir();
}


class Rentadora extends Electrodomestic {
    int revolucions;
    int soroll;

    public Rentadora(String nom, String color, double preu, String marca, char eficiencia, int revolucions, int soroll) {
        super(nom, color, preu, marca, eficiencia);
        this.revolucions = revolucions;
        this.soroll = soroll;
    }

    @Override
    public Rentadora clone() throws CloneNotSupportedException {
        return (Rentadora) super.clone();
    }

    @Override
    public void imprimir() {
        System.out.println("Rentadora: " + nom + ", Color: " + color + ", Preu: " + preu + ", Marca: " + marca + ", Eficiència: " + eficiencia + ", Revolucions: " + revolucions + ", Soroll: " + soroll);
    }
}


class Nevera extends Electrodomestic {
    int frigories;
    int soroll;

    public Nevera(String nom, String color, double preu, String marca, char eficiencia, int frigories, int soroll) {
        super(nom, color, preu, marca, eficiencia);
        this.frigories = frigories;
        this.soroll = soroll;
    }

    @Override
    public Nevera clone() throws CloneNotSupportedException {
        return (Nevera) super.clone();
    }

    @Override
    public void imprimir() {
        System.out.println("Nevera: " + nom + ", Color: " + color + ", Preu: " + preu + ", Marca: " + marca + ", Eficiència: " + eficiencia + ", Frigories: " + frigories + ", Soroll: " + soroll);
    }
}


class Forn extends Electrodomestic {
    int temperatura;
    boolean autoneteja;

    public Forn(String nom, String color, double preu, String marca, char eficiencia, int temperatura, boolean autoneteja) {
        super(nom, color, preu, marca, eficiencia);
        this.temperatura = temperatura;
        this.autoneteja = autoneteja;
    }

    @Override
    public Forn clone() throws CloneNotSupportedException {
        return (Forn) super.clone();
    }

    @Override
    public void imprimir() {
        System.out.println("Forn: " + nom + ", Color: " + color + ", Preu: " + preu + ", Marca: " + marca + ", Eficiència: " + eficiencia + ", Temperatura: " + temperatura + ", Autoneteja: " + autoneteja);
    }
}
