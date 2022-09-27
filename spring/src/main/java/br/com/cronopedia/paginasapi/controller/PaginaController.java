package br.com.cronopedia.paginasapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronopedia.paginasapi.model.Pagina;
import br.com.cronopedia.paginasapi.repository.PaginaRepository;
import java.util.List;

@CrossOrigin
@RestController
public class PaginaController {

    // Injeção
    @Autowired
    PaginaRepository paginaRepository;

    // Endpoints

    // Retorna todas as páginas
    @GetMapping("/paginas")
    public List<Pagina> allPages() {
        return (List<Pagina>) paginaRepository.findAll();
    }

    // Retorna uma página com o id solicitado no parâmetro
    @GetMapping("/paginas/id/{id}")
    public Pagina idPage(@PathVariable("id") Long id) {
        try {
            Pagina p = paginaRepository.findById(id).stream().toList().get(0);
            return p;
        } catch (IndexOutOfBoundsException e) {
            return Pagina.voidPage();
        }
    }

    // Retorna todas as páginas com o assunto passado no parâmetro
    @GetMapping("/paginas/{assunto}")
    public List<Pagina> assuntoPage(@PathVariable("assunto") String assunto) {
        return paginaRepository.findByAssuntos(assunto);
    }

    // Adiciona uma nova página ao banco
    @PostMapping("/paginas/add")
    public void addPage(@RequestBody Pagina pagina) {
        paginaRepository.save(pagina);
    }

    // Adiciona varias páginas ao banco (para testes)
    @PostMapping("/paginas/addArray")
    public void addPages(@RequestBody List<Pagina> paginas) {
        paginaRepository.saveAll(paginas);
    }

    // Atualizando um campo de uma página
    @PutMapping("/paginas/atualizar/{id}")
    public void update(@RequestBody Pagina pagina) {
        paginaRepository.save(pagina);
    }

    // Deletando uma página
    @DeleteMapping("paginas/deletar/{id}")
    public void delete(@PathVariable("id") Long id) {
        paginaRepository.deleteById(id);
    }

    // @GetMapping("/paginas/top")
    // public Pagina getPaginaD(Long id) {
    // return paginaRepository.;
    // }

    // Json add
    // {
    //     "titulo": "Teste",
    //     "resumo": "Frase para conteuxtualizar o artigo",
    //     "autor": "Jorge F. A.",
    //     "dataPublicacao": "2022-12-31",
    //     "conteudo": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut scelerisque congue felis sed dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus.",
    //     "assuntosMany":[
    //       {"tag": "AssuntoTeste"},
    //       {"tag": "Snow"}
    //     ],
    //     "assuntos":[
    //       {"tag": "AssuntoTeste"},
    //       {"tag": "Snow"}
    //     ],
    //     "imagensURL":[
    //       {"url": "https://..."},
    //       {"url": "https://..."}
    //     ]
    //   }
}
