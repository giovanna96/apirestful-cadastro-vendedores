package com.controlevendedores.apirest.repository;

import com.controlevendedores.apirest.domain.Atuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Giovanna Severo
 */
@Repository
public interface AtuacaoRepository extends JpaRepository<Atuacao,Long> {
    @Query(value = " SELECT e.uf FROM estado e " +
            " INNER JOIN atuacao_estado ae ON ae.id_estado = e.id " +
            " INNER JOIN atuacao a ON a.id = ae.id_atuacao " +
            " WHERE UPPER(a.regiao) = UPPER(:regiao) ", nativeQuery = true)
    List<String> findEstadoByRegiao(String regiao);
}
