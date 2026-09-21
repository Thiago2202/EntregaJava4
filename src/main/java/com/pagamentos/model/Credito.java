package com.pagamentos.model;

public class Credito extends FormaPagamento {

    private double limiteDisponivel;
    private final int parcelas;

    public Credito(double valor, double limiteDisponivel, int parcelas) {
        super(valor);
        this.limiteDisponivel = limiteDisponivel;
        this.parcelas = parcelas;
    }

    @Override
    public void pagar() {
        if (!valorValido()) {
            return;
        }
        if (valor > limiteDisponivel) {
            status = "RECUSADO";
            System.out.println("Pagamento no Crédito recusado: limite insuficiente (limite disponível: R$"
                    + limiteDisponivel + ").");
            return;
        }
        limiteDisponivel -= valor;
        status = "APROVADO";
        System.out.println("Pagamento no Crédito de R$" + valor + " aprovado em " + parcelas
                + "x. Limite restante: R$" + limiteDisponivel + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[CRÉDITO] valor=R$" + valor + " | parcelas=" + parcelas + "x | limiteRestante=R$"
                + limiteDisponivel + " | status=" + status);
    }
}
