// Conta CDI - rende 1/30 do CDI diariamente
public class ContaCDI extends Conta {
    private static final double CDI_ANUAL = 0.1275; // 12,75% ao ano (exemplo)
    private static final double TAXA_SERVICO = 0.0007; // 0,07%
    
    public ContaCDI(String numeroConta, Cliente cliente) {
        super(numeroConta, cliente);
    }
    
    @Override
    public double calcularRendimento(int dias) {
        // CDI diário = CDI anual / 365
        double cdiDiario = CDI_ANUAL / 365;
        // Rendimento = saldo * (1/30 do CDI diário) * dias
        return saldo * (cdiDiario / 30) * dias;
    }
    
    @Override
    public String getTipoConta() {
        return "Conta CDI";
    }
    
    @Override
    public double calcularTaxaServico(double rendimento) {
        return rendimento * TAXA_SERVICO;
    }
}
