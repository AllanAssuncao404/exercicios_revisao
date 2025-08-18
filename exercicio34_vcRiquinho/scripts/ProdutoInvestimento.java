// Classe abstrata base para produtos de investimento
public abstract class ProdutoInvestimento {
    protected String nome;
    protected String descricao;
    
    public ProdutoInvestimento(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    
    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    // Método abstrato para calcular rendimento
    public abstract double calcularRendimento(double valor, int dias);
    
    // Método abstrato para verificar se está dentro da carência
    public abstract boolean dentroCarencia(int dias);
    
    // Método abstrato para obter tipo do produto
    public abstract String getTipoProduto();
    
    @Override
    public String toString() {
        return String.format("%s - %s: %s", getTipoProduto(), nome, descricao);
    }
}
