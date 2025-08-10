package exercicio34_vcRiquinho;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    protected String nome;
    protected String email;
    protected List<Conta> contas;
    
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.contas = new ArrayList<>();
    }
    
    public abstract String getDocumento();
    public abstract double getTaxaInvestimentoAutomatico();
    
    public void adicionarConta(Conta conta) {
        if (contas.isEmpty()) {
            contas.add(conta);
        } else {
            contas.add(conta);
        }
    }
    
    public void removerConta(Conta conta) {
        if (contas.size() > 1) {
            contas.remove(conta);
        } else {
            throw new IllegalStateException("Cliente deve ter pelo menos uma conta");
        }
    }
    
    public List<Conta> getContas() {
        return new ArrayList<>(contas);
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", documento='" + getDocumento() + '\'' +
                ", contas=" + contas.size() +
                '}';
    }
} 