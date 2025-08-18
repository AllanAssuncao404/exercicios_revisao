// Produto de Renda Fixa
public class RendaFixa extends ProdutoInvestimento {
    private double rendimentoMensalFixo;
    private int periodoCarencia; // em dias
    
    public RendaFixa(String nome, String descricao, double rendimentoMensalFixo, int periodoCarencia) {
        super(nome, descricao);
        this.rendimentoMensalFixo = rendimentoMensalFixo;
        this.periodoCarencia = periodoCarencia;
    }
    
    public double getRendimentoMensalFixo() { return rendimentoMensalFixo; }
    public void setRendimentoMensalFixo(double rendimentoMensalFixo) { 
        this.rendimentoMensalFixo = rendimentoMensalFixo; 
    }
    
    public int getPeriodoCarencia() { return periodoCarencia; }
    public void setPeriodoCarencia(int periodoCarencia) { 
        this.periodoCarencia = periodoCarencia; 
    }
    
    @Override
    public double calcularRendimento(double valor, int dias) {
        if (dentroCarencia(dias)) {
            return 0.0; // Não há rendimento durante a carência
        }
        
        // Rendimento proporcional aos dias
        double rendimentoDiario = rendimentoMensalFixo / 30;
        return valor * rendimentoDiario * dias;
    }
    
    @Override
    public boolean dentroCarencia(int dias) {
        return dias < periodoCarencia;
    }
    
    @Override
    public String getTipoProduto() {
        return "Renda Fixa";
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" - Rendimento: %.2f%% ao mês - Carência: %d dias", 
            rendimentoMensalFixo * 100, periodoCarencia);
    }
}
