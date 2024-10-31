package com.LibrasTils.LibrasTils.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro"),
    NAO_BINARIO("Nao_binario");

    private final String valor;

    Genero(String valor) {
        this.valor = valor;
    }

    @JsonValue
    public String getValor() {
        return valor;
    }

    @JsonCreator
    public static Genero fromValue(String valor) {
        for (Genero genero : Genero.values()) {
            if (genero.valor.equalsIgnoreCase(valor)) {
                return genero;
            }
        }
        throw new IllegalArgumentException("Gênero inválido: " + valor);
    }
}

