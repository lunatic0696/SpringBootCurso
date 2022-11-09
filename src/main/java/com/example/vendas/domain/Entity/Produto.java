package com.example.vendas.domain.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRICAO")
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;
    @Column(name = "PRECO_UNITARIO")
    @NotNull(message = "{campo.preco.obrigatorio}")
    private BigDecimal preco;

}
