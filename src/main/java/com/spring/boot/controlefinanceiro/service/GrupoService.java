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


    private final GrupoRepository grupoRepository;
    private final PessoaService pessoaService;

    @Autowired
    public GrupoService(GrupoRepository grupoRepository, PessoaService pessoaService) {
        this.grupoRepository = grupoRepository;
        this.pessoaService = pessoaService;
    }
    //busca objeto grupo por id
    public Grupo findById(Long id) {
        return this.grupoRepository.findById(id).orElseThrow(() -> new NotFoundException("Grupo não encontrada"));
    }
    //busca todos os objetos de grupo
    public List<Grupo> findAll() {
        return this.grupoRepository.findAll();
    }

    //salvando objeto grupo para quando o saldo for alterado
    public Grupo save(Grupo grupo) {
        return this.grupoRepository.save(grupo);
    }
    //salvando o grupo de acordo com a pessoa cadastrada
    public Grupo savePessoaId(CadastroGrupoComPessoaPorId grupo) {
        Grupo grupoSalvar = new Grupo();
        grupoSalvar.setPessoa(pessoaService.findById(grupo.getPessoaId()));
        grupoSalvar.setNome(grupo.getNome());
        grupoSalvar.setDescricao(grupo.getDescricao());

        return this.grupoRepository.save(grupoSalvar);
    }
    //atualizando objeto grupo
    public Grupo update(AlteracaoGrupo grupo) {
        Grupo grupoAtual = findById(grupo.getGrupoId());
        if (grupo.getPessoaId().equals(grupoAtual.getPessoa().getId())) {
            throw new RegraNegocioException("Propriedade é uma informação que nao é permitido alterar.");
        }
        Grupo grupoSalvar = new Grupo();
        grupoSalvar.setPessoa(pessoaService.findById(grupo.getPessoaId()));
        grupoSalvar.setNome(grupo.getNome());
        grupoSalvar.setDescricao(grupo.getDescricao());
        return this.grupoRepository.save(grupoSalvar);
    }
    //deletando objeto grupo
    public void delete(Long id) {
        this.grupoRepository.deleteById(id);
    }
}
