package br.com.cronopedia.paginasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cronopedia.paginasapi.model.Historico;
import br.com.cronopedia.paginasapi.model.Pagina;
import br.com.cronopedia.paginasapi.model.Usuario;

public interface MetodosCustomInterface {
    // Queries customizadas para buscar Paginas no Banco de Dados

    // Encontra as paginas relacionadas a tag/assunto
    @Query(value = "SELECT * FROM pagina WHERE id = (SELECT fk_pagina from assuntos WHERE tag = :tagParametro)", nativeQuery = true)
    List<Pagina> findPaginasByAssuntos(@Param("tagParametro") String tagP);

    // Encontra todas as pagina ordenadas pela relevancia
    @Query(value = "SELECT * FROM pagina ORDER BY relevancia DESC", nativeQuery = true)
    List<Pagina> findPaginasAllOrderByRelevanciaDesc();

    // Encontra uma pagina com a maior relevancia
    @Query(value = "SELECT * FROM pagina WHERE relevancia = ( SELECT MAX(relevancia) FROM pagina ", nativeQuery = true)
    Pagina findOnePaginaOrderByRelevancia();

    // // Query para buscar Usuário no Banco pelo nickname
    // Usuario findUsuarioByNickname(@Param("nick") String nickname);

    // // Query para buscar o histórico de edições de uma Página
    // Historico findHistoricoByPagina(@Param("paginaID") Long paginaID);
}