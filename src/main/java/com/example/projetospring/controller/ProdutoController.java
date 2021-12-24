package com.example.projetospring.controller;

import com.example.projetospring.DTO.ProdutoRequestDTO;
import com.example.projetospring.DTO.ProdutoResponseDTO;
import com.example.projetospring.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("produto")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ApiOperation(value = "Persiste um novo produto no banco de dados.")
    public ProdutoResponseDTO criarProduto(@Validated @RequestBody ProdutoRequestDTO produtoRequestDTO){
        ProdutoResponseDTO produtoSalvo = produtoService.criarProduto(produtoRequestDTO);
        return produtoSalvo;
    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de todos os produtos salvos no banco de dados.")
    public List<ProdutoResponseDTO> listarProdutos(){
        return produtoService.listarClientes();
    }

    @GetMapping("/{codigo}/codigo")
    @ApiOperation(value = "Retorna um produto do banco de dados cujo código é igual o parametro recebido.")
    public ProdutoResponseDTO consultarProdutoPorCodigo(@PathVariable String codigo){
        return produtoService.consultarProdutoCodigo(codigo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deleta um produto do banco de dados cujo código seja igual ao parametro recebido.")
    public void deletarProdutoPorCodigo(@PathVariable String codigo) throws Exception {
        produtoService.deletarProduto(codigo);
    }

    @PutMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualiza um produto do banco de dados cujo código seja igual ao parametro recebido.")
    public void atualizarProdutoPorCodigo(@PathVariable String codigo, @RequestBody ProdutoRequestDTO produtoRequestDTO ) throws Exception{
                produtoService.atualizarProduto(produtoRequestDTO, codigo);
    }
}
