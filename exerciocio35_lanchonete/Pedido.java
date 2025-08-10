import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String nomeCliente;
    private double taxaServico;
    private List<Prato> itensConsumidos;
    
    public Pedido(String nomeCliente, double taxaServico) {
        this.nomeCliente = nomeCliente;
        this.taxaServico = taxaServico;
        this.itensConsumidos = new ArrayList<>();
    }
    
    public void adicionarItem(Prato prato) {
        itensConsumidos.add(prato);
    }
    
    public void removerItem(Prato prato) {
        itensConsumidos.remove(prato);
    }
    
    public double calcularTotal() {
        double subtotal = 0.0;
        for (Prato prato : itensConsumidos) {
            subtotal += prato.calcularPreco();
        }
        return subtotal + taxaServico;
    }
    
    public void mostrarFatura() {
        System.out.println("=== FATURA - LANCHONETE QUASE TRÊS LANCHES ===");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Data: " + java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("\nITENS CONSUMIDOS:");
        System.out.println("----------------------------------------");
        
        double subtotal = 0.0;
        for (int i = 0; i < itensConsumidos.size(); i++) {
            Prato prato = itensConsumidos.get(i);
            double preco = prato.calcularPreco();
            subtotal += preco;
            System.out.printf("%d. %s\n", i + 1, prato.toString());
            System.out.printf("   Preço: R$ %.2f\n", preco);
            System.out.println();
        }
        
        System.out.println("----------------------------------------");
        System.out.printf("Subtotal: R$ %.2f\n", subtotal);
        System.out.printf("Taxa de Serviço: R$ %.2f\n", taxaServico);
        System.out.println("----------------------------------------");
        System.out.printf("TOTAL: R$ %.2f\n", calcularTotal());
        System.out.println("========================================");
    }
    
    public double calcularTroco(double valorRecebido) {
        return valorRecebido - calcularTotal();
    }
    
    public void processarPagamento(double valorRecebido) {
        double total = calcularTotal();
        double troco = calcularTroco(valorRecebido);
        
        System.out.println("\n=== PROCESSAMENTO DO PAGAMENTO ===");
        System.out.printf("Total da conta: R$ %.2f\n", total);
        System.out.printf("Valor recebido: R$ %.2f\n", valorRecebido);
        
        if (troco >= 0) {
            System.out.printf("Troco: R$ %.2f\n", troco);
            System.out.println("Pagamento realizado com sucesso!");
        } else {
            System.out.printf("Valor insuficiente! Faltam R$ %.2f\n", Math.abs(troco));
        }
        System.out.println("=================================");
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public double getTaxaServico() {
        return taxaServico;
    }
    
    public void setTaxaServico(double taxaServico) {
        this.taxaServico = taxaServico;
    }
    
    public List<Prato> getItensConsumidos() {
        return itensConsumidos;
    }
    
    public void setItensConsumidos(List<Prato> itensConsumidos) {
        this.itensConsumidos = itensConsumidos;
    }
} 