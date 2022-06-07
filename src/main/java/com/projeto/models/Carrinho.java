package com.projeto.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Carrinho {

    @Id
    private Long id;

    @OneToMany
    private List<Produto> produtos = new ArrayList<>();

    public Double total() {
        return produtos.stream().mapToDouble(mapper -> mapper.getPreco()).sum();
    }

    public void addProduct(Produto produto) {
        produtos.add(produto);
    }
}
