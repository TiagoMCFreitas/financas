package com.controle.financeiro.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String tipo;

    @Column
    private float valor;


    public Meta() {
    }



    public Meta(Integer id, String tipo, float valor) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meta meta = (Meta) o;
        return id == meta.id && Float.compare(valor, meta.valor) == 0 && Objects.equals(tipo, meta.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, valor);
    }
}
