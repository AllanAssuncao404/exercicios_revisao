package com.lanchonete.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Pedido da lanchonete.
 * Contém nome do cliente, pratos consumidos e taxa de serviço.
 */
public class Pedido {
    private static int contadorPedidos = 1;
    
    private int numeroPedido;
    private String nomeCliente;
    private List<Prato> pratos;
    private double taxaServico;
    private LocalDateTime dataHoraPedido;
    
    public Pedido(String nomeCliente, double taxaServico) {
        this.numeroPedido = contadorPedidos++;
        this.nomeCliente = nomeCliente;
        this.pratos = new ArrayList<>();
        this.taxaServico = taxaServico;
        this.dataHoraPedido = LocalDateTime.now();
    }
    
    public void adicionarPrato(Prato prato) {
        if (prato.isValido()) {
            pratos.add(prato);
        } else {
            throw new IllegalArgumentException("Prato fora da validade: " + prato.getDescricao());
        }
    }
    
    public void removerPrato(Prato prato) {
        pratos.remove(prato);
    }
    
    public double calcularSubtotal() {
        return pratos.stream().mapToDouble(Prato::getPrecoVenda).sum();
    }
    
    public double calcularTotal() {
        return calcularSubtotal() + taxaServico;
    }
    
    public double calcularTroco(double valorRecebido) {
        double total = calcularTotal();
        if (valorRecebido < total) {
            throw new IllegalArgumentException("Valor recebido insuficiente!");
        }
        return valorRecebido - total;
    }
    
    // Getters e Setters
    public int getNumeroPedido() {
        return numeroPedido;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public List<Prato> getPratos() {
        return new ArrayList<>(pratos); // Retorna cópia para evitar modificações externas
    }
    
    public double getTaxaServico() {
        return taxaServico;
    }
    
    public void setTaxaServico(double taxaServico) {
        this.taxaServico = taxaServico;
    }
    
    public LocalDateTime getDataHoraPedido() {
        return dataHoraPedido;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PEDIDO #").append(numeroPedido).append(" ===\n");
        sb.append("Cliente: ").append(nomeCliente).append("\n");
        sb.append("Data/Hora: ").append(dataHoraPedido).append("\n\n");
        sb.append("PRATOS:\n");
        
        for (Prato prato : pratos) {
            sb.append("- ").append(prato.toString()).append("\n");
        }
        
        sb.append("\nSubtotal: R$ ").append(String.format("%.2f", calcularSubtotal())).append("\n");
        sb.append("Taxa de Serviço: R$ ").append(String.format("%.2f", taxaServico)).append("\n");
        sb.append("TOTAL: R$ ").append(String.format("%.2f", calcularTotal())).append("\n");
        
        return sb.toString();
    }
}
