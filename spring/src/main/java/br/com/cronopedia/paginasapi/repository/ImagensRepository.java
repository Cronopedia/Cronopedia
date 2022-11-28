package br.com.cronopedia.paginasapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cronopedia.paginasapi.model.Imagens;

public interface ImagensRepository extends CrudRepository<Imagens, Long>, MetodosCustomInterface {

}
