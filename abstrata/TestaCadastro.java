package abstrata;

public class TestaCadastro {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CADASTRO DE PESSOAS ===");
        
        // Criando instancia do cadastro
        CadastroPessoas cadastro = new CadastroPessoas();
        
        // Criando objetos de cada subclasse de Pessoa
        Data data1 = new Data(15, 3, 1990);
        Data data2 = new Data(22, 7, 1985);
        Data data3 = new Data(10, 12, 1975);
        
        Cliente cliente = new Cliente("Joao Silva", data1, 1001);
        Funcionario funcionario = new Funcionario("Maria Santos", data2, 2500.00f);
        Gerente gerente = new Gerente("Carlos Oliveira", data3, 5000.00f, "Vendas");
        
        // Cadastrando as pessoas
        System.out.println("Cadastrando pessoas...");
        cadastro.cadastraPessoa(cliente);
        cadastro.cadastraPessoa(funcionario);
        cadastro.cadastraPessoa(gerente);
        
        System.out.println("==================================================");
        
        // Imprimindo todo o cadastro
        cadastro.imprimeCadastro();
        
        System.out.println("=== FIM DO TESTE ===");
    }
} 