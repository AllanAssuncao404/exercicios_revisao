import java.time.LocalDate;

public class Lanche extends Prato {
    private String pao;
    private String recheio;
    private String molho;
    
    public Lanche(String nome, double precoVenda, LocalDate dataValidade, double peso, 
                  String pao, String recheio, String molho) {
        super(nome, precoVenda, dataValidade, peso);
        this.pao = pao;
        this.recheio = recheio;
        this.molho = molho;
    }
    
    @Override
    public double calcularPreco() {
        double precoBase = precoVenda;
        
        if (pao.toLowerCase().contains("integral") || 
            pao.toLowerCase().contains("artesanal")) {
            precoBase += 3.0;
        }
        
        if (recheio.toLowerCase().contains("especial") || 
            recheio.toLowerCase().contains("premium")) {
            precoBase += 6.0;
        }
        
        return precoBase;
    }
    
    public String getPao() {
        return pao;
    }
    
    public void setPao(String pao) {
        this.pao = pao;
    }
    
    public String getRecheio() {
        return recheio;
    }
    
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
    
    public String getMolho() {
        return molho;
    }
    
    public void setMolho(String molho) {
        this.molho = molho;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Pão: " + pao + 
               ", Recheio: " + recheio + 
               ", Molho: " + molho;
    }
} 