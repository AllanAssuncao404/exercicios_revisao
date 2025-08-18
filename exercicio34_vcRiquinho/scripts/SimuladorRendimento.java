// Classe para simular rendimentos e calcular taxas de serviço
public class SimuladorRendimento {
    
    public static class ResultadoSimulacao {
        private double rendimentoBruto;
        private double taxaServico;
        private double rendimentoLiquido;
        private java.util.List<String> observacoes;
        
        public ResultadoSimulacao() {
            this.observacoes = new java.util.ArrayList<>();
        }
        
        // Getters e Setters
        public double getRendimentoBruto() { return rendimentoBruto; }
        public void setRendimentoBruto(double rendimentoBruto) { this.rendimentoBruto = rendimentoBruto; }
        
        public double getTaxaServico() { return taxaServico; }
        public void setTaxaServico(double taxaServico) { this.taxaServico = taxaServico; }
        
        public double getRendimentoLiquido() { return rendimentoLiquido; }
        public void setRendimentoLiquido(double rendimentoLiquido) { this.rendimentoLiquido = rendimentoLiquido; }
        
        public java.util.List<String> getObservacoes() { return observacoes; }
        public void adicionarObservacao(String observacao) { this.observacoes.add(observacao); }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Rendimento Bruto: R$ %.2f\n", rendimentoBruto));
            sb.append(String.format("Taxa de Serviço: R$ %.2f\n", taxaServico));
            sb.append(String.format("Rendimento Líquido: R$ %.2f\n", rendimentoLiquido));
            
            if (!observacoes.isEmpty()) {
                sb.append("\nObservações:\n");
                for (String obs : observacoes) {
                    sb.append("- ").append(obs).append("\n");
                }
            }
            
            return sb.toString();
        }
    }
    
    public static ResultadoSimulacao simularRendimento(Cliente cliente, int dias) {
        ResultadoSimulacao resultado = new ResultadoSimulacao();
        double rendimentoTotal = 0.0;
        double taxaServicoTotal = 0.0;
        
        for (Conta conta : cliente.getContas()) {
            double rendimentoConta = conta.calcularRendimento(dias);
            double taxaServicoConta = conta.calcularTaxaServico(rendimentoConta);
            
            // Verificar produtos em carência para contas de investimento automático
            if (conta instanceof ContaInvestimentoAutomatico) {
                ContaInvestimentoAutomatico contaInv = (ContaInvestimentoAutomatico) conta;
                for (ProdutoInvestimento produto : contaInv.getProdutos()) {
                    if (produto instanceof RendaFixa && produto.dentroCarencia(dias)) {
                        resultado.adicionarObservacao(
                            String.format("Produto '%s' está em período de carência (%d dias)", 
                                produto.getNome(), ((RendaFixa) produto).getPeriodoCarencia())
                        );
                    }
                }
            }
            
            rendimentoTotal += rendimentoConta;
            taxaServicoTotal += taxaServicoConta;
        }
        
        resultado.setRendimentoBruto(rendimentoTotal);
        resultado.setTaxaServico(taxaServicoTotal);
        resultado.setRendimentoLiquido(rendimentoTotal - taxaServicoTotal);
        
        return resultado;
    }
}
