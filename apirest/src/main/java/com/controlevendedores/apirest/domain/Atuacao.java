package com.controlevendedores.apirest.domain;

import javax.persistence.*;

/**
 * @author Giovanna Severo
 */
@Entity
@Table(name = "atuacao")
public class Atuacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    @JoinColumn(name = "id_regiao")
    Regiao regiao;


    public Atuacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
}
