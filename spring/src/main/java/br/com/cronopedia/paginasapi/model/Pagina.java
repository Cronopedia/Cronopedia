package br.com.cronopedia.paginasapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
    private Date dataPublicacao;
    private String resumo;
    private String conteudo;

    private float relevancia = 0; // A cada nova consulta a página, se deve calcular uma nova relevancia;

    // associação das Imagens
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_url")
    @JsonManagedReference
    private List<Imagens> imagensURL;

    // Associação dos Assuntos
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pagina")
    @JsonManagedReference
    private List<Assuntos> assuntos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "associacao_pagina_assuntos", joinColumns = @JoinColumn(name = "fk_pagina"), inverseJoinColumns = @JoinColumn(name = "fk_assunto"))
    private List<manyAssuntos> assuntosMany;

    // Associação dos Históricos
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_edicao")
    @JsonManagedReference
    private List<Historico> historicos;

    // ManyToMany com usuário (varias paginas poderão ser propriedade de varios
    // usuários) -> princípio da colaboração
    // Associação dos Assuntos
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pagina")
    @JsonManagedReference
    private List<Usuario> usuarios;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "associacao_pagina_usuario", joinColumns = @JoinColumn(name = "fk_pagina"), inverseJoinColumns = @JoinColumn(name = "fk_usuario"))
    private List<manyUsuarios> usuariosMany;

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

    public List<manyAssuntos> getAssuntosMany() {
        return assuntosMany;
    }

    public void setAssuntosMany(List<manyAssuntos> assuntosMany) {
        this.assuntosMany = assuntosMany;
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

    public List<manyUsuarios> getUsuariosMany() {
        return usuariosMany;
    }

    public void setUsuariosMany(List<manyUsuarios> usuariosMany) {
        this.usuariosMany = usuariosMany;
    }

}
