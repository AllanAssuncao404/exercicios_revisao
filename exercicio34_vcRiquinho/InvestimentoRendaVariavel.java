package exercicio34_vcRiquinho;
public class InvestimentoRendaVariavel extends Investimento {
    private double rendimentoMensalEsperado;
    
    public InvestimentoRendaVariavel(String nome, String descricao, double valorInvestido, 
                                   double rendimentoMensalEsperado) {
        super(nome, descricao, valorInvestido);
        this.rendimentoMensalEsperado = rendimentoMensalEsperado;
    }
    
    @Override
    public double calcularRendimento(int dias) {
        double rendimentoDiario = rendimentoMensalEsperado / 30.0;
        return valorInvestido * rendimentoDiario * dias;
    }
    
    @Override
    public boolean podeSerResgatado(int dias) {
        return true;
    }
    
    public double getRendimentoMensalEsperado() {
        return rendimentoMensalEsperado;
    }
    
    public void setRendimentoMensalEsperado(double rendimentoMensalEsperado) {
        this.rendimentoMensalEsperado = rendimentoMensalEsperado;
    }
} 