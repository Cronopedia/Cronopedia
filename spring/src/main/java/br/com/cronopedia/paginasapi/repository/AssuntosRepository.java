package br.com.cronopedia.paginasapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cronopedia.paginasapi.model.Assuntos;

public interface AssuntosRepository extends CrudRepository<Assuntos, Long>, MetodosCustomInterface {
    
}
