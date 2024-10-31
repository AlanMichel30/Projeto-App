package com.LibrasTils.LibrasTils.models.usuario;

import com.LibrasTils.LibrasTils.models.Endereco;
import com.LibrasTils.LibrasTils.models.Genero;

import java.time.LocalDate;
import java.time.LocalTime;

public record UsuarioRequest(
                             String cpf,
                             String userName,
                             String nome,
                             String sobrenome,
                             LocalDate dataNascimento,
                             Genero genero,
                             String telefone,
                             String email,
                             String senha,
                             Endereco endereco
                            ) {

    public Usuario toUsuario(){
        return new Usuario(null, cpf(),userName(),nome(),sobrenome(),dataNascimento(),genero(),telefone(),email(),senha(),endereco());
    }

}
