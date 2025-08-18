// Classe abstrata base para contas
public abstract class Conta {
    protected String numeroConta;
    protected double saldo;
    protected Cliente cliente;
    
    public Conta(String numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = 0.0;
    }
    
    // Getters e Setters
    public String getNumeroConta() { return numeroConta; }
    public double getSaldo() { return saldo; }
    public Cliente getCliente() { return cliente; }
    
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }
    
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }
    
    // Método abstrato para calcular rendimento
    public abstract double calcularRendimento(int dias);
    
    // Método abstrato para obter tipo da conta
    public abstract String getTipoConta();
    
    // Método abstrato para calcular taxa de serviço
    public abstract double calcularTaxaServico(double rendimento);
    
    @Override
    public String toString() {
        return String.format("%s - Conta: %s - Saldo: R$ %.2f", 
            getTipoConta(), numeroConta, saldo);
    }
}
