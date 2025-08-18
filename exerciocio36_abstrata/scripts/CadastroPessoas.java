import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
    private List<Pessoa> qtdAtual;
    
    public CadastroPessoas() {
        this.qtdAtual = new ArrayList<>();
    }
    
    // Método para cadastrar uma pessoa
    public void cadastrarPessoa(Pessoa pessoa) {
        qtdAtual.add(pessoa);
        System.out.println("Pessoa cadastrada com sucesso!");
    }
    
    // Método para imprimir todo o cadastro
    public void imprimeCadastro() {
        System.out.println("\n=== RELATÓRIO COMPLETO DO CADASTRO ===");
        System.out.println("Total de pessoas cadastradas: " + qtdAtual.size());
        System.out.println("======================================\n");
        
        if (qtdAtual.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        
        for (int i = 0; i < qtdAtual.size(); i++) {
            System.out.println("Registro " + (i + 1) + ":");
            qtdAtual.get(i).imprimeDados();
            System.out.println();
        }
    }
    
    // Método para obter o número de pessoas cadastradas
    public int getQuantidadePessoas() {
        return qtdAtual.size();
    }
    
    // Método para obter uma pessoa específica
    public Pessoa getPessoa(int indice) {
        if (indice >= 0 && indice < qtdAtual.size()) {
            return qtdAtual.get(indice);
        }
        return null;
    }
}
