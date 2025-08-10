package exercicio34_vcRiquinho;
public abstract class Investimento {
    protected String nome;
    protected String descricao;
    protected double valorInvestido;
    
    public Investimento(String nome, String descricao, double valorInvestido) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorInvestido = valorInvestido;
    }
    
    public abstract double calcularRendimento(int dias);
    public abstract boolean podeSerResgatado(int dias);
    
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public double getValorInvestido() {
        return valorInvestido;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }
    
    @Override
    public String toString() {
        return "Investimento{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valorInvestido=" + valorInvestido +
                ", tipo='" + this.getClass().getSimpleName() + '\'' +
                '}';
    }
} 