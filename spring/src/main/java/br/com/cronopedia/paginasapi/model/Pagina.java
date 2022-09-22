package br.com.cronopedia.paginasapi.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pagina {
    private static Long idCounter = (long) 0;
    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titulo;
    private String autor;

    @Column(name = "date")
    private Date date = new Date();
    
    private String resumo;
    private String conteudo;
    private Long relevancia = (long) 0;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pagina")
    @JsonManagedReference
    private List<Assuntos> assuntos;

    @ManyToMany
    @JoinTable(name = "associacao_pagina_assuntos", joinColumns = @JoinColumn(name = "fk_pagina"), inverseJoinColumns = @JoinColumn(name = "fk_assunto"))
    private ArrayList<manyAssuntos> assuntosMany;

    @OneToMany(mappedBy = "pagina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="fk_imgUrl")
    private ArrayList<String> imagensURL;

    public Pagina() {
    }

}
