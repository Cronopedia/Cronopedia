package br.com.cronopedia.paginasapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cronopedia.paginasapi.model.Assuntos;
import br.com.cronopedia.paginasapi.model.Historico;
import br.com.cronopedia.paginasapi.model.Pagina;
import br.com.cronopedia.paginasapi.model.Usuario;

public interface MetodosCustomInterface {
    // Queries customizadas

    // Encontra as paginas relacionadas a tag/assunto
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM pagina WHERE id in (SELECT fk_pagina from pagina_assuntos WHERE fk_assunto = (SELECT id from assuntos WHERE tag LIKE :tag))", nativeQuery = true)
    List<Pagina> findPaginasByAssuntos(@Param("tag") String tagP);

    @Query(value = "SELECT * FROM assuntos WHERE tag = :tag", nativeQuery = true)
    Assuntos findByTag(@Param("tag") String tag);

    // Encontra todas as pagina ordenadas pela relevancia
    @Query(value = "SELECT * FROM pagina ORDER BY relevancia DESC", nativeQuery = true)
    List<Pagina> findPaginasAllOrderByRelevanciaDesc();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pagina_assuntos WHERE fk_pagina = :page_id", nativeQuery = true)
    void deleteAssuntoByPaginaId(@Param("page_id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuario_pagina WHERE pagina_id = :page_id", nativeQuery = true)
    void deleteUsuarioByPaginaId(@Param("page_id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM imagens WHERE pagina_id = :page_id", nativeQuery = true)
    void deleteImagensByPaginaId(@Param("page_id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM historico WHERE pagina_id = :page_id", nativeQuery = true)
    void deleteHistoricoByPaginaId(@Param("page_id") Long id);

    // Update relevancia
    // @Modifying
    // @Transactional
    // @Query(value = "UPDATE pagina SET relevancia = :relevancia WHERE id = :id",
    // nativeQuery = true)
    // Pagina updateRelevanciaPagina(@Param("relevancia") float relevancia,
    // @Param("id") long id);

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT id FROM assuntos WHERE tag LIKE :tag)THEN true ELSE false END", nativeQuery = true)
    Integer existsByTag(@Param("tag") String tag);

    // Encontra uma pagina com a maior relevancia
    @Query(value = "SELECT * FROM pagina WHERE relevancia = ( SELECT MAX(relevancia) FROM pagina)", nativeQuery = true)
    Pagina findOnePaginaOrderByRelevancia();

    // Query para buscar Usu??rio no Banco pelo nickname
    @Query(value = "SELECT * FROM usuario WHERE nickname = :nickParametro", nativeQuery = true)
    Usuario findUsuarioByNickname(@Param("nickParametro") String nickname);

    // Query para verificar se um nickname est?? registrado no Banco
    @Query(value = "SELECT CASE WHEN EXISTS (SELECT id FROM usuario WHERE nickname LIKE :nome)THEN true ELSE false END", nativeQuery = true)
    Integer existByNickname(@Param("nome") String nickname);

    // Query para buscar o hist??rico de edi????es de uma P??gina
    @Query(value = "SELECT * FROM histoico WHERE pagina_id = :paginaID", nativeQuery = true)
    List<Historico> findHistoricoByPaginaID(@Param("paginaID") Long paginaID);

    // Query para encontrar os assuntos mais relevantes (Aooo Top Trends)
    @Query(value = "SELECT * FROM assuntos ORDER BY relevancia DESC", nativeQuery = true)
    List<Assuntos> findAssuntosAllOrderByRelevancia();
}