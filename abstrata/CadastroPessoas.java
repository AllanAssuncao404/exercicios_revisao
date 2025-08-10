package abstrata;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {
    private List<Pessoa> pessoas;
    private int qtdAtual;
    
    public CadastroPessoas() {
        this.pessoas = new ArrayList<>();
        this.qtdAtual = 0;
    }
    
    // Método para cadastrar uma pessoa
    public void cadastraPessoa(Pessoa pessoa) {
        if (pessoa != null) {
            pessoas.add(pessoa);
            qtdAtual++;
            System.out.println("Pessoa cadastrada com sucesso!");
        } else {
            System.out.println("Erro: Pessoa não pode ser nula!");
        }
    }
    
    // Método para imprimir todo o cadastro
    public void imprimeCadastro() {
        System.out.println("=== CADASTRO DE PESSOAS ===");
        System.out.println("Quantidade total: " + qtdAtual);
        System.out.println("===========================\n");
        
        if (qtdAtual == 0) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (int i = 0; i < pessoas.size(); i++) {
                System.out.println("--- Pessoa " + (i + 1) + " ---");
                pessoas.get(i).imprimeDados();
            }
        }
    }
    
    // Getters
    public int getQtdAtual() {
        return qtdAtual;
    }
    
    public List<Pessoa> getPessoas() {
        return new ArrayList<>(pessoas); // Retorna uma cópia para evitar modificação externa
    }
} 