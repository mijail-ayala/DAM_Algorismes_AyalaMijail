import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Entregues {
    private final ArrayList<Producte> productes;
    private final PropertyChangeSupport support;

    public Entregues() {
        this.productes = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    public ArrayList<Producte> getProductes() {
        return new ArrayList<>(productes);
    }

    public void addProducte(Producte producte) {
        productes.add(producte);
        support.firePropertyChange("entreguesAdd", null, producte);
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
            support.firePropertyChange("entreguesRemove", toRemove, null);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Entregues{productes=" + productes + "}";
    }
}