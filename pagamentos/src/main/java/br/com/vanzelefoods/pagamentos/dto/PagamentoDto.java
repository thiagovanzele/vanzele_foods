package br.com.vanzelefoods.pagamentos.dto;

import br.com.vanzelefoods.pagamentos.model.Pagamento;
import br.com.vanzelefoods.pagamentos.model.enums.FormaPagamento;
import br.com.vanzelefoods.pagamentos.model.enums.Status;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class PagamentoDto {

    private Long id;
    private BigDecimal valor;
    private FormaPagamento formaPagamento;
    private Status status;
    private Long pedidoId;

    public static PagamentoDto fromEntity(Pagamento pagamento) {
        PagamentoDtoBuilder builder = PagamentoDto.builder()
                .valor(pagamento.getValor())
                .formaPagamento(pagamento.getFormaPagamento())
                .status(pagamento.getStatus())
                .pedidoId(pagamento.getPedidoId());

        return builder.build();
    }

}
