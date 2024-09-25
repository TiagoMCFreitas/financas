package com.controle.financeiro.Controller;

import com.controle.financeiro.Model.Pessoa;
import com.controle.financeiro.Repository.PessoaRepository;
import com.controle.financeiro.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/")
    public void salvar(Pessoa pessoa){
        System.out.println(pessoa.getCpf());
        pessoaService.salvar(pessoa);
    }
    @DeleteMapping("/")
    public void excluir(Integer id){
        pessoaService.excluir(id);
    }
    @GetMapping("/")
    public List<Pessoa> listar(){
        return pessoaService.listar();
    }


}
