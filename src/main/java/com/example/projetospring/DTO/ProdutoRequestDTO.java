package com.example.projetospring.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    @Length(min = 3, max = 50)
    private String nome;

    @Length(min = 9, max = 9)
    private String codigo;

    private Integer preco;

    @Length(min = 3, max = 50)
    private String fornecedor;

    private Integer estoque;
}
