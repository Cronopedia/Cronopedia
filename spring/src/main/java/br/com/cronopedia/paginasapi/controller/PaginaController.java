package br.com.cronopedia.paginasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronopedia.paginasapi.model.Assuntos;
import br.com.cronopedia.paginasapi.model.Pagina;
import br.com.cronopedia.paginasapi.repository.AssuntosRepository;
import br.com.cronopedia.paginasapi.repository.HistoricoRepository;
import br.com.cronopedia.paginasapi.repository.ImagensRepository;
import br.com.cronopedia.paginasapi.repository.MetodosCustomInterface;
import br.com.cronopedia.paginasapi.repository.PaginaRepository;
import br.com.cronopedia.paginasapi.repository.UsuarioRepository;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
public class PaginaController {

    // Injeção
    @Autowired
    PaginaRepository paginaRepository;

    @Autowired
    AssuntosRepository assuntosRepository;

    @Autowired
    HistoricoRepository historicoRepository;

    @Autowired
    ImagensRepository imagensRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    // Endpoints

    // Retorna todas as páginas
    @GetMapping("/paginas")
    public List<Pagina> allPages() {

        List<Pagina> p = paginaRepository.findPaginasAllOrderByRelevanciaDesc();

        // Removendo do List as páginas com visibilidade false
        for (Pagina pagina : p) {
            if (!pagina.isVisible()) {
                p.remove(pagina);
            }
        }

        return p;
    }

    // Retorna uma página com o id solicitado no parâmetro
    @GetMapping("/paginas/id/{id}")
    public ResponseEntity<?> idPage(@PathVariable("id") Long id) {
        try {
            Pagina p = paginaRepository.findById(id).get();

            if (p.isVisible()) {
                // Página encontrada (200)
                return new ResponseEntity<>(p, null, HttpStatus.OK);
            } else {
                // Página encontrada mas oculta (404)
                HttpHeaders header = new HttpHeaders();
                header.add("mensagem", "Página não pode ser visualizada");

                return new ResponseEntity<>(null, header, HttpStatus.LOCKED); // LEMBRAR DE TRATAR NO FRONT-END
            }
            // elevando a relevancia da página
            // p.consultada();
            // paginaRepository.updateRelevanciaPagina(p.getRelevancia(), p.getId());
        } catch (NoSuchElementException e) {
            // Header
            HttpHeaders header = new HttpHeaders();
            header.add("mensagem", "Página não encontrada");

            // Response - Página não encontrada (404)
            return new ResponseEntity<>(null, header, HttpStatus.NOT_FOUND); // LEMBRAR DE TRATAR NO FRONT-END
        }
    }

    // Retorna todas as páginas com o assunto passado no parâmetro
    @GetMapping("/paginas/{assunto}")
    public ResponseEntity<?> assuntoPage(@PathVariable("assunto") String assunto) {
        try {
            List<Pagina> p = paginaRepository.findPaginasByAssuntos(assunto);

            // Removendo do List as páginas com visibilidade false
            p.stream().filter(e -> !e.isVisible()).forEach(i -> p.remove(i));

            // Response - Páginas encontradas (200)
            return new ResponseEntity<>(p, null, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            // Header
            HttpHeaders header = new HttpHeaders();
            header.add("mensagem", "Não foi encontrada nenhuma página");

            // Response - Páginas não encontradas (404)
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND); // LEMBRAR DE TRATAR NO FRONT-END
        }
    }

    // Adiciona uma nova página ao banco
    @PostMapping("/paginas/add")
    public ResponseEntity<?> addPage(@RequestBody Pagina pagina) {
        try {

            List<Assuntos> assuntos = pagina.getAssuntos();

            assuntos.stream().forEach(i -> {
                if (assuntosRepository.existsByTag(i.getTag()) == 1) {
                    try {
                        assuntos.set(assuntos.indexOf(i), assuntosRepository.findByTag(i.getTag()));
                    } catch (Exception e) {
                        throw new RuntimeException("Assunto já existe!");
                    }

                }
            });

            paginaRepository.save(pagina);

            // Response - (200)
            return new ResponseEntity<>(null, null, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Header
            HttpHeaders header = new HttpHeaders();
            header.add("mensagem", "Entidade inválida");

            // Response - Entidade inválida (406)
            return new ResponseEntity<>(null, header, HttpStatus.NOT_ACCEPTABLE); // LEMBRAR DE TRATAR NO FRONT-END
        }
    }

    // Adiciona varias páginas ao banco (para testes)
    @PostMapping("/paginas/addArray")
    public void addPages(@RequestBody List<Pagina> paginas) {
        paginaRepository.saveAll(paginas);
    }

    // Atualizando um campo de uma página
    @PutMapping("/paginas/atualizar/{id}")
    public void update(@RequestBody Pagina pagina) {
        paginaRepository.save(pagina); // -> Criar uma query replace (irá fazer a substituição dos campos exeto dos
                                       // ids)
    }

    // Atualizando um campo de uma página
    @PutMapping("/paginas/ocultar/{id}")
    public void update(@PathVariable("id") Long id) {
        Pagina p = paginaRepository.findById(id).get();
        p.setVisibilidade(false);
    }

    // Deletando uma página
    @DeleteMapping("paginas/deletar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {

            assuntosRepository.deleteAssuntoByPaginaId(id);
            historicoRepository.deleteHistoricoByPaginaId(id);
            imagensRepository.deleteImagensByPaginaId(id);
            usuarioRepository.deleteUsuarioByPaginaId(id);

            paginaRepository.deleteById(id);

            // Header
            HttpHeaders header = new HttpHeaders();

            // Response - Tudo certo (200)
            return new ResponseEntity<>(null, header, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Header
            HttpHeaders header = new HttpHeaders();
            header.add("mensagem", "Entidade inválida");

            // Response - A Entidade não pode ser deletada (406)
            return new ResponseEntity<>(null, header, HttpStatus.NOT_ACCEPTABLE); // LEMBRAR DE TRATAR NO FRONT-END
        }
    }

    // @GetMapping("/paginas/top")
    // public Pagina getPaginaD(Long id) {
    // return paginaRepository.;
    // }

    // Json add
    // {
    // "titulo": "Teste",
    // "resumo": "Frase para conteuxtualizar o artigo",
    // "autor": "Jorge F. A.",
    // "dataPublicacao": "2022-12-31",
    // "conteudo": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut
    // scelerisque congue felis sed dignissim. In hac habitasse platea dictumst.
    // Interdum et malesuada fames ac ante ipsum primis in faucibus.",
    // "assuntos":[
    // {"tag": "AssuntoTeste"},
    // {"tag": "Snow"}
    // ],
    // "imagensURL":[
    // {"url": "https://..."},
    // {"url": "https://..."}
    // ]
    // }
}
