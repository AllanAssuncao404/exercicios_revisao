// Conta Corrente - não gera rendimento
public class ContaCorrente extends Conta {
    
    public ContaCorrente(String numeroConta, Cliente cliente) {
        super(numeroConta, cliente);
    }
    
    @Override
    public double calcularRendimento(int dias) {
        return 0.0; // Conta corrente não gera rendimento
    }
    
    @Override
    public String getTipoConta() {
        return "Conta Corrente";
    }
    
    @Override
    public double calcularTaxaServico(double rendimento) {
        return 0.0; // Sem taxa pois não há rendimento
    }
}
