package com.spring.boot.controlefinanceiro.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.boot.controlefinanceiro.enums.CategoriaEnum;
import com.spring.boot.controlefinanceiro.enums.TipoLancamentoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "SENAI_META")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String meta;
    private BigDecimal valor;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoLancamentoEnum tipo;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;


    public Meta(){

    }



    public Meta(Long id, String meta, BigDecimal valor, String descricao, TipoLancamentoEnum tipo, CategoriaEnum categoria, Grupo grupo) {
        this.id = id;
        this.meta = meta;
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
        this.categoria = categoria;
        this.grupo = grupo;
    }


    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meta meta1 = (Meta) o;
        return Objects.equals(id, meta1.id) && Objects.equals(meta, meta1.meta) && Objects.equals(valor, meta1.valor) && Objects.equals(descricao, meta1.descricao) && tipo == meta1.tipo && categoria == meta1.categoria && Objects.equals(grupo, meta1.grupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, meta, valor, descricao, tipo, categoria, grupo);
    }
}
