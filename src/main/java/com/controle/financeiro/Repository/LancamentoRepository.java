package com.controle.financeiro.Repository;

import com.controle.financeiro.Model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
    public List<Lancamento> findLancamentosByData(String data);
    public List<Lancamento> findLancamentosByValor(float valor);
    public List<Lancamento> findLancamentosByTipo(String tipo);
    public List<Lancamento> findLancamentosByCategoria(String categoria);

    @Query("SELECT l.descricao AS tipoDescricao, COUNT(l.id) AS quantidade " +
            "FROM Lancamento l JOIN l.tipo t " +
            "WHERE l.data BETWEEN :inicio AND :fim " +
            "GROUP BY l.descricao")
    List<Lancamento> findPedidosAgrupadosPorTipoLancamento(
            @Param("inicio") String inicio,
            @Param("fim") String fim);
}
