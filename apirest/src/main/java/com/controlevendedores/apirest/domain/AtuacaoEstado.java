package com.controlevendedores.apirest.domain;

import javax.persistence.*;

/**
 * @author Giovanna Severo
 */

@Entity
@Table(name = "atuacao_estado")
public class AtuacaoEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_atuacao")
    Atuacao atuacao;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    Estado estado;

    public AtuacaoEstado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Atuacao getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(Atuacao atuacao) {
        this.atuacao = atuacao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
