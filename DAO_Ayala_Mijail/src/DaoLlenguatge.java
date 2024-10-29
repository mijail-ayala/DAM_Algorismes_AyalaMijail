import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DaoLlenguatge {
    private List<ObjLlenguatge> llenguatges;
    private final String filepath;

    public DaoLlenguatge(String filepath) {
        this.filepath = filepath;
        this.llenguatges = readFromFile();
    }

    private List<ObjLlenguatge> readFromFile() {
        try (FileReader reader = new FileReader(filepath)) {
            Type listType = new TypeToken<ArrayList<ObjLlenguatge>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void writeToFile() {
        try (FileWriter writer = new FileWriter(filepath)) {
            new Gson().toJson(llenguatges, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(ObjLlenguatge llenguatge) {
        llenguatges.add(llenguatge);
        writeToFile();
    }

    public ObjLlenguatge get(int id) {
        return llenguatges.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    public List<ObjLlenguatge> getAll() {
        return llenguatges;
    }

    public void update(int id, ObjLlenguatge updatedLlenguatge) {
        ObjLlenguatge existing = get(id);
        if (existing != null) {
            llenguatges.remove(existing);
            llenguatges.add(updatedLlenguatge);
            writeToFile();
        }
    }

    public void delete(int id) {
        llenguatges.removeIf(l -> l.getId() == id);
        writeToFile();
    }

    public void setNom(int id, String nom) {
        ObjLlenguatge llenguatge = get(id);
        if (llenguatge != null) {
            llenguatge.setNom(nom);
            writeToFile();
        }
    }

    public void setAny(int id, int any) {
        ObjLlenguatge llenguatge = get(id);
        if (llenguatge != null) {
            llenguatge.setAny(any);
            writeToFile();
        }
    }

    public void setDificultat(int id, String dificultat) {
        ObjLlenguatge llenguatge = get(id);
        if (llenguatge != null) {
            llenguatge.setDificultat(dificultat);
            writeToFile();
        }
    }

    public void setPopularitat(int id, int popularitat) {
        ObjLlenguatge llenguatge = get(id);
        if (llenguatge != null) {
            llenguatge.setPopularitat(popularitat);
            writeToFile();
        }
    }

    public void print() {
        llenguatges.forEach(System.out::println);
    }
}
