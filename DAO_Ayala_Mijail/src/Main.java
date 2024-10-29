import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String llenguatgesPath = "ruta/del/archivo/llenguatges.json";
        String einesPath = "ruta/del/archivo/eines.json";
        String softwarePath = "ruta/del/archivo/software.json";

        DaoLlenguatge daoLlenguatge = new DaoLlenguatge(llenguatgesPath);
        // Otros DAO seguirían la misma estructura.

        // Ejemplo de añadir y actualizar
        ObjLlenguatge objLlenguatge = new ObjLlenguatge(5, "Dart", 2011, "facil", 8);
        daoLlenguatge.add(objLlenguatge);
        daoLlenguatge.setNom(5, "Dart+Flutter");
        daoLlenguatge.setAny(5, 2018);
        daoLlenguatge.setDificultat(5, "mitja");
        daoLlenguatge.setPopularitat(5, 9);

        // Imprimir todos los lenguajes
        daoLlenguatge.print();

        // Otros ejemplos con daoEina y daoSoftware
    }
}
