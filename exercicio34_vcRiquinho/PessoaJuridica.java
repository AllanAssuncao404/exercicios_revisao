package exercicio34_vcRiquinho;
public class PessoaJuridica extends Cliente {
    private String cnpj;
    
    public PessoaJuridica(String nome, String email, String cnpj) {
        super(nome, email);
        this.cnpj = cnpj;
    }
    
    @Override
    public String getDocumento() {
        return cnpj;
    }
    
    @Override
    public double getTaxaInvestimentoAutomatico() {
        return 0.0015;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", contas=" + contas.size() +
                '}';
    }
} 