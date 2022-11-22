package br.com.cronopedia.paginasapi.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronopedia.paginasapi.model.Usuario;
import br.com.cronopedia.paginasapi.repository.UsuarioRepository;
import br.com.cronopedia.paginasapi.security.jwt.JwtUtils;

@CrossOrigin
@RestController
public class UsuarioController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    // Injeção Autowired
    @Autowired
    UsuarioRepository usuarioRepository;

    // Endpoints
    @PostMapping("/sign")
    public void sign(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    // Utilizando o Response Entity para tratar os status e facilitar a exibição no
    // Front-End

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody Usuario usuarioNovo) {
        // Se encontrar no banco, não poderá criar um novo usuário
        boolean exists = usuarioRepository.findByNickname(usuarioNovo.getNickname()).stream().count() > 0;
        // Mas não existir, cra o novo usuário no banco
        if (!exists) {
            // criptografa a senha do usuário para por no banco de dados
            usuarioNovo.setSenha(
                    passwordEncoder.encode(usuarioNovo.getSenha()));
            usuarioRepository.save(usuarioNovo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping("/user")
    public List<Usuario> getAllUsers() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @GetMapping("/user/me")
    public Usuario getMyInformations(@RequestHeader("Authorization") String token) {
        // String token = headers.firstValue("Authorization").get();
        System.out.println(token);
        token = token.substring(7, token.length());
        String username = jwtUtils.getUserNameFromJwtToken(token);
        return usuarioRepository.findByNickname(username).get(0);
    }

    // Rota de verificação de disponibilidade do nickname (true: disponível)
    // @GetMapping("/nickname/check/{name}")
    // public boolean checkNick(@PathVariable("name") String name) {
    // if (usuarioRepository.existByNickname(name)) {
    // return false;
    // }

    // return true;
    // }
}
