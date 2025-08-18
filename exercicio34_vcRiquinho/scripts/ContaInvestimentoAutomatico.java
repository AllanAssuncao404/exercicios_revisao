// Conta de Investimento Automático
public class ContaInvestimentoAutomatico extends Conta {
    private java.util.List<ProdutoInvestimento> produtos;
    
    public ContaInvestimentoAutomatico(String numeroConta, Cliente cliente) {
        super(numeroConta, cliente);
        this.produtos = new java.util.ArrayList<>();
    }
    
    public void adicionarProduto(ProdutoInvestimento produto) {
        this.produtos.add(produto);
    }
    
    public void removerProduto(ProdutoInvestimento produto) {
        this.produtos.remove(produto);
    }
    
    public java.util.List<ProdutoInvestimento> getProdutos() {
        return produtos;
    }
    
    @Override
    public double calcularRendimento(int dias) {
        if (produtos.isEmpty()) return 0.0;
        
        double rendimentoTotal = 0.0;
        double valorPorProduto = saldo / produtos.size();
        
        for (ProdutoInvestimento produto : produtos) {
            rendimentoTotal += produto.calcularRendimento(valorPorProduto, dias);
        }
        
        return rendimentoTotal;
    }
    
    @Override
    public String getTipoConta() {
        return "Conta Investimento Automático";
    }
    
    @Override
    public double calcularTaxaServico(double rendimento) {
        return rendimento * cliente.getTaxaServicoInvestimentoAutomatico();
    }
}
