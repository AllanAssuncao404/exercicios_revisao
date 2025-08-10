package abstrata;

public abstract class Pessoa {
    protected String nome;
    protected Data nascimento;
    
    public Pessoa(String nome, Data nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Data getNascimento() {
        return nascimento;
    }
    
    public void setNascimento(Data nascimento) {
        this.nascimento = nascimento;
    }
    
    // Método abstrato que deve ser implementado pelas subclasses
    public abstract void imprimeDados();
} 