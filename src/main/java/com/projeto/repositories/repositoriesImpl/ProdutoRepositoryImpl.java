package com.projeto.repositories.repositoriesImpl;

import com.projeto.models.Produto;
import com.projeto.repositories.ProdutoRepository;

import javax.persistence.EntityManager;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepositoryImpl extends SimpleJpaRepository<Produto, Long> implements ProdutoRepository {

    private final ProdutoRepository produtoRepository;

    public ProdutoRepositoryImpl(JpaEntityInformation<Produto, ?> entityInformation, EntityManager entityManager,
            com.projeto.repositories.ProdutoRepository produtoRepository) {
        super(entityInformation, entityManager);
        this.produtoRepository = produtoRepository;
    }

    public ProdutoRepositoryImpl(Class<Produto> domainClass, EntityManager em,
            com.projeto.repositories.ProdutoRepository produtoRepository) {
        super(domainClass, em);
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void ProdutoRepository(String nome) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getByName(String nome) {
        return produtoRepository.getByName(nome);
    }

    public Page<Produto> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

}