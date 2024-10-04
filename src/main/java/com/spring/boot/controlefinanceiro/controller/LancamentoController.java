package com.spring.boot.controlefinanceiro.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.boot.controlefinanceiro.dto.LancamentoFilterDTO;
import com.spring.boot.controlefinanceiro.model.Lancamento;
import com.spring.boot.controlefinanceiro.service.LancamentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/lancamento")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping(value = "/{id}")
    public Lancamento findById(@PathVariable Long id) {
        return this.lancamentoService.findById(id);
    }

    @GetMapping
    public List<Lancamento> findAll() {
        return this.lancamentoService.findAll();
    }

    @PostMapping
    public Lancamento save(@RequestBody Lancamento lancamento) {
        return this.lancamentoService.save(lancamento);
    }

    @PutMapping
    public Lancamento update(@RequestBody Lancamento lancamento) {
        return this.lancamentoService.update(lancamento);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(Long id) {
        this.lancamentoService.delete(id);
    }

//    @PostMapping(value = "/filter")
//    public List<Lancamento> filter(@RequestBody LancamentoFilterDTO lancamento) {
//        return this.service.filter(lancamento);
//    }
    @GetMapping("/relatorio/mensal")
    public List<Lancamento> relatorioMensal(@RequestParam String  data , Long grupo) {
        return this.lancamentoService.relatorioMensal(data, grupo);
    }

    @GetMapping("/relatorio/grupo")
    public List<Lancamento> relatorioMensal(@RequestParam Long grupo) {
        return this.lancamentoService.relatorioGrupo(grupo);
    }
    @GetMapping("/relatorio/categoria")
    public List<Lancamento> relatorioCategoria(@RequestParam Long grupo, String categoria) {
        return this.lancamentoService.relatorioCategoria(grupo, categoria);
    }

}