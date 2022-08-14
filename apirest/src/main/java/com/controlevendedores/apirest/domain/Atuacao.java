package com.controlevendedores.apirest.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Giovanna Severo
 */
@Entity
@Table(name = "atuacao")
public class Atuacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String regiao;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "atuacao_estado",
            joinColumns = @JoinColumn(name = "idAtuacao"),
            inverseJoinColumns = @JoinColumn(name = "idEstado"))
    List<Estado> estados;


    public Atuacao() {
    }

    public Atuacao(String regiao, List<Estado> estados) {
        this.regiao = regiao;
        this.estados = estados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

}
