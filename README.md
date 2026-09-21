# Sistema de Pagamentos

Exercício de Programação Orientada a Objetos em Java: núcleo de um sistema de pagamentos com herança e polimorfismo.

## Estrutura

`FormaPagamento` é uma classe **abstrata** (não pode ser instanciada diretamente) com o valor cobrado e o status do pagamento. Ela concentra a validação comum a todas as formas de pagamento: um valor zero ou negativo é sempre recusado, com mensagem no console.

Três subclasses herdam de `FormaPagamento` e implementam `pagar()` e `exibirDetalhes()` de forma própria:

- **Pix** — aprovado instantaneamente se o valor for válido.
- **Débito** — verifica se há saldo disponível suficiente antes de aprovar.
- **Crédito** — verifica se há limite disponível suficiente e informa o parcelamento.

```
src/main/java/com/pagamentos/
├── Main.java
└── model/
    ├── FormaPagamento.java
    ├── Pix.java
    ├── Debito.java
    └── Credito.java
```

## Como executar

Com Maven:

```bash
mvn compile exec:java -Dexec.mainClass="com.pagamentos.Main"
```

Ou compilando manualmente:

```bash
javac -d out $(find src -name "*.java")
java -cp out com.pagamentos.Main
```

## Cenários demonstrados em `Main`

1. Pagamento via Pix aprovado.
2. Pagamento no Débito aprovado (saldo suficiente).
3. Pagamento no Crédito aprovado (limite suficiente).
4. Pagamento no Débito recusado por saldo insuficiente.
5. Pagamento recusado por valor inválido (zero).
# EntregaJava4
