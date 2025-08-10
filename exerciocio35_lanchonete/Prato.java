import java.time.LocalDate;

public abstract class Prato {
    protected double precoVenda;
    protected LocalDate dataValidade;
    protected double peso;
    protected String nome;
    
    public Prato(String nome, double precoVenda, LocalDate dataValidade, double peso) {
        this.nome = nome;
        this.precoVenda = precoVenda;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }
    
    public abstract double calcularPreco();
    
    public double getPrecoVenda() {
        return precoVenda;
    }
    
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    public LocalDate getDataValidade() {
        return dataValidade;
    }
    
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + 
               ", Preço: R$ " + String.format("%.2f", precoVenda) + 
               ", Peso: " + peso + "g" +
               ", Validade: " + dataValidade;
    }
} 