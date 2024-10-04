package com.spring.boot.controlefinanceiro.controller;


import com.spring.boot.controlefinanceiro.model.Pessoa;
import com.spring.boot.controlefinanceiro.repository.PessoaRepository;
import com.spring.boot.controlefinanceiro.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin("*")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping
    public List<Pessoa> findAll() {
        return this.service.findAll();
    }

    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa) {
        System.out.println(pessoa);
        return this.service.save(pessoa);
    }

    @PutMapping
    public Pessoa update(@RequestBody Pessoa pessoa) {
        return this.service.update(pessoa);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(Long id){
        this.service.delete(id);
    }

}
