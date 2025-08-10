package exercicio34_vcRiquinho;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VcRiquinho {
    private List<Cliente> clientes;
    private List<Investimento> produtos;
    private Scanner scanner;
    
    public VcRiquinho() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    cadastrarProduto();
                    break;
                case 4:
                    listarProdutos();
                    break;
                case 5:
                    simularRendimento();
                    break;
                case 0:
                    System.out.println("Saindo do sistema VcRiquinho...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private void exibirMenu() {
        System.out.println("\n=== VcRiquinho - Sistema de Investimentos ===");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Cadastrar Produto de Investimento");
        System.out.println("4. Listar Produtos");
        System.out.println("5. Simular Rendimento");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private void cadastrarCliente() {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.println("Tipo de cliente:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        Cliente cliente;
        if (tipo == 1) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            cliente = new PessoaFisica(nome, email, cpf);
        } else {
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            cliente = new PessoaJuridica(nome, email, cnpj);
        }
        
        String numeroConta = "CC" + (clientes.size() + 1);
        ContaCorrente conta = new ContaCorrente(numeroConta, cliente);
        cliente.adicionarConta(conta);
        
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }
    
    private void listarClientes() {
        System.out.println("\n=== Lista de Clientes ===");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }
    }
    
    private void cadastrarProduto() {
        System.out.println("\n=== Cadastro de Produto ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor investido: ");
        double valor = scanner.nextDouble();
        
        System.out.println("Tipo de produto:");
        System.out.println("1. Renda Fixa");
        System.out.println("2. Renda Variável");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();
        
        Investimento produto;
        if (tipo == 1) {
            System.out.print("Rendimento mensal (%): ");
            double rendimento = scanner.nextDouble() / 100.0;
            System.out.print("Período de carência (dias): ");
            int carencia = scanner.nextInt();
            produto = new InvestimentoRendaFixa(nome, descricao, valor, rendimento, carencia);
        } else {
            System.out.print("Rendimento mensal esperado (%): ");
            double rendimento = scanner.nextDouble() / 100.0;
            produto = new InvestimentoRendaVariavel(nome, descricao, valor, rendimento);
        }
        
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }
    
    private void listarProdutos() {
        System.out.println("\n=== Lista de Produtos ===");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }
    }
    
    private void simularRendimento() {
        System.out.println("\n=== Simulação de Rendimento ===");
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        
        listarClientes();
        System.out.print("Escolha o cliente (número): ");
        int indiceCliente = scanner.nextInt() - 1;
        
        if (indiceCliente < 0 || indiceCliente >= clientes.size()) {
            System.out.println("Cliente inválido!");
            return;
        }
        
        Cliente cliente = clientes.get(indiceCliente);
        
        System.out.println("Períodos disponíveis:");
        System.out.println("1. 30 dias");
        System.out.println("2. 60 dias");
        System.out.println("3. 90 dias");
        System.out.println("4. 180 dias");
        System.out.print("Escolha o período: ");
        int opcaoPeriodo = scanner.nextInt();
        
        int dias;
        switch (opcaoPeriodo) {
            case 1: dias = 30; break;
            case 2: dias = 60; break;
            case 3: dias = 90; break;
            case 4: dias = 180; break;
            default: dias = 30;
        }
        
        System.out.println("\n=== Resultado da Simulação ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Período: " + dias + " dias");
        
        double rendimentoTotal = 0.0;
        double taxaTotal = 0.0;
        
        for (Conta conta : cliente.getContas()) {
            double rendimento = conta.calcularRendimento(dias);
            double taxa = conta.calcularTaxaServico(rendimento);
            
            System.out.println("\nConta " + conta.getNumero() + " (" + conta.getClass().getSimpleName() + "):");
            System.out.println("  Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
            System.out.println("  Rendimento: R$ " + String.format("%.2f", rendimento));
            System.out.println("  Taxa de serviço: R$ " + String.format("%.2f", taxa));
            
            rendimentoTotal += rendimento;
            taxaTotal += taxa;
        }
        
        System.out.println("\n=== Resumo ===");
        System.out.println("Rendimento total: R$ " + String.format("%.2f", rendimentoTotal));
        System.out.println("Taxa de serviço total: R$ " + String.format("%.2f", taxaTotal));
        System.out.println("Rendimento líquido: R$ " + String.format("%.2f", rendimentoTotal - taxaTotal));
    }
    
    public static void main(String[] args) {
        VcRiquinho sistema = new VcRiquinho();
        sistema.executar();
    }
} 