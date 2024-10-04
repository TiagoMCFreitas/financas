package com.spring.boot.controlefinanceiro.controller;


import com.spring.boot.controlefinanceiro.dto.AlteracaoGrupo;
import com.spring.boot.controlefinanceiro.model.Grupo;
import com.spring.boot.controlefinanceiro.service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.boot.controlefinanceiro.dto.CadastroGrupoComPessoaPorId;
import java.util.List;

@RestController
@RequestMapping("/api/grupo")
@CrossOrigin("*")
public class GrupoController {

    @Autowired
    private GrupoService service;

    @GetMapping(value = "/{id}")
    public Grupo findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping
    public List<Grupo> findAll() {
        return this.service.findAll();
    }

    @PostMapping
    public Grupo save(@RequestBody CadastroGrupoComPessoaPorId grupo) {
        System.out.println(grupo.getPessoaId());
        return this.service.save(grupo);
    }

    @PutMapping
    public Grupo update(@RequestBody AlteracaoGrupo grupo) {
        return this.service.update(grupo);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(Long id) {
        this.service.delete(id);
    }

}
