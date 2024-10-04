package com.spring.boot.controlefinanceiro.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.time.YearMonth;
import java.util.Optional;

import com.spring.boot.controlefinanceiro.enums.CategoriaEnum;
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
    private final GrupoService grupoService;

    @Autowired
    public LancamentoService(LancamentoRepository lancamentoRepository, GrupoService grupoService) {
        this.lancamentoRepository = lancamentoRepository;
        this.grupoService = grupoService;
    }

    //procura objeto lancamento pelo id
    public Lancamento findById(Long id) {
        return this.lancamentoRepository.findById(id).orElseThrow(() -> new NotFoundException("Lançamento não encontrado"));
    }
    //busca todos os objetos lancamento
    public List<Lancamento> findAll() {
        return this.lancamentoRepository.findAll();
    }

    //salva um objeto lancamento, atualizando o valor do saldo do grupo
    public Lancamento save(Lancamento lancamento) {
        // Verifica se o grupoId foi informado
        if (lancamento.getGrupoId() != null) {
            Grupo grupo = grupoService.findById(lancamento.getGrupoId());
            BigDecimal valorOperacao = BigDecimal.valueOf(0);
            //verifica se a operacao foi ENTRADA ou SAIDA, fazendo a operacao de soma e subtracao respectivamente
            //e atualiza o saldo do grupo
            if(lancamento.getTipo() == TipoLancamentoEnum.ENTRADA){
                 valorOperacao = grupo.getSaldo().add(lancamento.getValor());
            }else if(lancamento.getTipo() == TipoLancamentoEnum.SAIDA){
                 valorOperacao = grupo.getSaldo().subtract(lancamento.getValor());
            }
            //seta o saldo do grupo
            grupo.setSaldo(valorOperacao);

            this.grupoService.save(grupo);

            lancamento.setGrupo(grupo); // Define o grupo com o objeto recuperado
        }

        return this.lancamentoRepository.save(lancamento);
    }
    //atualiza objeto lancamento
    public Lancamento update(Lancamento lancamento) {
        // Mesma lógica do save
        if (lancamento.getGrupoId() != null) {
            Grupo grupo = grupoService.findById(lancamento.getGrupoId());
            lancamento.setGrupo(grupo);
        }
        return this.lancamentoRepository.save(lancamento);
    }
    //deleta objeto lancamento
    public void delete(Long id) {
        this.lancamentoRepository.deleteById(id);
    }

//    public List<Lancamento> filter(LancamentoFilterDTO filterDTO) {
//        return this.lancamentoRepository.findByNomeContainingOrTipoOrDataOrCategoria(filterDTO.nome(),
//                filterDTO.tipo(),
//                filterDTO.data(),
//                filterDTO.categoria());
//    }
    //gera um relatorio mensal de acordo com o mes e ano informados
    public List<Lancamento> relatorioMensal(String data, Long id){
        //pega ano e mes da data recebida por parametro
        var ano = Integer.parseInt(data.split("/")[1]);
        var mes = Integer.parseInt(data.split("/")[0]);
        YearMonth anoMes = YearMonth.of(ano, mes);
        // Primeiro dia do mês
        LocalDate primeiroDia = anoMes.atDay(1);
        // Último dia do mês
        LocalDate ultimoDia = anoMes.atEndOfMonth();
        //retornando o json para a criacao do relatório no front
        Grupo grupo = this.grupoService.findById(id);
        return this.lancamentoRepository.findLancamentosByDataBetweenAndGrupoOrderByTipo(primeiroDia,ultimoDia, grupo);

    }
    //relatorio de acordo com o grupo escolhido
    public List<Lancamento> relatorioGrupo(Long id){
        Grupo grupo = this.grupoService.findById(id);
        return this.lancamentoRepository.findAllByGrupoOrderByTipo(grupo);
    }
    //relatorio de acordo com a categoria escolhida
    public List<Lancamento> relatorioCategoria(Long id, String categoria){
        Grupo grupo = this.grupoService.findById(id);
        return this.lancamentoRepository.findAllByCategoriaAndGrupoOrderByTipo(CategoriaEnum.valueOf(categoria),grupo);
    }
}