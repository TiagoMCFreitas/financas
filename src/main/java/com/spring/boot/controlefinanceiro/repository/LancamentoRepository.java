package com.spring.boot.controlefinanceiro.repository;

import com.spring.boot.controlefinanceiro.enums.CategoriaEnum;
import com.spring.boot.controlefinanceiro.enums.TipoLancamentoEnum;
import com.spring.boot.controlefinanceiro.model.Grupo;
import com.spring.boot.controlefinanceiro.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
      //  List<Lancamento> findByNomeContainingOrTipoOrDataOrCategoria(String nome, TipoLancamentoEnum tipo, LocalDate data, CategoriaEnum categoria);
        List<Lancamento> findLancamentosByDataBetweenAndGrupoOrderByTipo(LocalDate startDate, LocalDate endDate, Grupo grupo);
}
