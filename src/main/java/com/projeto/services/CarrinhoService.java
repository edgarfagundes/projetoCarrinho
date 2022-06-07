package com.projeto.services;

import com.projeto.models.Produto;
import com.projeto.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarrinhoService {

    private final ProdutoRepository produtoRepository;

    public ResponseEntity<Page<Produto>> findProdutos(Pageable pageable) {
        Page<Produto> produto = produtoRepository.findAll(pageable);
        try {
            if (produto.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } catch (NullPointerException e) {
            throw new Error(e.getCause());
        }
    }

    public ResponseEntity<Optional<Produto>> findById(Long id) {
        Optional<Produto> produtoId = produtoRepository.findById(id);
        try {
            if (produtoId.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NullPointerException n) {
            throw new Error(n.getCause());
        }
    }

    public ResponseEntity<Produto> salvarProduto(Produto produto) {
        Produto produtoSalvo = produtoRepository.addProduto(produto);
        try {
            return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public void deletaProdutoId(Long id) {
        try {
            produtoRepository.deleteAllById(id);
        }catch(NullPointerException n){
            throw new Error(n.getMessage());
        }
    }
}
