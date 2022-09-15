package br.com.cronopedia.paginasapi.controller;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
    // @GetMapping("/paginas/{assunto}")
    // public List<Pagina> assuntoPage(@PathVariable("assunto") String assunto) {
    //     return paginaRepository.findByAssuntos(assunto);
    // }

    // Adiciona uma nova página ao repository
    @PostMapping("/paginas/add")
    public void addPage(@RequestBody String e) throws JSONException {
        // Convertendo o corpo da requisição em JSON
        JSONObject json = new JSONObject(e);

        // Instânciando uma nova página com as informações recebidas
        Pagina pagina;
        try {
            pagina = new Pagina(
                    json.getString("titulo"),
                    json.getString("autor"),
                    json.getString("resumo"),
                    json.getString("conteudo"),
                    json.getString("assuntos"),
                    json.getString("url"));

            // Adicionando a página no repositório
            paginaRepository.save(pagina);
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
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

    // Retorna todas as páginas
    // @GetMapping("/paginas/daily")
    // public Long getPaginaDoDia() {
    //     return paginaRepository.findByRelevancia().getId();
    // }
}
