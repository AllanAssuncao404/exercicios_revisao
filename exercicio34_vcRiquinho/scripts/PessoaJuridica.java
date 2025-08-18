// Classe para Pessoa Jurídica
public class PessoaJuridica extends Cliente {
    private String cnpj;
    
    public PessoaJuridica(String nome, String cnpj, String email) {
        super(nome, email);
        this.cnpj = cnpj;
    }
    
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    
    @Override
    public String getDocumento() {
        return cnpj;
    }
    
    @Override
    public String getTipoCliente() {
        return "Pessoa Jurídica";
    }
    
    @Override
    public double getTaxaServicoInvestimentoAutomatico() {
        return 0.0015; // 0,15%
    }
}
