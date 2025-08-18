package com.lanchonete.model;

import java.time.LocalDate;

/**
 * Classe abstrata que representa um prato genérico da lanchonete
 * Contém os atributos comuns a todos os pratos: preço, data de validade e peso
 */
public abstract class Prato {
    protected double precoVenda;
    protected LocalDate dataValidade;
    protected double peso; // em gramas
    
    public Prato(double precoVenda, LocalDate dataValidade, double peso) {
        this.precoVenda = precoVenda;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }
    
    // Método abstrato que deve ser implementado pelas classes filhas
    public abstract String getDescricao();
    
    // Método para verificar se o prato está dentro da validade
    public boolean isValido() {
        return dataValidade.isAfter(LocalDate.now()) || dataValidade.isEqual(LocalDate.now());
    }
    
    // Getters e Setters
    public double getPrecoVenda() {
        return precoVenda;
    }
    
    public void setPrecoVenda(double precoVenda) {
        if (precoVenda > 0) {
            this.precoVenda = precoVenda;
        }
    }
    
    public LocalDate getDataValidade() {
        return dataValidade;
    }
    
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s - R$ %.2f (%.0fg) - Validade: %s", 
                           getDescricao(), precoVenda, peso, dataValidade);
    }
}
