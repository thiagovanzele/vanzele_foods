package br.com.vanzelefoods.pagamentos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
public class Cliente {

    private Long id;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private Set<Cartao> cartoes = new HashSet<>();
}
