package com.pagamentos.model;

public abstract class FormaPagamento {

    protected final double valor;
    protected String status;

    protected FormaPagamento(double valor) {
        this.valor = valor;
        this.status = "PENDENTE";
    }

    protected boolean valorValido() {
        if (valor <= 0) {
            status = "RECUSADO";
            System.out.println("Pagamento recusado: o valor informado (R$" + valor
                    + ") deve ser maior que zero.");
            return false;
        }
        return true;
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public abstract void pagar();

    public abstract void exibirDetalhes();
}
