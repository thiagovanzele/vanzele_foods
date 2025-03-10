package br.com.vanzelefoods.pagamentos.model;

import br.com.vanzelefoods.pagamentos.dto.PagamentoDto;
import br.com.vanzelefoods.pagamentos.model.enums.Status;
import br.com.vanzelefoods.pagamentos.model.enums.FormaPagamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Builder
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long pedidoId;

    private boolean excluido = false;

    public static Pagamento fromEntity(PagamentoDto pagamentoDto) {
        PagamentoBuilder builder = Pagamento.builder()
                .id(pagamentoDto.getId())
                .formaPagamento(pagamentoDto.getFormaPagamento())
                .pedidoId(pagamentoDto.getPedidoId())
                .status(pagamentoDto.getStatus())
                .valor(pagamentoDto.getValor());

        return builder.build();
    }
}
