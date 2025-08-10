package abstrata;

public class Cliente extends Pessoa {
    private int codigo;
    
    public Cliente(String nome, Data nascimento, int codigo) {
        super(nome, nascimento);
        this.codigo = codigo;
    }
    
    // Getter e Setter
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public void imprimeDados() {
        System.out.println("=== DADOS DO CLIENTE ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + nascimento);
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: Cliente");
        System.out.println("========================\n");
    }
} 