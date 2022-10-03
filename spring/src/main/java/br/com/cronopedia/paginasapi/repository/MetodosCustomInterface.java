package br.com.cronopedia.paginasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.cronopedia.paginasapi.model.Historico;
import br.com.cronopedia.paginasapi.model.Pagina;
import br.com.cronopedia.paginasapi.model.Usuario;

public interface MetodosCustomInterface {
    // Queries customizadas

    // Encontra as paginas relacionadas a tag/assunto
    @Query(value = "SELECT * FROM pagina WHERE id = (SELECT fk_pagina from assuntos WHERE tag = :tagParametro)", nativeQuery = true)
    List<Pagina> findPaginasByAssuntos(@Param("tagParametro") String tagP);

    // Encontra todas as pagina ordenadas pela relevancia
    @Query(value = "SELECT * FROM pagina ORDER BY relevancia DESC", nativeQuery = true)
    List<Pagina> findPaginasAllOrderByRelevanciaDesc();

    // Encontra uma pagina com a maior relevancia
    @Query(value = "SELECT * FROM pagina WHERE relevancia = ( SELECT MAX(relevancia) FROM pagina ", nativeQuery = true)
    Pagina findOnePaginaOrderByRelevancia();

    // Query para buscar Usuário no Banco pelo nickname
    @Query(value = "SELECT * FROM usuario WHERE nickname = :nickParametro", nativeQuery = true)
    Usuario findUsuarioByNickname(@Param("nickParametro") String nickname);

    // Query para verificar se um nickname está registrado no Banco
    @Query("SELECT CASE WHEN COUNT(u)> 0 THEN true ELSE false END FROM usuario u WHERE u.nickname LIKE :nickname")
    Boolean existByNickname(@PathVariable("nickParametro") String nickname);

    // // Query para buscar o histórico de edições de uma Página
    // Historico findHistoricoByPaginaID(@Param("paginaID") Long paginaID);
}