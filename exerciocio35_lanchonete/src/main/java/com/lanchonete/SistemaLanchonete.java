package com.lanchonete;

import com.lanchonete.model.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe principal do Sistema de Lanchonete.
 * Contém o método main para testar as funcionalidades do sistema.
 */
public class SistemaLanchonete {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE LANCHONETE - QUASE TRÊS LANCHES ===\n");
        
        // Teste 1: Criando diferentes tipos de itens
        System.out.println("1. CRIANDO ITENS DO CARDÁPIO:");
        System.out.println("------------------------------");
        
        // Criando uma pizza
        Pizza pizza = new Pizza(
            35.90, 
            LocalDate.now().plusDays(1), 
            800,
            Arrays.asList("Mussarela", "Calabresa"), 
            "Catupiry", 
            true, 
            Arrays.asList("Molho de Tomate", "Orégano")
        );
        
        // Criando um lanche
        Lanche lanche = new Lanche(
            18.50, 
            LocalDate.now().plusDays(2), 
            350,
            "Pão Francês", 
            "Hambúrguer", 
            Arrays.asList("Maionese", "Ketchup")
        );
        
        // Criando um salgadinho
        Salgadinho salgadinho = new Salgadinho(
            4.50, 
            LocalDate.now().plusDays(3), 
            80,
            Salgadinho.TipoSalgadinho.FRITO, 
            "Massa Folhada", 
            "Queijo"
        );
        
        System.out.println(pizza);
        System.out.println(lanche);
        System.out.println(salgadinho);
        
        // Teste 2: Criando um pedido
        System.out.println("\n2. CRIANDO PEDIDO:");
        System.out.println("------------------");
        
        Pedido pedido = new Pedido("João Silva", 5.00);
        pedido.adicionarPrato(pizza);
        pedido.adicionarPrato(lanche);
        pedido.adicionarPrato(salgadinho);
        
        System.out.println(pedido);
        
        // Teste 3: Calculando troco
        System.out.println("3. CALCULANDO TROCO:");
        System.out.println("--------------------");
        
        double valorRecebido = 70.00;
        double troco = pedido.calcularTroco(valorRecebido);
        System.out.printf("Valor recebido: R$ %.2f\n", valorRecebido);
        System.out.printf("Troco: R$ %.2f\n", troco);
        
        // Teste 4: Gerando nota fiscal
        System.out.println("\n4. GERANDO NOTA FISCAL:");
        System.out.println("-----------------------");
        
        NotaFiscal notaFiscal = new NotaFiscal(pedido, valorRecebido);
        System.out.println(notaFiscal.gerarNotaFiscal());
        
        // Teste 5: Demonstrando polimorfismo
        System.out.println("5. DEMONSTRANDO POLIMORFISMO:");
        System.out.println("-----------------------------");
        
        Prato[] cardapio = {pizza, lanche, salgadinho};
        
        System.out.println("Cardápio completo:");
        for (Prato prato : cardapio) {
            // Polimorfismo: cada classe implementa getDescricao() de forma diferente
            System.out.println("- " + prato.getDescricao() + " - R$ " + prato.getPrecoVenda());
        }
        
        // Teste 6: Testando validação de validade
        System.out.println("\n6. TESTANDO VALIDAÇÃO DE VALIDADE:");
        System.out.println("----------------------------------");
        
        // Criando item vencido
        Pizza pizzaVencida = new Pizza(
            25.00, 
            LocalDate.now().minusDays(1), // Data no passado
            600,
            Arrays.asList("Margherita"), 
            "Tradicional", 
            false, 
            Arrays.asList("Molho de Tomate")
        );
        
        System.out.println("Pizza válida: " + pizza.isValido());
        System.out.println("Pizza vencida: " + pizzaVencida.isValido());
        
        try {
            Pedido pedidoTeste = new Pedido("Maria", 2.00);
            pedidoTeste.adicionarPrato(pizzaVencida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
        
        // Teste interativo opcional
        testeInterativo();
    }
    
    /**
     * Método para teste interativo com o usuário
     */
    private static void testeInterativo() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== TESTE INTERATIVO ===");
        System.out.print("Deseja fazer um pedido personalizado? (s/n): ");
        
        String resposta = scanner.nextLine().toLowerCase();
        
        if (resposta.equals("s") || resposta.equals("sim")) {
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Digite a taxa de serviço: R$ ");
            double taxa = scanner.nextDouble();
            
            Pedido pedidoPersonalizado = new Pedido(nome, taxa);
            
            // Adicionando alguns itens pré-definidos para simplificar
            Pizza pizzaPersonalizada = new Pizza(
                30.00, 
                LocalDate.now().plusDays(1), 
                700,
                Arrays.asList("Portuguesa"), 
                "Tradicional", 
                false, 
                Arrays.asList("Molho de Tomate")
            );
            
            pedidoPersonalizado.adicionarPrato(pizzaPersonalizada);
            
            System.out.println("\nSeu pedido:");
            System.out.println(pedidoPersonalizado);
            
            System.out.print("Digite o valor recebido: R$ ");
            double valorRecebido = scanner.nextDouble();
            
            try {
                NotaFiscal nf = new NotaFiscal(pedidoPersonalizado, valorRecebido);
                System.out.println("\n" + nf.gerarNotaFiscal());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}
