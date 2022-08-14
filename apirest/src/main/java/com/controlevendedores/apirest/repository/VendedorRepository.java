package com.controlevendedores.apirest.repository;

import com.controlevendedores.apirest.domain.Vendedor;
import com.controlevendedores.apirest.dto.VendedorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Giovanna Severo
 */
@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Long> {

}
