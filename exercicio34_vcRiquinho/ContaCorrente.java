package exercicio34_vcRiquinho;
public class ContaCorrente extends Conta {
    
    public ContaCorrente(String numero, Cliente titular) {
        super(numero, titular);
    }
    
    @Override
    public double calcularRendimento(int dias) {
        return 0.0;
    }
    
    @Override
    public double calcularTaxaServico(double rendimento) {
        return 0.0;
    }
} 