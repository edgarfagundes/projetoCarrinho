package com.projeto.repositories;

import com.projeto.models.Produto;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public void ProdutoRepository(@PathVariable String nome);

    String getByName(String nome);

    public Page<Produto> findAll(Pageable pageable);
}
