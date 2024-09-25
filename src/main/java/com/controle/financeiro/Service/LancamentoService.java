package com.controle.financeiro.Service;


import com.controle.financeiro.Model.Lancamento;
import com.controle.financeiro.Repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public void save(Lancamento lancamento) {
        lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }

    public Lancamento findById(Integer id) {
        return lancamentoRepository.findById(id).orElseThrow();

    }

    public void delete(Lancamento lancamento) {
        lancamentoRepository.delete(lancamento);
    }

    public void update(Lancamento lancamento) {
        lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> pesquisaPorData(String data){
        return lancamentoRepository.findLancamentosByData(data);
    }

    public List<Lancamento> pesquisaPorValor(float valor){
        return lancamentoRepository.findLancamentosByValor(valor);
    }

    public List<Lancamento> pesquisaPorTipo(String tipo){
        return lancamentoRepository.findLancamentosByTipo(tipo);
    }

    public List<Lancamento> pesquisaPorCategoria(String categoria){
        return lancamentoRepository.findLancamentosByCategoria(categoria);
    }

    public List<Lancamento> relatorioMensal(String inicio, String fim){
        return lancamentoRepository.findPedidosAgrupadosPorTipoLancamento(inicio,fim);
    }
}
