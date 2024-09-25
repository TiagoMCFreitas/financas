package com.controle.financeiro.Model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private float saldo;

    @OneToOne(fetch = FetchType.LAZY)
    private Lancamento lancamento;


    public Grupo() {
    }

    public Grupo(Integer id, String nome, String descricao, float saldo, Lancamento lancamento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.saldo = saldo;
        this.lancamento = lancamento;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Float.compare(saldo, grupo.saldo) == 0 && Objects.equals(id, grupo.id) && Objects.equals(nome, grupo.nome) && Objects.equals(descricao, grupo.descricao) && Objects.equals(lancamento, grupo.lancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, saldo, lancamento);
    }
}
