package br.com.cronopedia.paginasapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pagina {
    public static Pagina voidPage() {
        return null;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String autor;
    private Date dataPublicacao;
    private String resumo;

    private Boolean visibilidade = true;

    @Column(columnDefinition = "longtext")
    private String conteudo;

    private float relevancia = 0; // A cada nova consulta a página, se deve calcular uma nova relevancia;

    // associação das Imagens
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_url")
    @JsonManagedReference
    private List<Imagens> imagensURL;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "pagina_assuntos", joinColumns = @JoinColumn(name = "fk_pagina"), inverseJoinColumns = @JoinColumn(name = "fk_assunto"))
    @JsonManagedReference
    private List<Assuntos> assuntos;

    // Associação dos Históricos
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_edicao")
    @JsonManagedReference
    private List<Historico> historicos;

    // ManyToMany com usuário (varias paginas poderão ser propriedade de varios
    // usuários) -> princípio da colaboração
    // Associação dos Assuntos
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "paginas")
    @JsonBackReference
    private List<Usuario> usuarios;

    public Pagina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public float getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(float relevancia) {
        this.relevancia = relevancia;
    }

    public List<Imagens> getImagensURL() {
        return imagensURL;
    }

    public void setImagensURL(List<Imagens> imagensURL) {
        this.imagensURL = imagensURL;
    }

    public List<Assuntos> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List<Assuntos> assuntos) {
        this.assuntos = assuntos;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void consultada() {
        this.relevancia += 0.001;
    }

    public void setVisibilidade(Boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public Boolean isVisible() {
        return visibilidade;
    }
}
