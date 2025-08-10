public class exercicio04 {
    public static void main(String[] args) {
        int[] num = {42, 17, 234, 89, 156, 89, 23, 345, 91, 67};
        
        System.out.print("Array: ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
            if (i < num.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        int soma = 0;
        for (int n : num) {
            if (n % 2 != 0) {
                soma += n;
            }
        }
        System.out.println("Soma dos números ímpares do array: " + soma);
    }
}