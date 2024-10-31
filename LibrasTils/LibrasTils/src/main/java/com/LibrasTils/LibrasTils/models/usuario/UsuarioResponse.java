package com.LibrasTils.LibrasTils.models.usuario;

public record UsuarioResponse( Long id,String nome, String email) {
    public UsuarioResponse(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());

    }

}
