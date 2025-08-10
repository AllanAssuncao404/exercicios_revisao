package exercicio34_vcRiquinho;
public abstract class Conta {
    protected String numero;
    protected double saldo;
    protected Cliente titular;
    
    public Conta(String numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }
    
    public abstract double calcularRendimento(int dias);
    public abstract double calcularTaxaServico(double rendimento);
    
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }
    }
    
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
        } else {
            throw new IllegalArgumentException("Valor inválido ou saldo insuficiente");
        }
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public Cliente getTitular() {
        return titular;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", saldo=" + saldo +
                ", tipo='" + this.getClass().getSimpleName() + '\'' +
                '}';
    }
} 