package com.controle.financeiro.Controller;

import com.controle.financeiro.Model.Lancamento;
import com.controle.financeiro.Service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;


    @PostMapping("/")
    public void salvarLancamentos(Lancamento lancamento) {
        lancamentoService.save(lancamento);
    }

    @GetMapping("/relatorio/")
    public List<Lancamento> listarLancamentosAgrupados(@RequestParam String inicio, @RequestParam String fim) {
        return lancamentoService.relatorioMensal(inicio, fim);
    }

    @GetMapping("/por-data/")
    public List<Lancamento> listarPorData(@RequestParam String data) {
        return lancamentoService.pesquisaPorData(data);
    }

    @GetMapping("/por-tipo/")
    public List<Lancamento> listarPorTipo(@RequestParam String tipo) {
        return lancamentoService.pesquisaPorTipo(tipo);
    }

    @GetMapping("/por-valor/")
    public List<Lancamento> listarPorValor(@RequestParam float valor) {
        return lancamentoService.pesquisaPorValor(valor);
    }

    @GetMapping("/por-categoria/")
    public List<Lancamento> listarPorCategoria(@RequestParam String categoria) {
        return lancamentoService.pesquisaPorCategoria(categoria);
    }
}
