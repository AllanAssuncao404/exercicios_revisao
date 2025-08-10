package abstrata;

public class Gerente extends Funcionario {
    private String area;
    
    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }
    
    // Getter e Setter
    public String getArea() {
        return area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    
    // Sobrescreve o método calculaImposto (mesmo valor de 5% do salário)
    @Override
    public float calculaImposto() {
        return salario * 0.05f;
    }
    
    @Override
    public void imprimeDados() {
        System.out.println("=== DADOS DO GERENTE ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + nascimento);
        System.out.println("Salário: R$ " + String.format("%.2f", salario));
        System.out.println("Imposto (5%): R$ " + String.format("%.2f", calculaImposto()));
        System.out.println("Área: " + area);
        System.out.println("Tipo: Gerente");
        System.out.println("=======================\n");
    }
} 