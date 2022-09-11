package br.com.cronopedia.paginasapi.controller;

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

    // Endpoints

    // Retorna todas as páginas
    @GetMapping("/paginas")
    public List<Pagina> allPages() {
        return PaginaRepository.all();
    }

    // Retorna uma página com o id solicitado no parâmetro
    @GetMapping("/paginas/id/{id}")
    public Pagina idPage(@PathVariable("id") int id) {
        try {
            Pagina p = PaginaRepository.getById(id);
            return p;
        } catch (IndexOutOfBoundsException e) {
            return PaginaRepository.voidPage();
        }
    }

    // Retorna todas as páginas com o assunto passado no parâmetro
    @GetMapping("/paginas/{assunto}")
    public List<Pagina> assuntoPage(@PathVariable("assunto") String assunto) {
        return PaginaRepository.getByAssunto(assunto);
    }

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
            PaginaRepository.add(pagina);
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }

    // Atualiza a página existente no repositório
    // (ATENÇÂO. Vai substituir a página com o id informado por aquela recebida no
    // JSON)
    // @PutMapping("/paginas/atualizar/{id}")
    // public void update(@RequestBody Pagina pagina) {
    // PaginaRepository.update(pagina);
    // }

    // Atualizando um campo de uma página
    @PutMapping("/paginas/atualizar/{campo}/{id}")
    public void update(@RequestBody String conteudo, @PathVariable("campo") int campo, @PathVariable("id") int id) {

        // Gambiarra -> mudar para JSON
        conteudo = conteudo.split(":")[1].toString();
        conteudo = conteudo.substring(1, conteudo.length() - 2);

        PaginaRepository.update(campo, conteudo, id);
    }

    // Deletando uma página
    @DeleteMapping("paginas/deletar/{id}")
    public void delete(@PathVariable("id") int id) {
        PaginaRepository.delete(id);
    }

    // Retorna todas as páginas
    @GetMapping("/paginas/daily")
    public int getPaginaDoDia() {
        return PaginaRepository.getPaginaDoDia();
    }
}
