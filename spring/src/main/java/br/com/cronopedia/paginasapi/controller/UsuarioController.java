package br.com.cronopedia.paginasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronopedia.paginasapi.repository.UsuarioRepository;

@CrossOrigin
@RestController
public class UsuarioController {

    // Injeção Autowired
    @Autowired
    UsuarioRepository usuarioRepository;

    // Endpoints

    
}
