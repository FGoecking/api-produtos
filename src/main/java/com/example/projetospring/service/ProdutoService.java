package com.example.projetospring.service;

import com.example.projetospring.DTO.ProdutoRequestDTO;
import com.example.projetospring.DTO.ProdutoResponseDTO;
import com.example.projetospring.model.Produto;
import com.example.projetospring.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = modelMapper.map(produtoRequestDTO, Produto.class);
        Produto produtoSalvo = produtoRepository.save(produto);
        return modelMapper.map(produtoSalvo, ProdutoResponseDTO.class);
    }


    public List<ProdutoResponseDTO> listarClientes() {
        List<ProdutoResponseDTO> produtoResponseDTOList = new ArrayList<>();
        List<Produto> produtoList = (List<Produto>) produtoRepository.findAll();
        produtoList.forEach(produto -> {
            ProdutoResponseDTO produtoResponseDTO = modelMapper.map(produto, ProdutoResponseDTO.class);
            produtoResponseDTOList.add(produtoResponseDTO);
        });
        return produtoResponseDTOList;
    }

    public ProdutoResponseDTO consultarProdutoCodigo(String codigo){
        Produto produto = produtoRepository.findByCodigo(codigo);
        return modelMapper.map(produto, ProdutoResponseDTO.class);
    }

    public void deletarProduto(String codigo) throws Exception {
        Produto produto = produtoRepository.findByCodigo(codigo);
        if(produto != null){
            produtoRepository.deleteById(produto.getId());
        } else {
            throw new Exception("Cliente não encontrado.");
        }
    }

    public void atualizarProduto(ProdutoRequestDTO produtoRequestDTO, String codigo) throws Exception {
        Produto produto = produtoRepository.findByCodigo(codigo);

        if(produto != null){
            modelMapper.map(produtoRequestDTO, produto);
            produtoRepository.save(produto);
        } else {
            throw new Exception("Produto não encontrado.");
        }
    }

}
