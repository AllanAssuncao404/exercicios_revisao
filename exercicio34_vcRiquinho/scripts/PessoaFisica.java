// Classe para Pessoa Física
public class PessoaFisica extends Cliente {
    private String cpf;
    
    public PessoaFisica(String nome, String cpf, String email) {
        super(nome, email);
        this.cpf = cpf;
    }
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    
    @Override
    public String getDocumento() {
        return cpf;
    }
    
    @Override
    public String getTipoCliente() {
        return "Pessoa Física";
    }
    
    @Override
    public double getTaxaServicoInvestimentoAutomatico() {
        return 0.001; // 0,1%
    }
}
