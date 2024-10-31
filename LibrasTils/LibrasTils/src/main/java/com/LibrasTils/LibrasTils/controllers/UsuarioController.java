package com.LibrasTils.LibrasTils.controllers;



import com.LibrasTils.LibrasTils.models.usuario.Usuario;
import com.LibrasTils.LibrasTils.models.usuario.UsuarioRequest;
import com.LibrasTils.LibrasTils.models.usuario.UsuarioResponse;
import com.LibrasTils.LibrasTils.repositories.BobyResquest;
import com.LibrasTils.LibrasTils.repositories.FailureResponse;
import com.LibrasTils.LibrasTils.services.PasswordService;
import com.LibrasTils.LibrasTils.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private final PasswordService passwordService;

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping(value = "/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody BobyResquest resquest) {
        //resquest.password();
        var failures = passwordService.validatePass(resquest.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> criar(@RequestBody UsuarioRequest usuario) {
        Usuario novoUsuario = usuarioService.criar(usuario.toUsuario());
        return ResponseEntity.ok(new UsuarioResponse(novoUsuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        List<Usuario> usuarios = usuarioService.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> buscarPorCpf(@PathVariable String cpf) {
        Optional<Usuario> usuario = usuarioService.buscarPorCpf(cpf);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioAtual = usuarioService.buscarPorCpf(usuario.getCpf());
        if (usuarioAtual.isPresent()) {
            Usuario atualizado = usuarioService.atualizar(usuario);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
