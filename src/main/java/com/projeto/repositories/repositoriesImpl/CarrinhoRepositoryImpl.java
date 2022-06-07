package com.projeto.repositories.repositoriesImpl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.models.Carrinho;
import com.projeto.repositories.CarrinhoRepository;


@Repository
public class CarrinhoRepositoryImpl extends SimpleJpaRepository<Carrinho, Long> implements CarrinhoRepository {

    public CarrinhoRepositoryImpl(EntityManager entityManager) {
        super(Carrinho.class, entityManager);
    }

}
