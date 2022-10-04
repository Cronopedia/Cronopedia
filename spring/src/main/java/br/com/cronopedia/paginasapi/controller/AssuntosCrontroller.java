package br.com.cronopedia.paginasapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronopedia.paginasapi.model.Assuntos;
import br.com.cronopedia.paginasapi.repository.AssuntosRepository;

@CrossOrigin
@RestController
public class AssuntosCrontroller {
    
    /// Injeção Autowired
    @Autowired
    AssuntosRepository assuntosRepository;

    // Endpoints

    // Registrando uma nova alteração no Banco
    @GetMapping("/topTrends")
    public ResponseEntity<?> topTrends() {
        List<Assuntos> a = assuntosRepository.findAssuntosAllOrderByRelevancia();

        // Header
        HttpHeaders header = new HttpHeaders();

        // Response (200)
        return new ResponseEntity<>(a, header, HttpStatus.OK);
    }
}
