package com.spring.boot.controlefinanceiro.controller;


import com.spring.boot.controlefinanceiro.dto.CadastroDeMetasComGrupos;
import com.spring.boot.controlefinanceiro.model.Meta;
import com.spring.boot.controlefinanceiro.service.MetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meta")
@CrossOrigin("*")
public class MetaController {

    @Autowired
    private MetaService service;

    @GetMapping(value = "/{id}")
    public Meta findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping
    public List<Meta> findAll() {
        return this.service.findAll();
    }

    @PostMapping
    public Meta save(@RequestBody CadastroDeMetasComGrupos meta) {
        return this.service.save(meta);
    }

    @PutMapping
    public Meta update(@RequestBody Meta meta) {
        return this.service.update(meta);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(Long id) {
        this.service.delete(id);
    }

}
