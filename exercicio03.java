import java.util.Scanner;
import java.util.Random;

public class exercicio03 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Random gerador = new Random();
        
        int num = gerador.nextInt(100) + 1;
        int palpite;
        int tentativas = 0;
        
        System.out.println("Adivinhe o Número");
        System.out.println("\nTente adivinhar um número entre 1 e 100!");
        
        do {
            System.out.print("\nDigite um número: ");
            palpite = leitor.nextInt();
            tentativas++;
            
            if (palpite > num) {
                System.out.println("Número muito alto! Tente outro.");
            } else if (palpite < num) {
                System.out.println("Número muito baixo! Tente outro.");
            } else {
                System.out.println("Você acertou!");
                System.out.println("Número de tentativas: " + tentativas);
            }
        } while (palpite != num);
        
        leitor.close();
    }
}