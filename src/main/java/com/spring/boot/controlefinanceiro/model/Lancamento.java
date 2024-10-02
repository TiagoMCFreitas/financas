package com.spring.boot.controlefinanceiro.model;

import com.spring.boot.controlefinanceiro.enums.CategoriaEnum;
import com.spring.boot.controlefinanceiro.enums.TipoLancamentoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "SENAI_LANCAMENTO")
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private TipoLancamentoEnum tipo;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    public Lancamento(){}

    public Lancamento(Long id, String nome, String descricao, BigDecimal valor, LocalDate data, TipoLancamentoEnum tipo, CategoriaEnum categoria, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.categoria = categoria;
        this.grupo = grupo;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TipoLancamentoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamentoEnum tipo) {
        this.tipo = tipo;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(valor, that.valor) && Objects.equals(data, that.data) && tipo == that.tipo && categoria == that.categoria && Objects.equals(grupo, that.grupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, valor, data, tipo, categoria, grupo);
    }
}
