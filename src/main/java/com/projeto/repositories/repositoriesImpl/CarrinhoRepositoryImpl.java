package com.projeto.repositories.repositoriesImpl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.projeto.repositories.CarrinhoRepository;

import lombok.RequiredArgsConstructor;

@Transactional
@Repository
@RequiredArgsConstructor
public abstract class CarrinhoRepositoryImpl implements CarrinhoRepository {

}
