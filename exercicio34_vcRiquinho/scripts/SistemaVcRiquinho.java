import java.util.*;

// Sistema principal de gerenciamento
public class SistemaVcRiquinho {
    private java.util.List<Cliente> clientes;
    private java.util.List<ProdutoInvestimento> produtos;
    private Scanner scanner;
    private int proximoNumeroContaCorrente = 1001;
    private int proximoNumeroContaCDI = 2001;
    private int proximoNumeroContaInvestimento = 3001;
    
    public SistemaVcRiquinho() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        inicializarProdutosPadrao();
    }
    
    private void inicializarProdutosPadrao() {
        // Produtos de Renda Fixa
        produtos.add(new RendaFixa("CDB Banco ABC", "Certificado de Depósito Bancário", 0.008, 90));
        produtos.add(new RendaFixa("LCI Imobiliária", "Letra de Crédito Imobiliário", 0.007, 180));
        produtos.add(new RendaFixa("Tesouro Selic", "Título público indexado à Selic", 0.006, 30));
        
        // Produtos de Renda Variável
        produtos.add(new RendaVariavel("Fundo Multimercado", "Fundo diversificado", 0.012));
        produtos.add(new RendaVariavel("Ações Tecnologia", "Carteira de ações de tecnologia", 0.015));
        produtos.add(new RendaVariavel("ETF Ibovespa", "Fundo que replica o Ibovespa", 0.010));
    }
    
    public void executar() {
        System.out.println("=== Sistema VcRiquinho ===");
        System.out.println("Bem-vindo ao sistema de investimentos!");
        
        while (true) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1: menuClientes(); break;
                case 2: menuProdutos(); break;
                case 3: menuSimulacao(); break;
                case 0: 
                    System.out.println("Obrigado por usar o Sistema VcRiquinho!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    private void exibirMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Gerenciar Clientes");
        System.out.println("2. Gerenciar Produtos");
        System.out.println("3. Simulação de Rendimentos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private void menuClientes() {
        while (true) {
            System.out.println("\n=== GERENCIAR CLIENTES ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Buscar Cliente");
            System.out.println("4. Atualizar Cliente");
            System.out.println("5. Remover Cliente");
            System.out.println("6. Gerenciar Contas");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: listarClientes(); break;
                case 3: buscarCliente(); break;
                case 4: atualizarCliente(); break;
                case 5: removerCliente(); break;
                case 6: menuContas(); break;
                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }
    
    private void cadastrarCliente() {
        System.out.println("\n=== CADASTRAR CLIENTE ===");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Tipo de cliente: ");
        
        int tipo = lerOpcao();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Cliente cliente = null;
        
        if (tipo == 1) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            cliente = new PessoaFisica(nome, cpf, email);
        } else if (tipo == 2) {
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            cliente = new PessoaJuridica(nome, cnpj, email);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }
        
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
        
        // Obrigatório ter pelo menos uma conta
        System.out.println("\nÉ obrigatório cadastrar pelo menos uma conta.");
        criarContaParaCliente(cliente);
    }
    
    private void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }
    }
    
    private Cliente buscarCliente() {
        System.out.print("Digite o nome ou documento do cliente: ");
        String busca = scanner.nextLine().toLowerCase();
        
        for (Cliente cliente : clientes) {
            if (cliente.getNome().toLowerCase().contains(busca) || 
                cliente.getDocumento().contains(busca)) {
                System.out.println("Cliente encontrado: " + cliente);
                return cliente;
            }
        }
        
        System.out.println("Cliente não encontrado.");
        return null;
    }
    
    private void atualizarCliente() {
        Cliente cliente = buscarCliente();
        if (cliente == null) return;
        
        System.out.print("Novo nome (atual: " + cliente.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.trim().isEmpty()) {
            cliente.setNome(nome);
        }
        
        System.out.print("Novo email (atual: " + cliente.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.trim().isEmpty()) {
            cliente.setEmail(email);
        }
        
        System.out.println("Cliente atualizado com sucesso!");
    }
    
    private void removerCliente() {
        Cliente cliente = buscarCliente();
        if (cliente == null) return;
        
        System.out.print("Confirma a remoção do cliente " + cliente.getNome() + "? (s/n): ");
        String confirmacao = scanner.nextLine();
        
        if (confirmacao.equalsIgnoreCase("s")) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        }
    }
    
    private void menuContas() {
        Cliente cliente = buscarCliente();
        if (cliente == null) return;
        
        while (true) {
            System.out.println("\n=== GERENCIAR CONTAS - " + cliente.getNome() + " ===");
            System.out.println("1. Criar Conta");
            System.out.println("2. Listar Contas");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Configurar Investimento Automático");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1: criarContaParaCliente(cliente); break;
                case 2: listarContasCliente(cliente); break;
                case 3: depositar(cliente); break;
                case 4: sacar(cliente); break;
                case 5: configurarInvestimentoAutomatico(cliente); break;
                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }
    
    private void criarContaParaCliente(Cliente cliente) {
        System.out.println("\n=== CRIAR CONTA ===");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta CDI");
        System.out.println("3. Conta Investimento Automático");
        System.out.print("Tipo de conta: ");
        
        int tipo = lerOpcao();
        Conta conta = null;
        
        switch (tipo) {
            case 1:
                conta = new ContaCorrente(String.valueOf(proximoNumeroContaCorrente++), cliente);
                break;
            case 2:
                conta = new ContaCDI(String.valueOf(proximoNumeroContaCDI++), cliente);
                break;
            case 3:
                conta = new ContaInvestimentoAutomatico(String.valueOf(proximoNumeroContaInvestimento++), cliente);
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }
        
        cliente.adicionarConta(conta);
        System.out.println("Conta criada com sucesso: " + conta);
    }
    
    private void listarContasCliente(Cliente cliente) {
        System.out.println("\n=== CONTAS DE " + cliente.getNome() + " ===");
        if (cliente.getContas().isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }
        
        for (int i = 0; i < cliente.getContas().size(); i++) {
            System.out.println((i + 1) + ". " + cliente.getContas().get(i));
        }
    }
    
    private void depositar(Cliente cliente) {
        Conta conta = selecionarConta(cliente);
        if (conta == null) return;
        
        System.out.print("Valor para depósito: R$ ");
        double valor = lerValor();
        
        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso!");
        System.out.println("Novo saldo: R$ " + String.format("%.2f", conta.getSaldo()));
    }
    
    private void sacar(Cliente cliente) {
        Conta conta = selecionarConta(cliente);
        if (conta == null) return;
        
        System.out.print("Valor para saque: R$ ");
        double valor = lerValor();
        
        if (conta.sacar(valor)) {
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + String.format("%.2f", conta.getSaldo()));
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
    
    private void configurarInvestimentoAutomatico(Cliente cliente) {
        // Buscar conta de investimento automático
        ContaInvestimentoAutomatico conta = null;
        for (Conta c : cliente.getContas()) {
            if (c instanceof ContaInvestimentoAutomatico) {
                conta = (ContaInvestimentoAutomatico) c;
                break;
            }
        }
        
        if (conta == null) {
            System.out.println("Cliente não possui conta de investimento automático.");
            return;
        }
        
        System.out.println("\n=== CONFIGURAR INVESTIMENTO AUTOMÁTICO ===");
        System.out.println("Produtos disponíveis:");
        
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }
        
        System.out.print("Selecione os produtos (separados por vírgula): ");
        String selecao = scanner.nextLine();
        
        String[] indices = selecao.split(",");
        for (String indiceStr : indices) {
            try {
                int indice = Integer.parseInt(indiceStr.trim()) - 1;
                if (indice >= 0 && indice < produtos.size()) {
                    conta.adicionarProduto(produtos.get(indice));
                    System.out.println("Produto adicionado: " + produtos.get(indice).getNome());
                }
            } catch (NumberFormatException e) {
                System.out.println("Índice inválido: " + indiceStr);
            }
        }
    }
    
    private Conta selecionarConta(Cliente cliente) {
        listarContasCliente(cliente);
        if (cliente.getContas().isEmpty()) return null;
        
        System.out.print("Selecione a conta: ");
        int indice = lerOpcao() - 1;
        
        if (indice >= 0 && indice < cliente.getContas().size()) {
            return cliente.getContas().get(indice);
        }
        
        System.out.println("Conta inválida!");
        return null;
    }
    
    private void menuProdutos() {
        while (true) {
            System.out.println("\n=== GERENCIAR PRODUTOS ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Remover Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerOpcao();
            
            switch (opcao) {
                case 1: cadastrarProduto(); break;
                case 2: listarProdutos(); break;
                case 3: atualizarProduto(); break;
                case 4: removerProduto(); break;
                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }
    
    private void cadastrarProduto() {
        System.out.println("\n=== CADASTRAR PRODUTO ===");
        System.out.println("1. Renda Fixa");
        System.out.println("2. Renda Variável");
        System.out.print("Tipo de produto: ");
        
        int tipo = lerOpcao();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        
        ProdutoInvestimento produto = null;
        
        if (tipo == 1) {
            System.out.print("Rendimento mensal fixo (%): ");
            double rendimento = lerValor() / 100;
            
            System.out.print("Período de carência (dias): ");
            int carencia = lerOpcao();
            
            produto = new RendaFixa(nome, descricao, rendimento, carencia);
        } else if (tipo == 2) {
            System.out.print("Rendimento mensal esperado (%): ");
            double rendimento = lerValor() / 100;
            
            produto = new RendaVariavel(nome, descricao, rendimento);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }
        
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }
    
    private void listarProdutos() {
        System.out.println("\n=== LISTA DE PRODUTOS ===");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i));
        }
    }
    
    private void atualizarProduto() {
        listarProdutos();
        if (produtos.isEmpty()) return;
        
        System.out.print("Selecione o produto: ");
        int indice = lerOpcao() - 1;
        
        if (indice < 0 || indice >= produtos.size()) {
            System.out.println("Produto inválido!");
            return;
        }
        
        ProdutoInvestimento produto = produtos.get(indice);
        
        System.out.print("Novo nome (atual: " + produto.getNome() + "): ");
        String nome = scanner.nextLine();
        if (!nome.trim().isEmpty()) {
            produto.setNome(nome);
        }
        
        System.out.print("Nova descrição (atual: " + produto.getDescricao() + "): ");
        String descricao = scanner.nextLine();
        if (!descricao.trim().isEmpty()) {
            produto.setDescricao(descricao);
        }
        
        System.out.println("Produto atualizado com sucesso!");
    }
    
    private void removerProduto() {
        listarProdutos();
        if (produtos.isEmpty()) return;
        
        System.out.print("Selecione o produto: ");
        int indice = lerOpcao() - 1;
        
        if (indice < 0 || indice >= produtos.size()) {
            System.out.println("Produto inválido!");
            return;
        }
        
        ProdutoInvestimento produto = produtos.get(indice);
        
        System.out.print("Confirma a remoção do produto " + produto.getNome() + "? (s/n): ");
        String confirmacao = scanner.nextLine();
        
        if (confirmacao.equalsIgnoreCase("s")) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        }
    }
    
    private void menuSimulacao() {
        System.out.println("\n=== SIMULAÇÃO DE RENDIMENTOS ===");
        
        Cliente cliente = buscarCliente();
        if (cliente == null) return;
        
        if (cliente.getContas().isEmpty()) {
            System.out.println("Cliente não possui contas cadastradas.");
            return;
        }
        
        System.out.println("Períodos disponíveis:");
        System.out.println("1. 30 dias");
        System.out.println("2. 60 dias");
        System.out.println("3. 90 dias");
        System.out.println("4. 180 dias");
        System.out.print("Selecione o período: ");
        
        int opcao = lerOpcao();
        int dias = 0;
        
        switch (opcao) {
            case 1: dias = 30; break;
            case 2: dias = 60; break;
            case 3: dias = 90; break;
            case 4: dias = 180; break;
            default:
                System.out.println("Período inválido!");
                return;
        }
        
        SimuladorRendimento.ResultadoSimulacao resultado = 
            SimuladorRendimento.simularRendimento(cliente, dias);
        
        System.out.println("\n=== RESULTADO DA SIMULAÇÃO ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Período: " + dias + " dias");
        System.out.println();
        System.out.println(resultado);
    }
    
    private int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private double lerValor() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    public static void main(String[] args) {
        SistemaVcRiquinho sistema = new SistemaVcRiquinho();
        sistema.executar();
    }
}
