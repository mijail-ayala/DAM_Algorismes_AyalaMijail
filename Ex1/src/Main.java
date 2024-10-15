public class Main {

    public static void main(String[] args) throws InterruptedException {
        Persona persona1 = Persona.getInstancia();
        persona1.configurar("Luis", "Martínez", 30);
        System.out.println(persona1);
        Thread.sleep(3000);

        Persona persona2 = Persona.getInstancia();
        persona2.configurar("Andrea", "García", 25);
        System.out.println(persona2);
        Thread.sleep(3000);

        Persona persona3 = Persona.getInstancia();
        persona3.configurar("Carlos", "Fernández", 35);
        System.out.println(persona3);
    }
}