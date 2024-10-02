package com.spring.boot.controlefinanceiro.service;

import com.spring.boot.controlefinanceiro.dto.CadastroDeMetasComGrupos;
import com.spring.boot.controlefinanceiro.exception.custom.NotFoundException;
import com.spring.boot.controlefinanceiro.model.Meta;
import com.spring.boot.controlefinanceiro.model.Pessoa;
import com.spring.boot.controlefinanceiro.repository.MetaRepository;
import com.spring.boot.controlefinanceiro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {

    @Autowired
    private MetaRepository repository;
    @Autowired
    private GrupoService grupoService;

    @Autowired
    public MetaService(MetaRepository repository) {
        this.repository = repository;
    }

    public Meta findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Meta não encontrada"));
    }

    public List<Meta> findAll() {
        return this.repository.findAll();
    }

    public Meta save(CadastroDeMetasComGrupos meta) {
        Meta newMeta = new Meta();
        newMeta.setMeta(meta.getMeta());
        newMeta.setGrupo(grupoService.findById(meta.getGrupoId()));
        newMeta.setTipo(meta.getTipo());
        newMeta.setDescricao(meta.getDescricao());
        newMeta.setCategoria(meta.getCategoria());
        return this.repository.save(newMeta);
        }

    public Meta update(Meta meta) {
        return this.repository.save(meta);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
