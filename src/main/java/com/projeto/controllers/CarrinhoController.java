package com.projeto.controllers;

import com.projeto.models.Produto;
import com.projeto.repositories.repositoriesImpl.CarrinhoRepositoryImpl;
import com.projeto.repositories.repositoriesImpl.ProdutoRepositoryImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carrinho")
@RequiredArgsConstructor
public class CarrinhoController {

    private final CarrinhoRepositoryImpl carrinhoRepositoryImpl;
    private final ProdutoRepositoryImpl produtoRepositoryImpl;

    @GetMapping("/produtos")
    public ResponseEntity<Page<Produto>> buscaProduto(Pageable pageable) {
        Page<Produto> produto = produtoRepositoryImpl.findAll(pageable);
        try {
            if (!(produto.isEmpty())) {
                return new ResponseEntity(produto, HttpStatus.OK);
            }

            return null;
        } catch (NullPointerException e) {
            throw new Error(e.getCause());
        }
    }
}
