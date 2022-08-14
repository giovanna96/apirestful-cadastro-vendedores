package com.controlevendedores.apirest.service;

import com.controlevendedores.apirest.domain.Vendedor;
import com.controlevendedores.apirest.dto.VendedorDTO;
import com.controlevendedores.apirest.exception.RegistroNaoEncontradoException;
import com.controlevendedores.apirest.repository.AtuacaoRepository;
import com.controlevendedores.apirest.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImpl implements VendedorService{
    private final VendedorRepository vendedorRepository;
    private final AtuacaoRepository atuacaoRepository;

    @Autowired
    public VendedorServiceImpl(VendedorRepository vendedorRepository,AtuacaoRepository atuacaoRepository) {
        this.vendedorRepository = vendedorRepository;
        this.atuacaoRepository = atuacaoRepository;
    }

    @Override
    public List<VendedorDTO> listaVendedores() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        if(vendedores.isEmpty()){
            throw new RegistroNaoEncontradoException("Nenhum registro encontrado.");
        }
        List<VendedorDTO> vendedoresDTO = new ArrayList<VendedorDTO>();

        vendedores.stream().forEach(vendedor -> vendedoresDTO.add(new VendedorDTO(
                vendedor.getNome(),
                vendedor.getTelefone(),
                vendedor.getIdade(),
                vendedor.getCidade(),
                vendedor.getEstado(),
                atuacaoRepository.findEstadoByRegiao(vendedor.getRegiao())

        )));
        return vendedoresDTO;
    }

    @Override
    @Transactional
    public Vendedor salvar(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor(
                vendedorDTO.getNome(),
                vendedorDTO.getTelefone(),
                vendedorDTO.getIdade(),
                vendedorDTO.getCidade(),
                vendedorDTO.getRegiao(),
                vendedorDTO.getEstado(),
                LocalDateTime.now());
        return vendedorRepository.save(vendedor);
    }

    @Override
    public VendedorDTO buscaVendedorById(Long id) {
        Optional<Vendedor> vendedor =  vendedorRepository.findById(id);
        if(!vendedor.isPresent()){
            throw  new RegistroNaoEncontradoException("Nenhum registro encontrado.");
        }
        VendedorDTO vendedorDTO =  new VendedorDTO(vendedor.get().getNome(),
                vendedor.get().getTelefone(),
                vendedor.get().getIdade(),
                vendedor.get().getCidade(),
                vendedor.get().getEstado(),
                atuacaoRepository.findEstadoByRegiao(vendedor.get().getRegiao()));
        return vendedorDTO;
    }
}
