public class Main {
    public static void main(String[] args) throws InterruptedException {
        objecte persona1 = objecte.getInstancia();
        persona1.configurar("Laura", "López", 24);
        System.out.println(persona1);

        Thread.sleep(3000);

        objecte persona2 = objecte.getInstancia();
        persona2.configurar("Sergio", "Ramírez", 30);
        System.out.println(persona2);

        Thread.sleep(3000);

        objecte persona3 = objecte.getInstancia();
        persona3.configurar("Claudia", "Hernández", 22);
        System.out.println(persona3);
    }
}
