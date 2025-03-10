package br.com.vanzelefoods.pagamentos.model.exception;

import lombok.Getter;

@Getter
public enum Constants {

    PAGAMENTO_NAO_ENCONTRADO("Pagamento não encontrado");

    private final String msg;

    Constants(String msg) {
        this.msg = msg;
    }
}
