package com.LibrasTils.LibrasTils.models.interprete;

import com.LibrasTils.LibrasTils.models.Endereco;
import com.LibrasTils.LibrasTils.models.Genero;
import com.LibrasTils.LibrasTils.models.Tag;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record InterpreteRequest(
                                      String cnpj,
                                      String razaoSocial,
                                      String userName,
                                      String nome,
                                      String sobrenome,
                                      LocalDate dataNascimento,
                                      Genero genero,
                                      String telefone,
                                      String email,
                                      String senha,
                                      Endereco endereco,
                                      Tag tag) {
    public Interprete toInterprete(){
        return new Interprete(null,cnpj(),razaoSocial(),userName(),nome(),sobrenome(),dataNascimento(),genero(),telefone(),email(),senha(),endereco(),tag());
    }
}
