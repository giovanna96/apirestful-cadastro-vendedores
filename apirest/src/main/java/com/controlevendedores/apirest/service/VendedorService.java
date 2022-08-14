package com.controlevendedores.apirest.service;

import com.controlevendedores.apirest.domain.Vendedor;
import com.controlevendedores.apirest.dto.VendedorDTO;

import java.util.List;

public interface VendedorService {
     List<VendedorDTO> listaVendedores();
     Vendedor salvar(VendedorDTO vendedorDTO);
     VendedorDTO buscaVendedorById(Long id);
}
