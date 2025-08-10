package exercicio34_vcRiquinho;
public class InvestimentoRendaFixa extends Investimento {
    private double rendimentoMensal;
    private int periodoCarencia;
    
    public InvestimentoRendaFixa(String nome, String descricao, double valorInvestido, 
                                double rendimentoMensal, int periodoCarencia) {
        super(nome, descricao, valorInvestido);
        this.rendimentoMensal = rendimentoMensal;
        this.periodoCarencia = periodoCarencia;
    }
    
    @Override
    public double calcularRendimento(int dias) {
        if (dias < periodoCarencia) {
            return 0.0;
        }
        
        double rendimentoDiario = rendimentoMensal / 30.0;
        return valorInvestido * rendimentoDiario * dias;
    }
    
    @Override
    public boolean podeSerResgatado(int dias) {
        return dias >= periodoCarencia;
    }
    
    public double getRendimentoMensal() {
        return rendimentoMensal;
    }
    
    public int getPeriodoCarencia() {
        return periodoCarencia;
    }
    
    public void setRendimentoMensal(double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }
    
    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
    }
} 