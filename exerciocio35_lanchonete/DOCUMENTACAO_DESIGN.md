# Documentação de Design - Sistema de Lanchonete

## Arquitetura do Sistema

### 1. Hierarquia de Classes - Herança

**Classe Abstrata `Prato`:**
- Serve como classe base para todos os produtos da lanchonete
- Contém os atributos comuns: `precoVenda`, `dataValidade`, `peso`
- Define o método abstrato `getDescricao()` que deve ser implementado pelas classes filhas
- Implementa funcionalidades comuns como validação de validade

**Classes Filhas:**
- `Pizza`: Herda de Item e adiciona atributos específicos (recheios, bordas, molhos)
- `Lanche`: Herda de Item e adiciona atributos específicos (tipo do pão, recheio, molhos obrigatórios)
- `Salgadinho`: Herda de Item e adiciona atributos específicos (tipo, massa, recheio)

### 2. Polimorfismo

O polimorfismo é demonstrado principalmente através do método `getDescricao()`:
- Cada classe filha implementa sua própria versão do método
- Permite tratar objetos de diferentes tipos de forma uniforme
- Facilita a extensibilidade do sistema para novos tipos de pratos

### 3. Encapsulamento

**Proteção de Dados:**
- Todos os atributos são declarados como `private` ou `protected`
- Acesso controlado através de métodos getters e setters
- Validações implementadas nos setters quando necessário

**Exemplo de Validação:**
- A classe `Lanche` valida que molhos são obrigatórios
- A classe `Pedido` verifica a validade dos itens antes de adicioná-los

### 4. Classes de Negócio

**Classe `Pedido`:**
- Gerencia a composição de itens de um pedido
- Calcula subtotais, totais e trocos
- Mantém informações do cliente e controle de numeração
- Implementa validações de negócio (itens válidos, valores suficientes)

**Classe `NotaFiscal`:**
- Responsável pela geração de notas fiscais formatadas
- Separa a lógica de apresentação da lógica de negócio
- Calcula e exibe informações de pagamento

## Funcionalidades Implementadas

### 1. Gestão de Cardápio
- Criação de pizzas com múltiplos recheios, bordas personalizáveis e molhos
- Criação de lanches com validação obrigatória de molhos
- Criação de salgadinhos com enum para tipo (frito/assado)

### 2. Gestão de Pedidos
- Adição e remoção de pratos
- Cálculo automático de valores
- Validação de itens dentro da validade
- Controle de numeração sequencial

### 3. Sistema de Pagamento
- Cálculo de troco com validação de valor suficiente
- Geração de nota fiscal completa e formatada
- Tratamento de exceções para valores insuficientes

### 4. Validações de Negócio
- Verificação de validade dos produtos
- Validação de molhos obrigatórios em lanches
- Controle de valores de pagamento

## Padrões de Design Utilizados

### 1. Template Method
- A classe `Item` define a estrutura básica com `toString()`
- As classes filhas implementam `getDescricao()` de forma específica

### 2. Factory Method (Implícito)
- Cada construtor das classes filhas atua como um factory method
- Facilita a criação de objetos com validações específicas

### 3. Composition
- A classe `Pedido` compõe uma lista de `Prato`
- A classe `NotaFiscal` compõe um `Pedido`

## Extensibilidade

O sistema foi projetado para fácil extensão:

### Novos Tipos de Prato
1. Criar nova classe herdando de `Prato`
2. Implementar o método `getDescricao()`
3. Adicionar atributos específicos conforme necessário

### Novas Funcionalidades
- Sistema de desconto pode ser adicionado na classe `Pedido`
- Diferentes formas de pagamento podem ser implementadas
- Sistema de estoque pode ser integrado

## Tratamento de Exceções

- `IllegalArgumentException` para validações de negócio
- Mensagens descritivas para facilitar debugging
- Validações preventivas em construtores e setters

## Considerações de Performance

- Uso de `ArrayList` para listas pequenas (adequado para o contexto)
- Cópia defensiva em getters que retornam coleções
- Formatação de strings otimizada com `StringBuilder`

