public class Main {

    public static void main(String[] args) throws InterruptedException {
        Persona persona1 = Persona.getInstancia();
        persona1.configurar("Jose", "Romero", 27);
        System.out.println(persona1);
        Thread.sleep(3000);

        Persona persona2 = Persona.getInstancia();
        persona2.configurar("Martina", "Lopez", 32);
        System.out.println(persona2);
        Thread.sleep(3000);

        Persona persona3 = Persona.getInstancia();
        persona3.configurar("Marcos", "Alonso", 25);
        System.out.println(persona3);
    }
}
