package com.projeto.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Produto {

    @Id
    private Long id;
    private static Integer quantidade = 0;
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
        quantidade++;
    }

    public static Integer getQuantidade() {
        return quantidade;
    }

}
