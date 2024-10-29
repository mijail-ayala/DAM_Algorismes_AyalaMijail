// Main.java
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class main {
    public static void main(String[] args) {
        Producte p0 = new Producte(0, "Llibre");
        Producte p1 = new Producte(1, "Boli");
        Producte p2 = new Producte(2, "Rotulador");
        Producte p3 = new Producte(3, "Carpeta");
        Producte p4 = new Producte(4, "Motxilla");

        Magatzem magatzem = new Magatzem();
        Entregues entregues = new Entregues();

        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("producteId".equals(propertyName)) {
                    System.out.println("Producte ha canviat l'ID de " + evt.getOldValue() + " a " + evt.getNewValue());
                } else if ("producteName".equals(propertyName)) {
                    System.out.println("Producte ha canviat el nom de " + evt.getOldValue() + " a " + evt.getNewValue());
                } else if ("magatzemAdd".equals(propertyName)) {
                    System.out.println("S'ha afegit el producte " + evt.getNewValue() + " al magatzem, capacitat: " + magatzem.getCapacitat());
                } else if ("magatzemRemove".equals(propertyName)) {
                    System.out.println("S'ha esborrat el producte " + evt.getOldValue() + " del magatzem, capacitat: " + magatzem.getCapacitat());
                    entregues.addProducte((Producte) evt.getOldValue());
                } else if ("entreguesAdd".equals(propertyName)) {
                    System.out.println("S'ha afegit el producte " + evt.getNewValue() + " a la llista d'entregues");
                } else if ("entreguesRemove".equals(propertyName)) {
                    System.out.println("S'ha entregat el producte " + evt.getOldValue());
                }
            }
        };

        // Añadir listeners
        p0.addPropertyChangeListener(listener);
        p1.addPropertyChangeListener(listener);
        magatzem.addPropertyChangeListener(listener);
        entregues.addPropertyChangeListener(listener);

        // Testear cambios
        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Boli");

        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);

        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(4);

        entregues.removeProducte(2);
        entregues.removeProducte(3);

        System.out.println(magatzem);
        System.out.println(entregues);
    }
}
