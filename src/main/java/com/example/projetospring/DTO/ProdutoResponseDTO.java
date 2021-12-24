package com.example.projetospring.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponseDTO {

    private String nome;
    private String codigo;
    private Integer preco;
    private String fornecedor;
    private Integer estoque;
}
