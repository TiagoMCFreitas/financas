package com.spring.boot.controlefinanceiro.service;

import com.spring.boot.controlefinanceiro.exception.custom.NotFoundException;
import com.spring.boot.controlefinanceiro.model.Pessoa;
import com.spring.boot.controlefinanceiro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
    }

    public List<Pessoa> findAll() {
        return this.repository.findAll();
    }

    public Pessoa save(Pessoa pessoa) {
        return this.repository.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa) {
        return this.repository.save(pessoa);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
