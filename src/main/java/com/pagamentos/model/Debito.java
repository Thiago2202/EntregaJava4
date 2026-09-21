package com.pagamentos.model;

public class Debito extends FormaPagamento {

    private double saldoDisponivel;

    public Debito(double valor, double saldoDisponivel) {
        super(valor);
        this.saldoDisponivel = saldoDisponivel;
    }

    @Override
    public void pagar() {
        if (!valorValido()) {
            return;
        }
        if (valor > saldoDisponivel) {
            status = "RECUSADO";
            System.out.println("Pagamento no Débito recusado: saldo insuficiente (saldo disponível: R$"
                    + saldoDisponivel + ").");
            return;
        }
        saldoDisponivel -= valor;
        status = "APROVADO";
        System.out.println("Pagamento no Débito de R$" + valor
                + " aprovado. Saldo restante: R$" + saldoDisponivel + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[DÉBITO] valor=R$" + valor + " | saldoRestante=R$" + saldoDisponivel
                + " | status=" + status);
    }
}
