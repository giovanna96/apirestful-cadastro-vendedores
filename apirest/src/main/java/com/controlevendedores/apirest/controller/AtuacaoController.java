package com.controlevendedores.apirest.controller;

import com.controlevendedores.apirest.dto.AtuacaoDTO;
import com.controlevendedores.apirest.service.AtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atuacao")
public class AtuacaoController {
    private final AtuacaoService atuacaoService;

    @Autowired
    public AtuacaoController(AtuacaoService atuacaoService) {
        this.atuacaoService = atuacaoService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody AtuacaoDTO dto){
        atuacaoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
