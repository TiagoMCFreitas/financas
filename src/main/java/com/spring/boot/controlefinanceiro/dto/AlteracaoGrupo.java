package com.spring.boot.controlefinanceiro.dto;

public class AlteracaoGrupo {
    private Long pessoaId;
    private String nome;
    private String descricao;
    private Long id;

    public AlteracaoGrupo(){

    }
    public AlteracaoGrupo(Long pessoaId, Long id, String nome, String descricao) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
    }

    public Long getGrupoId() {
        return id;
    }

    public void setGrupoId(Long grupoId) {
        this.id = grupoId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long cpf) {
        this.pessoaId = cpf;
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
}
