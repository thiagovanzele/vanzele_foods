package br.com.vanzelefoods.pagamentos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 12)
    private String numero;

    @NotNull
    private LocalDate dataExpiracao;

    @Size(max = 3, min = 3)
    private String codigo;

    @OneToMany
    private Set<Pagamento> pagamentos = new HashSet<>();

    @ManyToOne
    private Cliente cliente;
}
