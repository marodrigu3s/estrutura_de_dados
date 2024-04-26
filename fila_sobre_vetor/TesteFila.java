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
                    f.desenfileira();
            }
            System.out.println(f);
        } while (!f.estaVazia());
    
    }
}
