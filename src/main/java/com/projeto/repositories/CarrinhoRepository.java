package com.projeto.repositories;

import com.projeto.models.Carrinho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}
