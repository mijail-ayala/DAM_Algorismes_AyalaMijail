public class Main {
    public static void main(String[] args) throws InterruptedException {
        Objecte persona1 = Objecte.getInstancia();
        persona1.configurar("Laura", "López", 24);
        System.out.println(persona1);

        Thread.sleep(3000);

        Objecte persona2 = Objecte.getInstancia();
        persona2.configurar("Sergio", "Ramírez", 30);
        System.out.println(persona2);

        Thread.sleep(3000);

        Objecte persona3 = Objecte.getInstancia();
        persona3.configurar("Claudia", "Hernández", 22);
        System.out.println(persona3);
    }
}
