package br.com.cronopedia.paginasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    // Registrando um novo histórico no Banco
    @PostMapping("/historico")
    public void saveHistorico(@RequestBody Historico historico) {
        historicoRepository.save(historico);
    }

    // Encontrando um histórico de acordo com
    @GetMapping("/historico/pagina/{pageID}")
    public ResponseEntity<?> getHistorico(@PathVariable("pageID") Long pageID) {
        try {
            // Histórico encontrado (200)
            List<Historico> h = historicoRepository.findHistoricoByPaginaID(pageID);
            return new ResponseEntity<>(h, null, HttpStatus.OK);
        } catch (Exception e) {
            // Não encontrado (404)
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND); // Tratar no front-end
        }
    }
}
