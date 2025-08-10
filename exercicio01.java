import java.util.Scanner;

public class exercicio01 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        double n1, n2, n3, media;
        
        System.out.println("Calculadora de Média");
        
        System.out.print("Nota 1: ");
        n1 = leitor.nextDouble();
        
        System.out.print("Nota 2: ");
        n2 = leitor.nextDouble();
        
        System.out.print("Nota 3: ");
        n3 = leitor.nextDouble();
        
        media = (n1 + n2 + n3) / 3.0;
        
        System.out.printf("\nMédia: %.2f\n", media);
        
        if (media >= 7.0) {
            System.out.println("Aprovado");
        } else if (media >= 5.0) {
            System.out.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }
        
        leitor.close();
    }
}
