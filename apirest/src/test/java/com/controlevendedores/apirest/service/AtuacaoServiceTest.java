package com.controlevendedores.apirest.service;

import com.controlevendedores.apirest.domain.Atuacao;
import com.controlevendedores.apirest.domain.Estado;
import com.controlevendedores.apirest.dto.AtuacaoDTO;
import com.controlevendedores.apirest.repository.AtuacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtuacaoServiceTest {
    @Mock
    private AtuacaoRepository atuacaoRepository;

    private AtuacaoService atuacaoService;

    @BeforeEach
    public void init(){
        atuacaoService = new AtuacaoServiceImpl(atuacaoRepository);
    }

    @Test
    public void salvarAtuacaoSucces(){
        Atuacao atuacao = criarAtuacao();

        Atuacao atuacaoSalva = criarAtuacao();
        atuacaoSalva.setId(1L);

        when(atuacaoRepository.save(any(Atuacao.class))).thenReturn(atuacaoSalva);

        AtuacaoDTO dto = atuacaoDTOFromAtuacao(atuacao);
        Atuacao atuacaoResposta = atuacaoService.salvar(dto);

        verify(atuacaoRepository,times(1)).save(any(Atuacao.class));
        assertEquals(atuacaoResposta.getId(),atuacaoSalva.getId());

    }

    public Atuacao criarAtuacao(){
        List<Estado> estadoList = List.of(new Estado("SP"),
                new Estado("RJ"),
                new Estado("MG"),
                new Estado("ES"));
        Atuacao atuacao = new Atuacao("sudeste",estadoList);
        return atuacao;
    }

    public AtuacaoDTO atuacaoDTOFromAtuacao(Atuacao atuacao){
        List<String> estados= new ArrayList<String>();
        atuacao.getEstados().stream().forEach(estado -> estados.add(estado.getUf()));

        AtuacaoDTO dto = new AtuacaoDTO();
        dto.setRegiao(atuacao.getRegiao());
        dto.setEstados(estados);

        return dto;
    }
}
