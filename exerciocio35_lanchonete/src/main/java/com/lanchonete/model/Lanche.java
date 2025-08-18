package com.lanchonete.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe que representa um Lanche.
 * Contém informações sobre tipo do pão, recheio e molhos (obrigatórios).
 */
public class Lanche extends Prato {
    private String tipoPao;
    private String recheio;
    private List<String> molhos; // obrigatório
    
    public Lanche(double precoVenda, LocalDate dataValidade, double peso,
                  String tipoPao, String recheio, List<String> molhos) {
        super(precoVenda, dataValidade, peso);
        this.tipoPao = tipoPao;
        this.recheio = recheio;
        this.molhos = molhos;
        
        // Validação: molhos são obrigatórios
        if (molhos == null || molhos.isEmpty()) {
            throw new IllegalArgumentException("Molhos são obrigatórios para lanches!");
        }
    }
    
    @Override
    public String getDescricao() {
        return String.format("Lanche de %s no pão %s - Molhos: %s", 
                           recheio, tipoPao, String.join(", ", molhos));
    }
    
    // Getters e Setters
    public String getTipoPao() {
        return tipoPao;
    }
    
    public void setTipoPao(String tipoPao) {
        this.tipoPao = tipoPao;
    }
    
    public String getRecheio() {
        return recheio;
    }
    
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
    
    public List<String> getMolhos() {
        return molhos;
    }
    
    public void setMolhos(List<String> molhos) {
        if (molhos == null || molhos.isEmpty()) {
            throw new IllegalArgumentException("Molhos são obrigatórios para lanches!");
        }
        this.molhos = molhos;
    }
}
