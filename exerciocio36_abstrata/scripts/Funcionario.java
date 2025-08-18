public class Funcionario extends Pessoa {
    protected float salario;
    
    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }
    
    // Getters e Setters
    public float getSalario() { return salario; }
    public void setSalario(float salario) { this.salario = salario; }
    
    // Método para calcular imposto (5% do salário)
    public float calculaImposto() {
        return salario * 0.05f;
    }
    
    @Override
    public void imprimeDados() {
        System.out.println("=== DADOS DO FUNCIONÁRIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + nascimento);
        System.out.println("Salário: R$ " + String.format("%.2f", salario));
        System.out.println("Imposto (5%): R$ " + String.format("%.2f", calculaImposto()));
        System.out.println("============================");
    }
}
