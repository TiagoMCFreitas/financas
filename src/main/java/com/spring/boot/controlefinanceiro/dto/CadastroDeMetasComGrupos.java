package com.spring.boot.controlefinanceiro.dto;

import com.spring.boot.controlefinanceiro.enums.CategoriaEnum;
import com.spring.boot.controlefinanceiro.enums.TipoLancamentoEnum;
import com.spring.boot.controlefinanceiro.model.Meta;

public class CadastroDeMetasComGrupos {
    private Long id;
    private Long grupoId;
    private String meta;
    private TipoLancamentoEnum tipo;
    private Float valor;
    private String descricao;
    private CategoriaEnum categoria;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public TipoLancamentoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamentoEnum tipo) {
        this.tipo = tipo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public CadastroDeMetasComGrupos(Long id, Long grupoId, String meta, TipoLancamentoEnum tipo, Float valor, String descricao, CategoriaEnum categoria) {
        this.id = id;
        this.grupoId = grupoId;
        this.meta = meta;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public CadastroDeMetasComGrupos() {}

}


