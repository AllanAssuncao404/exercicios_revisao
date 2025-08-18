// Produto de Renda Variável
public class RendaVariavel extends ProdutoInvestimento {
    private double rendimentoMensalEsperado;
    
    public RendaVariavel(String nome, String descricao, double rendimentoMensalEsperado) {
        super(nome, descricao);
        this.rendimentoMensalEsperado = rendimentoMensalEsperado;
    }
    
    public double getRendimentoMensalEsperado() { return rendimentoMensalEsperado; }
    public void setRendimentoMensalEsperado(double rendimentoMensalEsperado) { 
        this.rendimentoMensalEsperado = rendimentoMensalEsperado; 
    }
    
    @Override
    public double calcularRendimento(double valor, int dias) {
        // Rendimento proporcional aos dias (baseado no esperado)
        double rendimentoDiario = rendimentoMensalEsperado / 30;
        return valor * rendimentoDiario * dias;
    }
    
    @Override
    public boolean dentroCarencia(int dias) {
        return false; // Renda variável não tem carência
    }
    
    @Override
    public String getTipoProduto() {
        return "Renda Variável";
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" - Rendimento Esperado: %.2f%% ao mês", 
            rendimentoMensalEsperado * 100);
    }
}
