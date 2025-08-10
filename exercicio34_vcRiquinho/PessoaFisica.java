package exercicio34_vcRiquinho;
public class PessoaFisica extends Cliente {
    private String cpf;
    
    public PessoaFisica(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }
    
    @Override
    public String getDocumento() {
        return cpf;
    }
    
    @Override
    public double getTaxaInvestimentoAutomatico() {
        return 0.001;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", contas=" + contas.size() +
                '}';
    }
} 