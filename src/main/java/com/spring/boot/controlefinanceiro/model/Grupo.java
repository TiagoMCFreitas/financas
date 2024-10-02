package com.spring.boot.controlefinanceiro.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "SENAI_GRUPO")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal saldo = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


    public Grupo(){}
    public Grupo(Long id, String nome, String descricao, BigDecimal saldo, Pessoa pessoa) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.saldo = saldo;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(id, grupo.id) && Objects.equals(nome, grupo.nome) && Objects.equals(descricao, grupo.descricao) && Objects.equals(saldo, grupo.saldo) && Objects.equals(pessoa, grupo.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, saldo, pessoa);
    }
}
