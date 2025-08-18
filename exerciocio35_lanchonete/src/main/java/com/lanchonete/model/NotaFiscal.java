package com.lanchonete.model;

import java.time.format.DateTimeFormatter;

/**
 * Classe responsável por gerar a nota fiscal do pedido.
 */
public class NotaFiscal {
    private Pedido pedido;
    private double valorRecebido;
    private double troco;
    
    public NotaFiscal(Pedido pedido, double valorRecebido) {
        this.pedido = pedido;
        this.valorRecebido = valorRecebido;
        this.troco = pedido.calcularTroco(valorRecebido);
    }
    
    public String gerarNotaFiscal() {
        StringBuilder nf = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        nf.append("===============================================\n");
        nf.append("           LANCHONETE QUASE TRÊS LANCHES      \n");
        nf.append("                  NOTA FISCAL                 \n");
        nf.append("===============================================\n\n");
        
        nf.append("Pedido #: ").append(pedido.getNumeroPedido()).append("\n");
        nf.append("Cliente: ").append(pedido.getNomeCliente()).append("\n");
        nf.append("Data/Hora: ").append(pedido.getDataHoraPedido().format(formatter)).append("\n\n");
        
        nf.append("ITENS CONSUMIDOS:\n");
        nf.append("-----------------------------------------------\n");
        
        for (Prato prato : pedido.getPratos()) {
            nf.append(String.format("%-35s R$ %8.2f\n", 
                     prato.getDescricao(), prato.getPrecoVenda()));
        }
        
        nf.append("-----------------------------------------------\n");
        nf.append(String.format("Subtotal:                        R$ %8.2f\n", pedido.calcularSubtotal()));
        nf.append(String.format("Taxa de Serviço:                 R$ %8.2f\n", pedido.getTaxaServico()));
        nf.append("-----------------------------------------------\n");
        nf.append(String.format("TOTAL:                           R$ %8.2f\n\n", pedido.calcularTotal()));
        
        nf.append("PAGAMENTO:\n");
        nf.append(String.format("Valor Recebido:                  R$ %8.2f\n", valorRecebido));
        nf.append(String.format("Troco:                           R$ %8.2f\n\n", troco));
        
        nf.append("===============================================\n");
        nf.append("         Obrigado pela preferência!          \n");
        nf.append("===============================================\n");
        
        return nf.toString();
    }
    
    // Getters
    public Pedido getPedido() {
        return pedido;
    }
    
    public double getValorRecebido() {
        return valorRecebido;
    }
    
    public double getTroco() {
        return troco;
    }
}
