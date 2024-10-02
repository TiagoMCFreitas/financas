package com.spring.boot.controlefinanceiro.dto;

public class CadastroGrupoComPessoaPorId {
    private Long pessoaId;
    private String nome;
    private String descricao;

    public CadastroGrupoComPessoaPorId(){

    }
    public CadastroGrupoComPessoaPorId(Long pessoaId, String nome, String descricao) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.descricao = descricao;
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
