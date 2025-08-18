public class TestarCadastro {
    public static void main(String[] args) {
        // Criando o sistema de cadastro
        CadastroPessoas cadastro = new CadastroPessoas();
        
        System.out.println("=== SISTEMA DE CADASTRO DE PESSOAS ===\n");
        
        // Criando objetos de cada subclasse de Pessoa
        
        // Cliente
        Data nascCliente = new Data(15, 3, 1990);
        Cliente cliente1 = new Cliente("João Silva", nascCliente, 1001);
        
        // Funcionário
        Data nascFuncionario = new Data(22, 7, 1985);
        Funcionario funcionario1 = new Funcionario("Maria Santos", nascFuncionario, 3500.00f);
        
        // Gerente
        Data nascGerente = new Data(10, 12, 1980);
        Gerente gerente1 = new Gerente("Carlos Oliveira", nascGerente, 8000.00f, "Vendas");
        
        // Cadastrando as pessoas
        cadastro.cadastrarPessoa(cliente1);
        cadastro.cadastrarPessoa(funcionario1);
        cadastro.cadastrarPessoa(gerente1);
        
        // Imprimindo todo o cadastro
        cadastro.imprimeCadastro();
        
        // Demonstrando polimorfismo - chamando imprimeDados() de cada objeto
        System.out.println("=== DEMONSTRAÇÃO DE POLIMORFISMO ===\n");
        
        Pessoa[] pessoas = {cliente1, funcionario1, gerente1};
        
        for (Pessoa pessoa : pessoas) {
            pessoa.imprimeDados();
            System.out.println();
        }
        
        // Demonstrando cálculo de impostos
        System.out.println("=== CÁLCULO DE IMPOSTOS ===");
        System.out.println("Imposto do Funcionário: R$ " + 
                          String.format("%.2f", funcionario1.calculaImposto()));
        System.out.println("Imposto do Gerente: R$ " + 
                          String.format("%.2f", gerente1.calculaImposto()));
        System.out.println("===========================");
    }
}
