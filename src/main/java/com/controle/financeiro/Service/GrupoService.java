package com.controle.financeiro.Service;

import com.controle.financeiro.Model.Grupo;
import com.controle.financeiro.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public void save(Grupo grupo){
        grupoRepository.save(grupo);
    }

    public List<Grupo> findAll(){
        return grupoRepository.findAll();
    }

    public Grupo findById(int id){
        return grupoRepository.findById(id).orElseThrow();
    }

    public void delete(int id){
        grupoRepository.deleteById(id);
    }

    public void adicionarSaldo(Grupo grupo){
        grupoRepository.save(grupo);
    }

    public void removeSaldo(Grupo grupo){
        grupo.setSaldo(-(grupo.getSaldo()));
        grupoRepository.save(grupo);
    }


}
