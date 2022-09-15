package br.com.cronopedia.paginasapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cronopedia.paginasapi.model.Pagina;

public interface PaginaRepository extends CrudRepository<Pagina, Long>{
    
    // List<Pagina> findByAssuntos(String assunto);

    // Pagina findByRelevancia();
}