package br.com.cronopedia.paginasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cronopedia.paginasapi.model.Pagina;

public interface MetodosCustomInterface {

    // Encontra as paginas relacionadas a tag/assunto
    // Query = SELECT * FROM pagina WHERE id = (SELECT fk_pagina from assuntos WHERE
    // tag = "tagParametro");
    @Query(value = "SELECT * FROM pagina WHERE id = (SELECT fk_pagina from assuntos WHERE tag = :tagParametro)", nativeQuery = true)
    List<Pagina> findByAssuntos(@Param("tagParametro") String tagP);

    // Encontra todas as pagina ordenadas pela relevancia
    @Query(value = "SELECT * FROM pagina ORDER BY relevancia DESC", nativeQuery = true)
    List<Pagina> findAllOrderByRelevanciaDesc();

    // Encontra uma pagina com a maior relevancia
    @Query(value = "SELECT * FROM pagina WHERE relevancia = ( SELECT MAX(relevancia) FROM pagina ", nativeQuery = true)
    Pagina findOneOrderByRelevancia();

}
