import java.time.LocalDate;

public class Salgadinho extends Prato {
    private String tipo;
    private String massa;
    private String recheio;
    
    public Salgadinho(String nome, double precoVenda, LocalDate dataValidade, double peso, 
                      String tipo, String massa, String recheio) {
        super(nome, precoVenda, dataValidade, peso);
        this.tipo = tipo;
        this.massa = massa;
        this.recheio = recheio;
    }
    
    @Override
    public double calcularPreco() {
        double precoBase = precoVenda;
        
        if (tipo.toLowerCase().equals("assado")) {
            precoBase += 2.0;
        }
        
        if (massa.toLowerCase().contains("integral") || 
            massa.toLowerCase().contains("artesanal")) {
            precoBase += 1.5;
        }
        
        return precoBase;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
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
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Tipo: " + tipo + 
               ", Massa: " + massa + 
               ", Recheio: " + recheio;
    }
} 