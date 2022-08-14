package com.controlevendedores.apirest.service;

import com.controlevendedores.apirest.domain.Atuacao;
import com.controlevendedores.apirest.domain.Estado;
import com.controlevendedores.apirest.dto.AtuacaoDTO;
import com.controlevendedores.apirest.repository.AtuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtuacaoServiceImpl implements AtuacaoService{

    AtuacaoRepository atuacaoRepository;

    @Autowired
    public AtuacaoServiceImpl(AtuacaoRepository atuacaoRepository) {
        this.atuacaoRepository = atuacaoRepository;
    }

    @Override
    @Transactional
    public Atuacao salvar(AtuacaoDTO atuacaoDTO) {
        List<Estado> estados = new ArrayList<Estado>();
        atuacaoDTO.getEstados().stream().forEach(uf -> estados.add(new Estado(uf)));
        Atuacao atuacao = new Atuacao(atuacaoDTO.getRegiao(), estados);
        return atuacaoRepository.save(atuacao);
    }
}
