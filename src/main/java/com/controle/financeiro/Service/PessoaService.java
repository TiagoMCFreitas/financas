package com.controle.financeiro.Service;

import com.controle.financeiro.Model.Pessoa;
import com.controle.financeiro.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void salvar(Pessoa pessoa) {
        this.pessoaRepository.save(pessoa);
    }

    public void excluir(Integer id) {
        this.pessoaRepository.deleteById(id);
    }

    public Pessoa buscarPorId(Integer id) {
       return this.pessoaRepository.findById(id).orElseThrow();
    }

    public List<Pessoa> listar() {
        return this.pessoaRepository.findAll();
    }


}
