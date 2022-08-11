package com.controlevendedores.apirest.repository;

import com.controlevendedores.apirest.domain.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Giovanna Severo
 */
@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Long> {
}
