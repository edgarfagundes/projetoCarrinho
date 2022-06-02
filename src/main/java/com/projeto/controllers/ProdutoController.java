package com.projeto.controllers;

import com.projeto.repositories.repositoriesImpl.ProdutoRepositoryImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoRepositoryImpl produtoRepositoryImpl;

    @DeleteMapping("/deleteByName")
    public void delete(@PathVariable String name) {
        produtoRepositoryImpl.getByName(name);
    }
}
