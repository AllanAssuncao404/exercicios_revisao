package com.lanchonete.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Classe que representa uma Pizza.
 * Contém informações sobre recheios, bordas e molhos.
 */
public class Pizza extends Prato {
    private List<String> recheios;
    private String tipoBorda;
    private boolean bordaRecheada;
    private List<String> molhos;
    
    public Pizza(double precoVenda, LocalDate dataValidade, double peso,
                 List<String> recheios, String tipoBorda, boolean bordaRecheada, 
                 List<String> molhos) {
        super(precoVenda, dataValidade, peso);
        this.recheios = recheios;
        this.tipoBorda = tipoBorda;
        this.bordaRecheada = bordaRecheada;
        this.molhos = molhos;
    }
    
    @Override
    public String getDescricao() {
        StringBuilder desc = new StringBuilder("Pizza");
        
        if (!recheios.isEmpty()) {
            desc.append(" de ").append(String.join(", ", recheios));
        }
        
        desc.append(" - Borda ").append(tipoBorda);
        if (bordaRecheada) {
            desc.append(" (recheada)");
        }
        
        if (!molhos.isEmpty()) {
            desc.append(" - Molhos: ").append(String.join(", ", molhos));
        }
        
        return desc.toString();
    }
    
    // Getters e Setters
    public List<String> getRecheios() {
        return recheios;
    }
    
    public void setRecheios(List<String> recheios) {
        this.recheios = recheios;
    }
    
    public String getTipoBorda() {
        return tipoBorda;
    }
    
    public void setTipoBorda(String tipoBorda) {
        this.tipoBorda = tipoBorda;
    }
    
    public boolean isBordaRecheada() {
        return bordaRecheada;
    }
    
    public void setBordaRecheada(boolean bordaRecheada) {
        this.bordaRecheada = bordaRecheada;
    }
    
    public List<String> getMolhos() {
        return molhos;
    }
    
    public void setMolhos(List<String> molhos) {
        this.molhos = molhos;
    }
}
