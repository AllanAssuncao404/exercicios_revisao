import java.time.LocalDate;
import java.util.Scanner;

public class Lanchonete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DA LANCHONETE QUASE TRÊS LANCHES ===");
        System.out.println("Bem-vindo ao sistema de pedidos!\n");
        
        LocalDate dataValidade = LocalDate.now().plusDays(7);
        
        Pizza pizzaMargherita = new Pizza("Pizza Margherita", 25.0, dataValidade, 800, 
                                         "Molho de Tomate", "Mussarela", "Borda Simples");
        Pizza pizzaEspecial = new Pizza("Pizza Especial", 35.0, dataValidade, 900, 
                                       "Molho de Tomate", "Recheio Especial", "Borda Recheada");
        
        Lanche lancheSimples = new Lanche("Lanche Simples", 15.0, dataValidade, 300, 
                                         "Pão Francês", "Frango", "Maionese");
        Lanche lanchePremium = new Lanche("Lanche Premium", 22.0, dataValidade, 350, 
                                         "Pão Integral", "Recheio Especial", "Molho Especial");
        
        Salgadinho salgadinhoFrito = new Salgadinho("Salgadinho Frito", 8.0, dataValidade, 100, 
                                                   "Frito", "Massa Tradicional", "Frango");
        Salgadinho salgadinhoAssado = new Salgadinho("Salgadinho Assado", 10.0, dataValidade, 120, 
                                                     "Assado", "Massa Integral", "Queijo");
        
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        
        Pedido pedido = new Pedido(nomeCliente, 5.0);
        
        pedido.adicionarItem(pizzaMargherita);
        pedido.adicionarItem(lancheSimples);
        pedido.adicionarItem(salgadinhoFrito);
        
        System.out.println("\n=== ITENS ADICIONADOS AO PEDIDO ===");
        System.out.println("1. " + pizzaMargherita.getNome());
        System.out.println("2. " + lancheSimples.getNome());
        System.out.println("3. " + salgadinhoFrito.getNome());
        
        System.out.println("\n=== FATURA DO PEDIDO ===");
        pedido.mostrarFatura();
        
        System.out.print("\nDigite o valor recebido em dinheiro: R$ ");
        scanner.nextLine();
        double valorRecebido = Double.parseDouble(scanner.nextLine());
        
        pedido.processarPagamento(valorRecebido);
        
        System.out.println("\n=== DEMONSTRAÇÃO DE POLIMORFISMO ===");
        System.out.println("Calculando preços individuais dos pratos:");
        
        Prato[] pratos = {pizzaMargherita, lancheSimples, salgadinhoFrito, pizzaEspecial, lanchePremium, salgadinhoAssado};
        
        for (Prato prato : pratos) {
            System.out.printf("%s - Preço: R$ %.2f\n", prato.getNome(), prato.calcularPreco());
        }
        
        System.out.println("\n=== DEMONSTRAÇÃO DE HERANÇA ===");
        System.out.println("Detalhes dos pratos:");
        for (Prato prato : pratos) {
            System.out.println(prato.toString());
        }
        
        scanner.close();
        System.out.println("\n=== SISTEMA ENCERRADO ===");
    }
} 