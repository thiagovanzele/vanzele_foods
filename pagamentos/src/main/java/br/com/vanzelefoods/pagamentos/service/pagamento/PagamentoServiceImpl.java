package br.com.vanzelefoods.pagamentos.service.pagamento;

import br.com.vanzelefoods.pagamentos.dto.PagamentoDto;
import br.com.vanzelefoods.pagamentos.model.Pagamento;
import br.com.vanzelefoods.pagamentos.model.enums.Status;
import br.com.vanzelefoods.pagamentos.model.exception.VanzeleObjectNotFoundException;
import br.com.vanzelefoods.pagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static br.com.vanzelefoods.pagamentos.model.exception.Constants.PAGAMENTO_NAO_ENCONTRADO;

public class PagamentoServiceImpl implements PagamentoService{

    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Page<PagamentoDto> findAll(Pageable pageable) {
        return pagamentoRepository.findAll(pageable)
                .map(PagamentoDto::fromEntity);
    }

    @Override
    public PagamentoDto buscarPagamentoPorId(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(() -> new VanzeleObjectNotFoundException(PAGAMENTO_NAO_ENCONTRADO.getMsg()));
        return PagamentoDto.fromEntity(pagamento);
    }

    @Override
    public PagamentoDto criarPagamento(PagamentoDto pagamentoDto) {
        Pagamento pagamento = Pagamento.fromEntity(pagamentoDto);
        pagamento.setStatus(Status.CRIADO);
        pagamentoRepository.save(pagamento);

        return PagamentoDto.fromEntity(pagamento);
    }

    @Override
    public PagamentoDto atualizarPagamento(Long id, PagamentoDto pagamentoDto) {
        Pagamento pagamento = Pagamento.fromEntity(buscarPagamentoPorId(id));
        pagamento.setId(id);
        pagamento = pagamentoRepository.save(pagamento);
        return PagamentoDto.fromEntity(pagamento);
    }

    @Override
    public void ExcluirPagamento(Long id) {
        Pagamento pagamento = Pagamento.fromEntity(buscarPagamentoPorId(id));
        pagamento.setExcluido(true);
        pagamentoRepository.save(pagamento);
    }
}
