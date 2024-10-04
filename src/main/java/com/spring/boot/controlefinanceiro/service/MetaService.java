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

    //Importacao de Classes Service e Repository
    private final MetaRepository metaRepository;
    private final GrupoService grupoService;
    @Autowired
    public MetaService(MetaRepository metaRepository, GrupoService grupoService) {
        this.metaRepository = metaRepository;
        this.grupoService = grupoService;
    }
    //busca um objeto Meta com base no id
    public Meta findById(Long id) {
        return this.metaRepository.findById(id).orElseThrow(() -> new NotFoundException("Meta não encontrada"));
    }

    //busca todos os objetos Meta
    public List<Meta> findAll() {
        return this.metaRepository.findAll();
    }

    //salva uma meta
    public Meta save(CadastroDeMetasComGrupos meta) {
        Meta newMeta = new Meta();
        newMeta.setMeta(meta.getMeta());
        //setando grupo com o id que vem no json da meta
        newMeta.setGrupo(grupoService.findById(meta.getGrupoId()));
        //setando os atributos da meta
        newMeta.setTipo(meta.getTipo());
        newMeta.setDescricao(meta.getDescricao());
        newMeta.setCategoria(meta.getCategoria());
        //salvando meta
        return this.metaRepository.save(newMeta);
        }
    //atualiza um objeto meta
    public Meta update(Meta meta) {
        return this.metaRepository.save(meta);
    }

    //deleta um objeto meta
    public void delete(Long id) {
        this.metaRepository.deleteById(id);
    }
}
