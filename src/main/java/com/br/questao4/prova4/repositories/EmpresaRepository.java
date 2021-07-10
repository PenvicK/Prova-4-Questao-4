package com.br.questao4.prova4.repositories;

import com.br.questao4.prova4.entities.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresas, Long> {
}
