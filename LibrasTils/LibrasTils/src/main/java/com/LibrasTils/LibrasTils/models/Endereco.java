package com.LibrasTils.LibrasTils.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String numero;
}
