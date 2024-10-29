// Magatzem.java
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Magatzem {
    private final ArrayList<Producte> productes;
    private int capacitat;
    private final PropertyChangeSupport support;

    public Magatzem() {
        this.productes = new ArrayList<>();
        this.capacitat = 10;
        this.support = new PropertyChangeSupport(this);
    }

    public ArrayList<Producte> getProductes() {
        return new ArrayList<>(productes);
    }

    public void addProducte(Producte producte) {
        if (productes.size() < capacitat) {
            productes.add(producte);
            capacitat--;
            support.firePropertyChange("magatzemAdd", null, producte);
        }
    }

    public void removeProducte(int id) {
        Producte toRemove = null;
        for (Producte producte : productes) {
            if (producte.getId() == id) {
                toRemove = producte;
                break;
            }
        }
        if (toRemove != null) {
            productes.remove(toRemove);
            capacitat++;
            support.firePropertyChange("magatzemRemove", toRemove, null);
        }
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Magatzem{productes=" + productes + ", capacitat=" + capacitat + "}";
    }
}
