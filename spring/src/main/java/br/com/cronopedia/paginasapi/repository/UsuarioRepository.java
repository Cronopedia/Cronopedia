package br.com.cronopedia.paginasapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cronopedia.paginasapi.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>, MetodosCustomInterface {

}
