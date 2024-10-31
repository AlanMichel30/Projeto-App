package com.LibrasTils.LibrasTils.controllers;

import com.LibrasTils.LibrasTils.models.usuario.Usuario;
import com.LibrasTils.LibrasTils.models.usuario.UsuarioRequest;
import com.LibrasTils.LibrasTils.models.usuario.UsuarioResponse;
import com.LibrasTils.LibrasTils.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> criar(@RequestBody UsuarioRequest usuario) {
        Usuario novoUsuario = eventoService.criar(usuario.toUsuario());
        return ResponseEntity.ok(new UsuarioResponse(novoUsuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        List<Usuario> usuarios = eventoService.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> buscarPorCpf(@PathVariable String cpf) {
        Optional<Usuario> usuario = eventoService.buscarPorCpf(cpf);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioAtual = eventoService.buscarPorId(id); // Mudança aqui para buscar pelo ID
        if (usuarioAtual.isPresent()) {
            usuario.setId(id); // Certifique-se de que está definindo o ID do usuário para atualizar corretamente
            Usuario atualizado = eventoService.atualizar(usuario);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        eventoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
