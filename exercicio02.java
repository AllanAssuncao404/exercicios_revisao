import java.util.Scanner;

public class exercicio02 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int num;
        
        System.out.println("Tabuada");

        System.out.print("\nDigite um número inteiro: ");
        num = leitor.nextInt();
        
        System.out.println("\nTabuada do " + num + ":");
        
        for (int i = 1; i <= 10; i++) {
            int res;
            res = num * i;
            System.out.println(num + " x " + i + " = " + res);
        }
        
        leitor.close();
    }
}