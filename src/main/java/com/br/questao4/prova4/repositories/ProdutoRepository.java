package com.br.questao4.prova4.repositories;

import com.br.questao4.prova4.entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
}
