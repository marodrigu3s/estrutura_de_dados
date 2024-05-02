import java.util.Random;

public class TesteFila {
    public static void main (String[] args) {
        Fila f = new Fila();
        Random r = new Random();
        do {
            if (r.nextBoolean()) {
                f.enfileira(r.nextInt(10));
            }
            else {
                    if (!f.estaVazia())System.out.println(f.desenfileira() + " saiu");
            }
            System.out.println(f);
        } while (!f.estaVazia());
    
    }
}
