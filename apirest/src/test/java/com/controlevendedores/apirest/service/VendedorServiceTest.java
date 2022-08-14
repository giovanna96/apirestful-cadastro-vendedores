package com.controlevendedores.apirest.service;

import com.controlevendedores.apirest.domain.Vendedor;
import com.controlevendedores.apirest.dto.VendedorDTO;
import com.controlevendedores.apirest.exception.RegistroNaoEncontradoException;
import com.controlevendedores.apirest.repository.AtuacaoRepository;
import com.controlevendedores.apirest.repository.VendedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VendedorServiceTest  {
    @Mock
    private  VendedorRepository vendedorRepository;

    @Mock
    private  AtuacaoRepository atuacaoRepository;

    private VendedorService vendedorService;

    @BeforeEach
    public void init(){
        vendedorService = new VendedorServiceImpl(vendedorRepository,atuacaoRepository);
    }

    @Test
    public void salvarVendedoreSucces(){
        Vendedor vendedor = criarVendedor();

        Vendedor vendedorSalvo = criarVendedor();
        vendedorSalvo.setId(1L);

        when(vendedorRepository.save(any(Vendedor.class))).thenReturn(vendedorSalvo);

        VendedorDTO dto = vendedorDTOFromVendedor(vendedor);
        Vendedor vendedorResposta = vendedorService.salvar(dto);

        verify(vendedorRepository,times(1)).save(any(Vendedor.class));
        assertEquals(vendedorResposta.getId(),vendedorSalvo.getId());
    }

    @Test
    public void listarVendedoresSucces(){
        Vendedor vendedorTest1 = criarVendedor();
        vendedorTest1.setId(1L);

        Vendedor vendedorTest2 = criarVendedor();
        vendedorTest2.setId(2L);

        List<Vendedor> vendedorList = List.of(vendedorTest1,vendedorTest2);
        when(vendedorRepository.findAll()).thenReturn(vendedorList);

        List<VendedorDTO> dtoListResposta = vendedorService.listaVendedores();

        verify(vendedorRepository, times(1)).findAll();
        verify(atuacaoRepository, times(vendedorList.size())).findEstadoByRegiao(anyString());
        assertNotEquals(dtoListResposta.size(),0);
    }

    @Test
    public void listarVendedoresUnSucces(){
        when(vendedorRepository.findAll()).thenReturn(new ArrayList<Vendedor>());
        RegistroNaoEncontradoException exception = assertThrows(RegistroNaoEncontradoException.class,() -> vendedorService.listaVendedores());
        assertEquals("Nenhum registro encontrado.",exception.getMessage());
    }

    @Test
    public void findVendedorByIdSucces(){
        Vendedor vendedor = criarVendedor();
        vendedor.setId(1L);
        VendedorDTO vendedorDTO = vendedorDTOFromVendedor(vendedor);

        when(vendedorRepository.findById(anyLong())).thenReturn(Optional.of(vendedor));

        VendedorDTO dtoResposta = vendedorService.buscaVendedorById(vendedor.getId());

        verify(vendedorRepository, times(1)).findById(anyLong());
        assertNotNull(dtoResposta);
    }

    @Test
    public void findVendedorByIdUnSucces(){
        when(vendedorRepository.findById(anyLong())).thenReturn(Optional.empty());
        RegistroNaoEncontradoException exception = assertThrows(RegistroNaoEncontradoException.class,() -> vendedorService.buscaVendedorById(1L));
        assertEquals("Nenhum registro encontrado.",exception.getMessage());
    }

    public Vendedor criarVendedor(){
        Vendedor vendedor = new Vendedor();
        vendedor.setNome("nome vendedor");
        vendedor.setCidade("cidade vendedor");
        vendedor.setEstado("SP");
        vendedor.setRegiao("sudeste");
        vendedor.setIdade(23);
        vendedor.setTelefone("99 99999-9999");
        vendedor.setDataInclusao(LocalDateTime.now());
        return vendedor;
    }

    public VendedorDTO vendedorDTOFromVendedor(Vendedor vendedor){
        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setNome(vendedor.getNome());
        vendedorDTO.setIdade(vendedor.getIdade());
        vendedorDTO.setCidade(vendedor.getCidade());
        vendedorDTO.setEstado(vendedor.getEstado());
        vendedorDTO.setTelefone(vendedor.getTelefone());
        vendedorDTO.setRegiao(vendedor.getRegiao());
        return vendedorDTO;
    }

}
