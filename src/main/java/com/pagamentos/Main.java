package com.pagamentos;

import com.pagamentos.model.Credito;
import com.pagamentos.model.Debito;
import com.pagamentos.model.FormaPagamento;
import com.pagamentos.model.Pix;

public class Main {

    public static void main(String[] args) {
        FormaPagamento pix = new Pix(150.0, "cliente@example.com");
        FormaPagamento debito = new Debito(200.0, 500.0);
        FormaPagamento credito = new Credito(1200.0, 1500.0, 3);

        System.out.println("=== Pix ===");
        pix.pagar();
        pix.exibirDetalhes();

        System.out.println();
        System.out.println("=== Débito ===");
        debito.pagar();
        debito.exibirDetalhes();

        System.out.println();
        System.out.println("=== Crédito ===");
        credito.pagar();
        credito.exibirDetalhes();

        System.out.println();
        System.out.println("=== Débito com saldo insuficiente ===");
        FormaPagamento debitoSemSaldo = new Debito(300.0, 100.0);
        debitoSemSaldo.pagar();
        debitoSemSaldo.exibirDetalhes();

        System.out.println();
        System.out.println("=== Pagamento com valor inválido ===");
        FormaPagamento pixInvalido = new Pix(0.0, "cliente@example.com");
        pixInvalido.pagar();
        pixInvalido.exibirDetalhes();
    }
}
