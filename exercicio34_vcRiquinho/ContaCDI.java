package exercicio34_vcRiquinho;
public class ContaCDI extends Conta {
    private static final double TAXA_CDI_DIARIA = 0.01 / 30;
    private static final double TAXA_SERVICO = 0.0007;
    
    public ContaCDI(String numero, Cliente titular) {
        super(numero, titular);
    }
    
    @Override
    public double calcularRendimento(int dias) {
        double rendimentoDiario = saldo * TAXA_CDI_DIARIA;
        return rendimentoDiario * dias;
    }
    
    @Override
    public double calcularTaxaServico(double rendimento) {
        return rendimento * TAXA_SERVICO;
    }
} 