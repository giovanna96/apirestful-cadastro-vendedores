package com.controlevendedores.apirest.dto;

import java.util.List;

public class AtuacaoDTO {
    String regiao;
    List<String> estados;

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public List<String> getEstados() {
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }
}
