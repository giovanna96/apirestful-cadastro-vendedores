package com.controlevendedores.apirest.repository;

import com.controlevendedores.apirest.domain.Atuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Giovanna Severo
 */
@Repository
public interface AtuacaoRepository extends JpaRepository<Atuacao,Long> {
}
