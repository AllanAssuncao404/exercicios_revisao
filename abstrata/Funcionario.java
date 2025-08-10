package abstrata;

public class Funcionario extends Pessoa {
    protected float salario;
    
    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }
    
    // Getter e Setter
    public float getSalario() {
        return salario;
    }
    
    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    // Método para calcular imposto (5% do salário)
    public float calculaImposto() {
        return salario * 0.05f;
    }
    
    @Override
    public void imprimeDados() {
        System.out.println("=== DADOS DO FUNCIONARIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + nascimento);
        System.out.println("Salario: R$ " + String.format("%.2f", salario));
        System.out.println("Imposto (5%): R$ " + String.format("%.2f", calculaImposto()));
        System.out.println("Tipo: Funcionario");
        System.out.println("============================");
    }
} 