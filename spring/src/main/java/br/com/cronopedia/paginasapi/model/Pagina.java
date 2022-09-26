package br.com.cronopedia.paginasapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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

    @Column(name = "date")
    private Date date = new Date();
    private String resumo;
    private String conteudo;

    private float relevancia = (long) 0;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_url")
    @JsonManagedReference
    private List<Imagens> imagensURL;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pagina")
    @JsonManagedReference
    private List<Assuntos> assuntos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "associacao_pagina_assuntos", joinColumns = @JoinColumn(name = "fk_pagina"), inverseJoinColumns = @JoinColumn(name = "fk_assunto"))
    private List<manyAssuntos> assuntosMany;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public List<manyAssuntos> getAssuntosMany() {
        return assuntosMany;
    }

    public void setAssuntosMany(List<manyAssuntos> assuntosMany) {
        this.assuntosMany = assuntosMany;
    }

    public List<Assuntos> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List<Assuntos> assuntos) {
        this.assuntos = assuntos;
    }

}
