package com.LibrasTils.LibrasTils.models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "interpretes")
public class Interprete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String razaoSocial;
    private String userName;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String telefone;
    private String email;
    private String senha;
    @Embedded
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private Tag tag;
}

