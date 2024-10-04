package com.spring.boot.controlefinanceiro.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.time.YearMonth;
import java.util.Optional;

import com.spring.boot.controlefinanceiro.enums.TipoLancamentoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.controlefinanceiro.exception.custom.NotFoundException;
import com.spring.boot.controlefinanceiro.model.Grupo;
import com.spring.boot.controlefinanceiro.model.Lancamento;
import com.spring.boot.controlefinanceiro.repository.GrupoRepository;
import com.spring.boot.controlefinanceiro.repository.LancamentoRepository;

@Service
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;
    private final GrupoRepository grupoRepository;

    @Autowired
    public LancamentoService(LancamentoRepository lancamentoRepository, GrupoRepository grupoRepository) {
        this.lancamentoRepository = lancamentoRepository;
        this.grupoRepository = grupoRepository;
    }

    public Lancamento findById(Long id) {
        return this.lancamentoRepository.findById(id).orElseThrow(() -> new NotFoundException("Lançamento não encontrado"));
    }

    public List<Lancamento> findAll() {
        return this.lancamentoRepository.findAll();
    }

    public Lancamento save(Lancamento lancamento) {
        // Verifica se o grupoId foi informado
        if (lancamento.getGrupoId() != null) {
            Grupo grupo = grupoRepository.findById(lancamento.getGrupoId())
                    .orElseThrow(() -> new NotFoundException("Grupo não encontrado com ID: " + lancamento.getGrupoId()));
            BigDecimal valorOperacao = BigDecimal.valueOf(0);
            if(lancamento.getTipo() == TipoLancamentoEnum.ENTRADA){
                 valorOperacao = grupo.getSaldo().add(lancamento.getValor());
            }else if(lancamento.getTipo() == TipoLancamentoEnum.SAIDA){
                 valorOperacao = grupo.getSaldo().subtract(lancamento.getValor());
            }
            grupo.setSaldo(valorOperacao);
            this.grupoRepository.save(grupo);

            lancamento.setGrupo(grupo); // Define o grupo com o objeto recuperado
        }

        return this.lancamentoRepository.save(lancamento);
    }

    public Lancamento update(Lancamento lancamento) {
        // Mesma lógica do save
        if (lancamento.getGrupoId() != null) {
            Grupo grupo = grupoRepository.findById(lancamento.getGrupoId())
                    .orElseThrow(() -> new NotFoundException("Grupo não encontrado com ID: " + lancamento.getGrupoId()));
            lancamento.setGrupo(grupo);
        }
        return this.lancamentoRepository.save(lancamento);
    }

    public void delete(Long id) {
        this.lancamentoRepository.deleteById(id);
    }

//    public List<Lancamento> filter(LancamentoFilterDTO filterDTO) {
//        return this.lancamentoRepository.findByNomeContainingOrTipoOrDataOrCategoria(filterDTO.nome(),
//                filterDTO.tipo(),
//                filterDTO.data(),
//                filterDTO.categoria());
//    }

    public List<Lancamento> relatorioMensal(String data, Long id){
        var ano = Integer.parseInt(data.split("/")[1]);
        var mes = Integer.parseInt(data.split("/")[0]);
        YearMonth anoMes = YearMonth.of(ano, mes);
        LocalDate primeiroDia = anoMes.atDay(1);
        // Último dia do mês
        LocalDate ultimoDia = anoMes.atEndOfMonth();
        Optional<Grupo> grupo = this.grupoRepository.findById(id);
        return this.lancamentoRepository.findLancamentosByDataBetweenAndGrupoOrderByTipo(primeiroDia,ultimoDia, grupo.orElse(null));

    }
}