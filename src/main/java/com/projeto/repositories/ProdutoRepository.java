package com.projeto.repositories;

import com.projeto.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {

    Produto findByNome(String nome);

    Produto addProduto(Produto produto);

    Produto deleteAllById(Long id);
}
