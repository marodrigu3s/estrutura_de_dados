import java.util.Date;
import java.util.Scanner;

public class ComparaMetodos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MeuVetor v;
        long ini, fim;
        System.out.print("Escolha o tamanho do vetor, 0 encerra: ");
        int t = scanner.nextInt();
        while (t > 0) {
            v = new MeuVetor(t);
            // v.preencheVetor(t * 10);
            // System.out.println("1o vetor gerado\n" + v);
            // ini = new Date().getTime();
            // v.insertionsort();
            // fim = new Date().getTime();
            // System.out.println("Ordenacao pelo insertion\n" + v);
            // System.out.println("insertion demorou " + (fim - ini) + "ms\n");
            // v.resetVetor();
            v.preencheVetor(t * 10);
            //System.out.println("2o vetor gerado\n" + v);
            ini = new Date().getTime();
            v.quick(0, t - 1);
            fim = new Date().getTime();
            //System.out.println("ordenacao pelo quick\n" + v);
            System.out.println("quick demorou " + (fim - ini) + "ms\n");
            System.out.print("\nEscolha o tamanh do vetor, 0 encerra: ");
            t = scanner.nextInt();
            // mais ou menos o nosso projeto da T1
        }
        scanner.close();
    }
}
