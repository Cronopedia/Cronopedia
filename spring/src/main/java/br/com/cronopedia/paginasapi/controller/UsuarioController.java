package br.com.cronopedia.paginasapi.controller;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronopedia.paginasapi.model.Usuario;
import br.com.cronopedia.paginasapi.repository.UsuarioRepository;

@CrossOrigin
@RestController
public class UsuarioController {

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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, Object> dados) {

        JSONObject candidato = new JSONObject(dados);

        // Dados do candidato
        String loginDoCandidato;
        String senhaDoCandidato;

        try {
            loginDoCandidato = candidato.getString("nickname");
            senhaDoCandidato = candidato.getString("senha");

            try {
                // Encontra no banco um usuário com o nickname passado
                Usuario usuarioNoBanco = usuarioRepository.findUsuarioByNickname(loginDoCandidato);
                String senhaDoBanco = usuarioNoBanco.getSenha(); // <- Senha pura / sem hash

                // Autenticação
                boolean match = autenticar(senhaDoBanco, senhaDoCandidato);

                if (match) {
                    // Response - Login realizado com sucesso (200)
                    return new ResponseEntity<>(match, null, HttpStatus.OK);
                } else {
                    // Response - Credenciais invalidas (207)
                    return new ResponseEntity<>(match, null, HttpStatus.MULTI_STATUS); // LEMBRAR DE TRATAR NO FRONT-END
                }

            } catch (NoSuchElementException e) {

                // Response - Não encontrado (404)
                return new ResponseEntity<>(false, null, HttpStatus.NOT_FOUND); // LEMBRAR DE TRATAR NO FRONT-END
            }
        } catch (JSONException e) {
            // Response - Erro nas credenciais (400)
            return new ResponseEntity<>(false, null, HttpStatus.BAD_REQUEST); // LEMBRAR DE TRATAR NO FRONT-END
        }

    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> getDados(@PathVariable("id") Long id) {
        try {
            Usuario u = usuarioRepository.findById(id).get();

            // Response - Tudo certo (200)
            return new ResponseEntity<>(u, null, HttpStatus.OK);
        } catch (Exception e) {
            // Response - Não encontrado (404)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // LEMBRAR DE TRATAR NO FRONT-END
        }
    }

    // Passar o método para classe usuário, ou não, tanto faz
    private boolean autenticar(String senhaDoBanco, String senhaDoCandidato) {
        if (senhaDoBanco.equals(senhaDoCandidato)) {
            return true;
        }

        return false;
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
