package com.controlevendedores.apirest.service;

import com.controlevendedores.apirest.domain.Atuacao;
import com.controlevendedores.apirest.dto.AtuacaoDTO;
public interface AtuacaoService {
     Atuacao salvar(AtuacaoDTO atuacaoDTO);
}
