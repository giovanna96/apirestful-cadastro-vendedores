package com.controlevendedores.apirest.dto;

import com.controlevendedores.apirest.domain.Estado;

import java.util.List;

public class VendedorDTO {
    String nome;
    String telefone;
    int idade;
    String cidade;
    String estado;
    String regiao;
    List<String> estados;

    public VendedorDTO() {
    }

    public VendedorDTO(String nome, String telefone, int idade, String cidade, String estado, List<String> estados) {
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
        this.estados = estados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

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
