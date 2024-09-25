package com.controle.financeiro.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private String data;

    @Column
    private String tipo;

    @Column
    private float valor;

    @Column
    private String categoria;

    @OneToOne
    private Pessoa pessoa;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Lancamento() {
    }

    public Lancamento(Integer id, String nome, String descricao, String data, String tipo, float valor, String categoria,Pessoa pessoa) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return Float.compare(valor, that.valor) == 0 && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(data, that.data) && Objects.equals(tipo, that.tipo) && Objects.equals(categoria, that.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, data, tipo, valor, categoria);
    }
}

