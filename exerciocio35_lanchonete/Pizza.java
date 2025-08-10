import java.time.LocalDate;

public class Pizza extends Prato {
    private String molho;
    private String recheio;
    private String borda;
    
    public Pizza(String nome, double precoVenda, LocalDate dataValidade, double peso, 
                 String molho, String recheio, String borda) {
        super(nome, precoVenda, dataValidade, peso);
        this.molho = molho;
        this.recheio = recheio;
        this.borda = borda;
    }
    
    @Override
    public double calcularPreco() {
        double precoBase = precoVenda;
        
        if (borda.toLowerCase().contains("recheada")) {
            precoBase += 5.0;
        }
        
        if (recheio.toLowerCase().contains("especial") || 
            recheio.toLowerCase().contains("premium")) {
            precoBase += 8.0;
        }
        
        return precoBase;
    }
    
    public String getMolho() {
        return molho;
    }
    
    public void setMolho(String molho) {
        this.molho = molho;
    }
    
    public String getRecheio() {
        return recheio;
    }
    
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
    
    public String getBorda() {
        return borda;
    }
    
    public void setBorda(String borda) {
        this.borda = borda;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Molho: " + molho + 
               ", Recheio: " + recheio + 
               ", Borda: " + borda;
    }
} 