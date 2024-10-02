package com.spring.boot.controlefinanceiro.service;

import com.spring.boot.controlefinanceiro.dto.AlteracaoGrupo;
import com.spring.boot.controlefinanceiro.dto.CadastroGrupoComPessoaPorId;
import com.spring.boot.controlefinanceiro.exception.custom.NotFoundException;
import com.spring.boot.controlefinanceiro.exception.custom.RegraNegocioException;
import com.spring.boot.controlefinanceiro.model.Grupo;
import com.spring.boot.controlefinanceiro.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository repository;
    @Autowired
    private PessoaService pessoaService;

    public GrupoService(GrupoRepository repository) {
        this.repository = repository;
    }

    public Grupo findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Grupo não encontrada"));
    }

    public List<Grupo> findAll() {
        return this.repository.findAll();
    }

    public Grupo save(CadastroGrupoComPessoaPorId grupo) {
        Grupo grupoSalvar = new Grupo();
        grupoSalvar.setPessoa(pessoaService.findById(grupo.getPessoaId()));
        grupoSalvar.setNome(grupo.getNome());
        grupoSalvar.setDescricao(grupo.getDescricao());

        return this.repository.save(grupoSalvar);
    }

    public Grupo update(AlteracaoGrupo grupo) {
        Grupo grupoAtual = findById(grupo.getGrupoId());
        if (grupo.getPessoaId().equals(grupoAtual.getPessoa().getId())) {
            throw new RegraNegocioException("Propriedade é uma informação que nao é permitido alterar.");
        }
        Grupo grupoSalvar = new Grupo();
        grupoSalvar.setPessoa(pessoaService.findById(grupo.getPessoaId()));
        grupoSalvar.setNome(grupo.getNome());
        grupoSalvar.setDescricao(grupo.getDescricao());
        return this.repository.save(grupoSalvar);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
