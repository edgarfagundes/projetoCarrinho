package com.projeto.repositories.repositoriesImpl;

import com.projeto.models.Produto;
import com.projeto.repositories.ProdutoRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

@Repository
@Transactional(readOnly = true)
public class ProdutoRepositoryImpl extends SimpleJpaRepository<Produto, Long> implements ProdutoRepository {

    public ProdutoRepositoryImpl(EntityManager entityManager) {
        super(Produto.class, entityManager);
    }

    @Override
    public Produto findByNome(String nome) {
        return super.findOne((root, query, builder) -> builder.equal(root.get("nome"), nome))
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    @Override
    public Produto addProduto(Produto produto) {
        return this.save(produto);
    }

    @Override
    public Produto deleteAllById(Long id) {
        return this.deleteAllById(id);
    }


}