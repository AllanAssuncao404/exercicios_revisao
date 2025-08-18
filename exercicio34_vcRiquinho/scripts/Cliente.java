// Classe abstrata base para clientes
public abstract class Cliente {
    protected String nome;
    protected String email;
    protected java.util.List<Conta> contas;
    
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.contas = new java.util.ArrayList<>();
    }
    
    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public java.util.List<Conta> getContas() { return contas; }
    
    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }
    
    public void removerConta(Conta conta) {
        this.contas.remove(conta);
    }
    
    // Método abstrato para obter documento
    public abstract String getDocumento();
    
    // Método abstrato para obter tipo de cliente
    public abstract String getTipoCliente();
    
    // Método abstrato para obter taxa de serviço para investimento automático
    public abstract double getTaxaServicoInvestimentoAutomatico();
    
    @Override
    public String toString() {
        return String.format("%s - %s (%s) - Email: %s - Contas: %d", 
            getTipoCliente(), nome, getDocumento(), email, contas.size());
    }
}
