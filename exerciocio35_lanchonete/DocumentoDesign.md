# Documento de Design - Sistema de Lanchonete

## 1. Escolhas de Design

### 1.1 Arquitetura Orientada a Objetos
O sistema foi desenvolvido seguindo os princípios da Programação Orientada a Objetos, utilizando:
- **Encapsulamento**: Atributos privados com acesso controlado via getters e setters
- **Herança**: Hierarquia de classes com `Prato` como classe abstrata base
- **Polimorfismo**: Tratamento uniforme de diferentes tipos de pratos através da classe base

### 1.2 Padrão de Design
- **Strategy Pattern**: Cada tipo de prato implementa sua própria lógica de cálculo de preço
- **Composite Pattern**: A classe `Pedido` gerencia uma coleção de objetos `Prato`
- **Template Method**: A classe abstrata `Prato` define a estrutura, mas permite implementações específicas

### 1.3 Estrutura de Classes

#### Hierarquia de Pratos
```
Prato (abstrata)
├── Pizza
├── Lanche
└── Salgadinho
```

**Justificativa**: Esta hierarquia permite:
- Reutilização de código comum (nome, preço, data de validade, peso)
- Extensibilidade para novos tipos de pratos no futuro
- Manutenção centralizada de funcionalidades comuns

#### Classe Pedido
**Responsabilidades**:
- Gerenciar itens do pedido
- Calcular totais e taxas
- Gerar faturas
- Processar pagamentos

**Justificativa**: Centraliza toda a lógica de negócio relacionada aos pedidos, seguindo o princípio de responsabilidade única.

### 1.4 Tratamento de Dados
- **LocalDate**: Para datas de validade, garantindo precisão e facilidade de manipulação
- **ArrayList<Prato>**: Para coleção de itens, permitindo operações dinâmicas
- **Scanner**: Para entrada de dados do usuário de forma interativa

## 2. Funcionamento do Sistema

### 2.1 Fluxo Principal
1. **Criação de Pratos**: O sistema permite criar diferentes tipos de pratos com características específicas
2. **Montagem do Pedido**: Cliente seleciona itens que são adicionados ao pedido
3. **Cálculo de Preços**: Cada prato calcula seu preço final baseado em suas características
4. **Geração da Fatura**: Sistema gera fatura detalhada com todos os itens e valores
5. **Processamento do Pagamento**: Calcula troco e confirma pagamento

### 2.2 Cálculo de Preços
- **Pizza**: Preço base + extras para bordas recheadas e recheios especiais
- **Lanche**: Preço base + extras para pães especiais e recheios premium
- **Salgadinho**: Preço base + extras para versões assadas e massas especiais

### 2.3 Funcionalidades Implementadas
- ✅ Controle de vendas para pizzas, lanches e salgadinhos
- ✅ Atributos obrigatórios: preço, data de validade e peso
- ✅ Criação de pedidos com nome do cliente e itens
- ✅ Cálculo automático de taxas de serviço
- ✅ Geração de notas fiscais detalhadas
- ✅ Cálculo de troco baseado no valor recebido
- ✅ Sistema de preços dinâmicos baseado em características dos pratos

### 2.4 Demonstração de Conceitos

#### Herança
- Todas as classes de pratos herdam de `Prato`
- Compartilham atributos e métodos comuns
- Podem sobrescrever comportamentos específicos

#### Polimorfismo
- Array de `Prato` pode conter qualquer tipo de prato
- Método `calcularPreco()` é chamado polimorficamente
- Tratamento uniforme de diferentes tipos de pratos
