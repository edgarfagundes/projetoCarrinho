package com.projeto.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Carrinho {

    @Id
    private Long id;

    private ArrayList<Produto> produtos = new ArrayList<>();

    public Double total() {
        return produtos.stream().mapToDouble(mapper -> mapper.getPreco()).sum();
    }

    public void addProduct(Produto produto) {
        produtos.add(produto);
    }
}
