package com.LibrasTils.LibrasTils.controllers;

import com.LibrasTils.LibrasTils.models.usuario.Usuario;
import com.LibrasTils.LibrasTils.models.usuario.UsuarioRequest;
import com.LibrasTils.LibrasTils.models.usuario.UsuarioResponse;
import com.LibrasTils.LibrasTils.services.InterpreteService;
import com.LibrasTils.LibrasTils.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interpretes")
public class InterpreteController {

    @Autowired
    private InterpreteService interpreteService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> criar(@RequestBody UsuarioRequest usuario) {
        Usuario novoUsuario = interpreteService.criar(usuario.toUsuario());
        return ResponseEntity.ok(new UsuarioResponse(novoUsuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        List<Usuario> usuarios = interpreteService.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> buscarPorCpf(@PathVariable String cpf) {
        Optional<Usuario> usuario = interpreteService.buscarPorCpf(cpf);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioAtual = interpreteService.buscarPorCpf(usuario.getCpf());
        if (usuarioAtual.isPresent()) {
            Usuario atualizado = interpreteService.atualizar(usuario);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        interpreteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

