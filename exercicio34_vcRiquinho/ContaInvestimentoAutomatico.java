package exercicio34_vcRiquinho;
import java.util.ArrayList;
import java.util.List;

public class ContaInvestimentoAutomatico extends Conta {
    private List<Investimento> investimentos;
    
    public ContaInvestimentoAutomatico(String numero, Cliente titular) {
        super(numero, titular);
        this.investimentos = new ArrayList<>();
    }
    
    public void adicionarInvestimento(Investimento investimento) {
        investimentos.add(investimento);
    }
    
    @Override
    public double calcularRendimento(int dias) {
        double rendimentoTotal = 0.0;
        for (Investimento inv : investimentos) {
            if (inv.podeSerResgatado(dias)) {
                rendimentoTotal += inv.calcularRendimento(dias);
            }
        }
        return rendimentoTotal;
    }
    
    @Override
    public double calcularTaxaServico(double rendimento) {
        return rendimento * titular.getTaxaInvestimentoAutomatico();
    }
    
    public List<Investimento> getInvestimentos() {
        return new ArrayList<>(investimentos);
    }
} 