package com.controlevendedores.apirest.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Giovanna Severo
 */
@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String uf;

    @ManyToMany(mappedBy = "estados")
    List<Atuacao> atuacoes;

    public Estado() {
    }

    public Estado(String uf) {
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }
}
