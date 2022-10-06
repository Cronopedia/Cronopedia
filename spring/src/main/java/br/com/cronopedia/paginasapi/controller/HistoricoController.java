package br.com.cronopedia.paginasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.cronopedia.paginasapi.model.Historico;
import br.com.cronopedia.paginasapi.repository.HistoricoRepository;

@CrossOrigin
@RestController
public class HistoricoController {

    /// Injeção Autowired
    @Autowired
    HistoricoRepository historicoRepository;

    // Endpoints

    // Registrando uma nova alteração no Banco
    @PostMapping("/historico")
    public ResponseEntity<?> saveHistorico(@RequestBody Historico historico) {
        try {
            historicoRepository.save(historico);
            
            // Header
            HttpHeaders header = new HttpHeaders();

            // Response (200)
            return new ResponseEntity<>(null, header, HttpStatus.OK);
        } catch (IllegalArgumentException e) {

            // Header
            HttpHeaders header = new HttpHeaders();
            header.add("mensagem", "Entidade inválida");

            // Response - Entidade inválida (406)
            return new ResponseEntity<>(null, header, HttpStatus.NOT_ACCEPTABLE); // LEMBRAR DE TRATAR NO FRONT-END
        }
    }

    // Encontrando o histórico de alterações de acordo com o ID da Página
    @GetMapping("/historico/pagina/{pageID}")
    public ResponseEntity<?> getHistoricoByPage(@PathVariable("pageID") Long pageID) {
        try {
            List<Historico> h = historicoRepository.findHistoricoByPaginaID(pageID);

            // Header
            HttpHeaders header = new HttpHeaders();

            // Response - Histórico encontrado (200)
            return new ResponseEntity<>(h, header, HttpStatus.OK);
        } catch (Exception e) {
            // Header
            HttpHeaders header = new HttpHeaders();
            header.add("mensagem", "Histórico não encontrado");
            
            // Response - Não encontrado (404)
            return new ResponseEntity<>(null, header, HttpStatus.NOT_FOUND); // LEMBRAR DE TRATAR NO FRONT-END
        }
    }

    // Encontrando uma alteração de acordo com o ID
    @GetMapping("/historico/pagina/{historicoID}")
    public ResponseEntity<?> getHistoricoByID(@PathVariable("historicoID") Long historicoID) {
        try {
            Historico h = historicoRepository.findById(historicoID).get();

            // Header
            HttpHeaders header = new HttpHeaders();
            header.add("mensagem", "Página não encontrada");

            // Response - Alteração encontrada (200)
            return new ResponseEntity<>(h, header, HttpStatus.OK);
        } catch (Exception e) {
            // Header
            HttpHeaders header = new HttpHeaders();
            header.add("mensagem", "Alteração não encontrada");

            // Response - Não encontrada (404)
            return new ResponseEntity<>(null, header, HttpStatus.NOT_FOUND); // LEMBRAR DE TRATAR NO FRONT-END
        }
    }
}
