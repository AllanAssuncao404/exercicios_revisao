package com.lanchonete.model;

import java.time.LocalDate;

/**
 * Classe que representa um Salgadinho.
 * Contém informações sobre tipo (frito ou assado), massa e recheio.
 */
public class Salgadinho extends Prato {
    public enum TipoSalgadinho {
        FRITO, ASSADO
    }
    
    private TipoSalgadinho tipo;
    private String massa;
    private String recheio;
    
    public Salgadinho(double precoVenda, LocalDate dataValidade, double peso,
                      TipoSalgadinho tipo, String massa, String recheio) {
        super(precoVenda, dataValidade, peso);
        this.tipo = tipo;
        this.massa = massa;
        this.recheio = recheio;
    }
    
    @Override
    public String getDescricao() {
        return String.format("Salgadinho %s de %s com massa %s", 
                           tipo.toString().toLowerCase(), recheio, massa);
    }
    
    // Getters e Setters
    public TipoSalgadinho getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoSalgadinho tipo) {
        this.tipo = tipo;
    }
    
    public String getMassa() {
        return massa;
    }
    
    public void setMassa(String massa) {
        this.massa = massa;
    }
    
    public String getRecheio() {
        return recheio;
    }
    
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
}
