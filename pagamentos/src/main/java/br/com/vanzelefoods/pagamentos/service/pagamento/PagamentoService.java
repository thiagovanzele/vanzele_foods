package br.com.vanzelefoods.pagamentos.service.pagamento;

import br.com.vanzelefoods.pagamentos.dto.PagamentoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PagamentoService {

    public Page<PagamentoDto> findAll(Pageable pageable);
    public PagamentoDto buscarPagamentoPorId(Long id);
    public PagamentoDto criarPagamento(PagamentoDto pagamentoDto);
    public PagamentoDto atualizarPagamento(Long id, PagamentoDto pagamentoDto);
    public void ExcluirPagamento(Long id);
}
