# Diagrama de Classes UML - Sistema VcRiquinho

## Diagrama em PlantUML

```plantuml
@startuml VcRiquinho

' Estilos
skinparam classAttributeIconSize 0
skinparam classFontSize 10
skinparam classFontStyle bold

' Classe principal do sistema
class VcRiquinho {
    - clientes: List<Cliente>
    - produtos: List<Investimento>
    - scanner: Scanner
    + VcRiquinho()
    + executar(): void
    - exibirMenu(): void
    - cadastrarCliente(): void
    - listarClientes(): void
    - cadastrarProduto(): void
    - listarProdutos(): void
    - simularRendimento(): void
    + main(args: String[]): void
}

' Hierarquia de Clientes
abstract class Cliente {
    # nome: String
    # email: String
    # contas: List<Conta>
    + Cliente(nome: String, email: String)
    + {abstract} getDocumento(): String
    + {abstract} getTaxaInvestimentoAutomatico(): double
    + adicionarConta(conta: Conta): void
    + removerConta(conta: Conta): void
    + getContas(): List<Conta>
    + getNome(): String
    + getEmail(): String
    + setNome(nome: String): void
    + setEmail(email: String): void
    + toString(): String
}

class PessoaFisica {
    - cpf: String
    + PessoaFisica(nome: String, email: String, cpf: String)
    + getDocumento(): String
    + getTaxaInvestimentoAutomatico(): double
    + getCpf(): String
    + setCpf(cpf: String): void
    + toString(): String
}

class PessoaJuridica {
    - cnpj: String
    + PessoaJuridica(nome: String, email: String, cnpj: String)
    + getDocumento(): String
    + getTaxaInvestimentoAutatico(): double
    + getCnpj(): String
    + setCnpj(cnpj: String): void
    + toString(): String
}

' Hierarquia de Contas
abstract class Conta {
    # numero: String
    # saldo: double
    # titular: Cliente
    + Conta(numero: String, titular: Cliente)
    + {abstract} calcularRendimento(dias: int): double
    + {abstract} calcularTaxaServico(rendimento: double): double
    + depositar(valor: double): void
    + sacar(valor: double): void
    + getSaldo(): double
    + getNumero(): String
    + getTitular(): Cliente
    + setSaldo(saldo: double): void
    + toString(): String
}

class ContaCorrente {
    + ContaCorrente(numero: String, titular: Cliente)
    + calcularRendimento(dias: int): double
    + calcularTaxaServico(rendimento: double): double
}

class ContaCDI {
    - TAXA_CDI_DIARIA: double
    - TAXA_SERVICO: double
    + ContaCDI(numero: String, titular: Cliente)
    + calcularRendimento(dias: int): double
    + calcularTaxaServico(rendimento: double): double
}

class ContaInvestimentoAutomatico {
    - investimentos: List<Investimento>
    + ContaInvestimentoAutomatico(numero: String, titular: Cliente)
    + adicionarInvestimento(investimento: Investimento): void
    + calcularRendimento(dias: int): double
    + calcularTaxaServico(rendimento: double): double
    + getInvestimentos(): List<Investimento>
}

' Hierarquia de Investimentos
abstract class Investimento {
    # nome: String
    # descricao: String
    # valorInvestido: double
    + Investimento(nome: String, descricao: String, valorInvestido: double)
    + {abstract} calcularRendimento(dias: int): double
    + {abstract} podeSerResgatado(dias: int): boolean
    + getNome(): String
    + getDescricao(): String
    + getValorInvestido(): double
    + setNome(nome: String): void
    + setDescricao(descricao: String): void
    + setValorInvestido(valorInvestido: double): void
    + toString(): String
}

class InvestimentoRendaFixa {
    - rendimentoMensal: double
    - periodoCarencia: int
    + InvestimentoRendaFixa(nome: String, descricao: String, valorInvestido: double, rendimentoMensal: double, periodoCarencia: int)
    + calcularRendimento(dias: int): double
    + podeSerResgatado(dias: int): boolean
    + getRendimentoMensal(): double
    + getPeriodoCarencia(): int
    + setRendimentoMensal(rendimentoMensal: double): void
    + setPeriodoCarencia(periodoCarencia: int): void
}

class InvestimentoRendaVariavel {
    - rendimentoMensalEsperado: double
    + InvestimentoRendaVariavel(nome: String, descricao: String, valorInvestido: double, rendimentoMensalEsperado: double)
    + calcularRendimento(dias: int): double
    + podeSerResgatado(dias: int): boolean
    + getRendimentoMensalEsperado(): double
    + setRendimentoMensalEsperado(rendimentoMensalEsperado: double): void
}

' Relacionamentos
VcRiquinho ||--o{ Cliente : gerencia
VcRiquinho ||--o{ Investimento : gerencia

Cliente ||--o{ Conta : possui
Cliente <|-- PessoaFisica
Cliente <|-- PessoaJuridica

Conta ||--o{ Cliente : pertence
Conta <|-- ContaCorrente
Conta <|-- ContaCDI
Conta <|-- ContaInvestimentoAutomatico

ContaInvestimentoAutomatico ||--o{ Investimento : contém

Investimento <|-- InvestimentoRendaFixa
Investimento <|-- InvestimentoRendaVariavel

@enduml

## Justificativa das Escolhas de Design

### 1. **Arquitetura em Camadas e Separação de Responsabilidades**

**Escolha:** Separação clara entre entidades de domínio (Cliente, Conta, Investimento) e a interface do usuário (VcRiquinho).

**Justificativa:** Esta separação permite que o sistema seja facilmente expandido para diferentes interfaces (web, desktop, API) sem modificar a lógica de negócio. O princípio de responsabilidade única é mantido, onde cada classe tem uma função específica e bem definida.

### 2. **Uso de Classes Abstratas para Modelagem de Hierarquias**

**Escolha:** `Cliente` e `Conta` como classes abstratas com métodos abstratos específicos.

**Justificativa:** 
- **Cliente abstrato:** Permite implementar diferentes tipos de cliente (PF/PJ) com comportamentos específicos (taxas diferentes) mantendo a interface comum.
- **Conta abstrata:** Facilita a adição de novos tipos de conta no futuro, garantindo que todas implementem os métodos obrigatórios de cálculo de rendimento e taxa.

### 3. **Implementação de Polimorfismo para Cálculos Financeiros**

**Escolha:** Métodos abstratos `calcularRendimento()` e `calcularTaxaServico()` em `Conta`.

**Justificativa:** Permite que cada tipo de conta implemente sua própria lógica de cálculo, facilitando a manutenção e extensão. O sistema pode calcular rendimentos de forma genérica através de referências polimórficas, sem precisar conhecer o tipo específico de conta.

### 4. **Composição sobre Herança para Investimentos**

**Escolha:** `ContaInvestimentoAutomatico` contém uma lista de `Investimento` em vez de herdar deles.

**Justificativa:** Uma conta de investimento não "é" um investimento, mas "tem" investimentos. Esta abordagem permite que uma conta contenha múltiplos tipos de investimento simultaneamente, oferecendo maior flexibilidade e evitando problemas de herança múltipla.

### 5. **Encapsulamento e Validação de Dados**

**Escolha:** Atributos protegidos com métodos públicos de acesso e validações nos setters.

**Justificativa:** Garante a integridade dos dados e previne estados inválidos. Por exemplo, a validação no `setRaio()` da classe `Circulo` previne raios negativos, e a validação no `sacar()` previne saques maiores que o saldo.

### 6. **Uso de Collections Genéricas**

**Escolha:** `List<Conta>` e `List<Investimento>` com tipos parametrizados.

**Justificativa:** Proporciona type safety em tempo de compilação, evitando erros de runtime relacionados a tipos incorretos. Facilita a iteração e manipulação das coleções de forma segura.

### 7. **Tratamento de Exceções com Mensagens Descritivas**

**Escolha:** Uso de `IllegalArgumentException` e `IllegalStateException` com mensagens claras.

**Justificativa:** Melhora a experiência do desenvolvedor ao debugar problemas e facilita a manutenção do código. As mensagens explicam claramente o que causou o erro.

### 8. **Design de Interface Consistente**

**Escolha:** Métodos `toString()` implementados em todas as classes para representação textual consistente.

**Justificativa:** Facilita o debugging, logging e a interface com o usuário. Todas as entidades podem ser exibidas de forma padronizada.

### 9. **Flexibilidade para Extensões Futuras**

**Escolha:** Estrutura que permite adicionar facilmente novos tipos de cliente, conta ou investimento.

**Justificativa:** O sistema foi projetado para crescer organicamente. Novos tipos podem ser adicionados implementando as interfaces abstratas existentes, sem modificar o código existente (Princípio Open/Closed).

### 10. **Simplicidade e Legibilidade**

**Escolha:** Código limpo, sem comentários desnecessários, com nomes de métodos e variáveis descritivos.

**Justificativa:** Facilita a manutenção, debugging e compreensão do código por outros desenvolvedores. O código se auto-documenta através de nomes significativos.

## Conclusão

O design do protótipo VcRiquinho segue os princípios SOLID e padrões de design estabelecidos, criando uma base sólida para um sistema de investimentos escalável e manutenível. A arquitetura escolhida permite que o sistema evolua naturalmente conforme novos requisitos são identificados, mantendo a coesão alta e o acoplamento baixo entre os componentes. 