package com.spring.boot.controlefinanceiro.service;

import com.spring.boot.controlefinanceiro.dto.LancamentoFilterDTO;
import com.spring.boot.controlefinanceiro.exception.custom.NotFoundException;
import com.spring.boot.controlefinanceiro.model.Lancamento;
import com.spring.boot.controlefinanceiro.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    private LancamentoRepository repository;

    @Autowired
    public LancamentoService(LancamentoRepository repository) {
        this.repository = repository;
    }

    public Lancamento findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Lancamento não encontrada"));
    }

    public List<Lancamento> findAll() {
        return this.repository.findAll();
    }

    public Lancamento save(Lancamento lancamento) {
        return this.repository.save(lancamento);
    }

    public Lancamento update(Lancamento lancamento) {
        return this.repository.save(lancamento);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<Lancamento> filter(LancamentoFilterDTO filterDTO) {
        return this.repository.findByNomeContainingOrTipoOrDataOrCategoria(filterDTO.nome(),
                filterDTO.tipo(),
                filterDTO.data(),
                filterDTO.categoria());
    }
}
