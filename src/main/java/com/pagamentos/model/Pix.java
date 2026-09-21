package com.pagamentos.model;

public class Pix extends FormaPagamento {

    private final String chave;

    public Pix(double valor, String chave) {
        super(valor);
        this.chave = chave;
    }

    @Override
    public void pagar() {
        if (!valorValido()) {
            return;
        }
        status = "APROVADO";
        System.out.println("Pagamento via Pix de R$" + valor
                + " aprovado instantaneamente para a chave " + chave + ".");
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("[PIX] valor=R$" + valor + " | chave=" + chave + " | status=" + status);
    }
}
