package com.projeto.controllers;

import com.projeto.models.Produto;
import com.projeto.services.CarrinhoService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrinho")
@RequiredArgsConstructor
public class CarrinhoController {
    // private final CarrinhoRepositoryImpl carrinhoRepositoryImpl;
    private final CarrinhoService carrinhoService;

    @GetMapping("/produtos")
    public ResponseEntity<Page<Produto>> findProdutos(Pageable pageable) {
        return carrinhoService.findProdutos(pageable);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Optional<Produto>> findProduto(@PathVariable(value = "id") Long id) {
        return carrinhoService.findById(id);
    }

    @PutMapping("/adicionaProduto")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        return carrinhoService.salvarProduto(produto);
    }

    @PostMapping("/atualizaProduto")
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
        return carrinhoService.salvarProduto(produto);
    }

    @DeleteMapping("/deleta/{id}")
    public void deletaProduto(@PathVariable(value = "id") Long id) {
       carrinhoService.deletaProdutoId(id);
    }

}
