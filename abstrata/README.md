# Sistema de Cadastro de Pessoas

Este projeto implementa um sistema de cadastro de pessoas baseado em orientação a objetos, seguindo o diagrama de classes UML fornecido.

## Estrutura do Projeto

```
abstrata/
├── Data.java                    # Classe para representar datas
├── Pessoa.java                  # Classe abstrata base
├── Cliente.java                 # Subclasse Cliente
├── Funcionario.java             # Subclasse Funcionario
├── Gerente.java                 # Subclasse Gerente (herda de Funcionario)
├── CadastroPessoas.java         # Classe para gerenciar o cadastro
├── TestaCadastro.java           # Classe principal com método main
├── PropostasMelhorias.md        # Documento com propostas de melhorias
└── README.md                    # Este arquivo
```

## Como Compilar

### Opção 1: Compilação Individual
```bash
javac -d . Data.java
javac -d . Pessoa.java
javac -d . Cliente.java
javac -d . Funcionario.java
javac -d . Gerente.java
javac -d . CadastroPessoas.java
javac -d . TestaCadastro.java
```

### Opção 2: Compilação em Lote
```bash
javac -d . *.java
```

## Como Executar

Após a compilação, execute o programa principal:

```bash
java abstrata.TestaCadastro
```

## Funcionalidades

- **Cadastro de Pessoas**: Sistema permite cadastrar clientes, funcionários e gerentes
- **Polimorfismo**: Todas as pessoas implementam o método `imprimeDados()` de forma específica
- **Cálculo de Impostos**: Funcionários e gerentes têm imposto calculado automaticamente
- **Gerenciamento**: Classe `CadastroPessoas` gerencia a lista de pessoas cadastradas

## Exemplo de Saída

```
=== SISTEMA DE CADASTRO DE PESSOAS ===

Cadastrando pessoas...
Pessoa cadastrada com sucesso!
Pessoa cadastrada com sucesso!
Pessoa cadastrada com sucesso!

==================================================

=== CADASTRO DE PESSOAS ===
Quantidade total: 3
===========================

--- Pessoa 1 ---
=== DADOS DO CLIENTE ===
Nome: João Silva
Data de Nascimento: 15/3/1990
Código: 1001
Tipo: Cliente
========================

--- Pessoa 2 ---
=== DADOS DO FUNCIONÁRIO ===
Nome: Maria Santos
Data de Nascimento: 22/7/1985
Salário: R$ 2500,00
Imposto (5%): R$ 125,00
Tipo: Funcionário
============================

--- Pessoa 3 ---
=== DADOS DO GERENTE ===
Nome: Carlos Oliveira
Data de Nascimento: 10/12/1975
Salário: R$ 5000,00
Imposto (5%): R$ 250,00
Área: Vendas
Tipo: Gerente
=======================

=== FIM DO TESTE ===
```

## Características Técnicas

- **Linguagem**: Java
- **Paradigma**: Orientação a Objetos
- **Herança**: Hierarquia de classes com herança simples
- **Polimorfismo**: Método abstrato implementado pelas subclasses
- **Encapsulamento**: Atributos privados com getters e setters
- **Coleções**: Uso de ArrayList para armazenar pessoas
